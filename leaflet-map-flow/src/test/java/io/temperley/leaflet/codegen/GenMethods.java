package io.temperley.leaflet.codegen;

import com.squareup.javapoet.*;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.OptionsBase;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.temperley.leaflet.codegen.ResourceUtils.getFile;

public class GenMethods {

    private static List<MethodDefinition> getMethodsFromFile(String fileName) throws IOException, URISyntaxException {
        Stream<String> lines = getFile(fileName);

        Stream<MethodDefinition> stream = lines
                .map(f -> f.split("\t"))
                .map(f -> new MethodDefinition(f[0], f[1], f[2]));

        return stream.collect(Collectors.toList());
    }

    public static List<ParameterSpec> buildParamList(String paramString) {

        List<ParameterSpec> parameterSpecs = new ArrayList<>();
        if (paramString.isEmpty()) {
            return parameterSpecs;
        }
        String[] split = paramString.split(",");

        for (String singleParamString : split) {
            String regex;
            if (singleParamString.contains(">")) {
                regex = "> ";
            } else {
                regex = " ";
            }
            String[] typeAndVar = singleParamString.split(regex);
            String name = typeAndVar[1];
            ClassName className = CoerceTypes.classForJSType(typeAndVar[0]);
            name = name.replace("?", "Optional");
            parameterSpecs.add(ParameterSpec.builder(className, name).build());

        }

        return parameterSpecs;
    }

    public static void genMethods(TagInfo tagInfo, Class superclass) throws IOException, URISyntaxException {

        //build class
        TypeSpec.Builder builder = TypeSpec.classBuilder(tagInfo.getSimpleName(false))
                .addAnnotation(
                        AnnotationSpec.builder(Tag.class)
                            .addMember("value", "$S", tagInfo.getTagName())
                            .build()
                )
                .addAnnotation(
                        AnnotationSpec.builder(HtmlImport.class)
                            .addMember("value", "$S", tagInfo.getHtmlImport())
                            .build()
                )
                .addModifiers(Modifier.PUBLIC);


        //add superclass if required
        if (superclass != null) {
            builder = builder.superclass(superclass);
        }

        MethodSpec ctor = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(OptionsBase.class, "options")
                .addStatement("super(options)")
                .build();

        builder.addMethod(ctor);

        List<MethodDefinition> methods = getMethodsFromFile(tagInfo.getFileName(false));
        for (MethodDefinition option : methods) {

            //whole method def
            String methodString = option.getMethodString();
            //just params
            String paramString = methodString.substring(methodString.indexOf('(') + 1, methodString.indexOf(')'));
            String methodName = methodString.substring(0, methodString.indexOf('('));

            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(methodName)
                    .addModifiers(Modifier.PUBLIC)
                    .returns(void.class);

            String propertyName = methodName.substring(3).toLowerCase();


            //method params
            List<ParameterSpec> parameterSpecs = buildParamList(paramString);
            methodBuilder.addParameters(parameterSpecs);

            if (methodString.startsWith("get")) {
                methodBuilder.addStatement("return getElement().getProperty($S)", propertyName);
                ClassName returnClass = CoerceTypes.classForJSType(option.getReturnType());
                methodBuilder.returns(returnClass);
            } else if (methodString.startsWith("set")) {

                for (ParameterSpec parameterSpec : parameterSpecs) {
                    methodBuilder.addStatement("setProperty($S, " + parameterSpec.name + ")", parameterSpec.name);
                }



            } else if (methodName.equals("remove")) {
                methodBuilder.addStatement("getElement().removeFromParent()");
            }

//                    .build();
//            methodBuilder.addStatement("return this");


            methodBuilder.addJavadoc(option.getDescription());
            methodBuilder.addJavadoc("\n");

            builder.addMethod(methodBuilder.build());

        }

        TypeSpec built = builder.build();

        JavaFile javaFile = JavaFile.builder(tagInfo.packageName, built)
                .build();

        javaFile.writeTo(new File("./leaflet-map-flow/src/main/java").toPath());

    }

}
