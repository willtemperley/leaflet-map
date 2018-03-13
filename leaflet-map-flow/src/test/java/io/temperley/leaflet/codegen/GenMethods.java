package io.temperley.leaflet.codegen;

import com.squareup.javapoet.*;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.options.OptionsBase;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

import static io.temperley.leaflet.codegen.ResourceUtils.getFile;

public class GenMethods {

    public static List<MethodDefinition> getMethodsFromFile(String fileName) throws IOException, URISyntaxException {

        List<String> lines = getFile(fileName).collect(Collectors.toList());

        List<MethodDefinition> methodDefinitions = new ArrayList<>();
        for (String line : lines) {
            String[] f = line.split("\t");
            if (f.length != 3) {
                throw new RuntimeException("File: " + fileName + ". Invalid entry: " + line);
            }
            List<MethodDefinition> defs = MethodDefinition.getDefs(f[0], f[1], f[2]);
            methodDefinitions.addAll(defs);
        }

        return methodDefinitions;

    }


    public static void genMethods(TagInfo tagInfo) throws IOException, URISyntaxException {

        //build class
        String formatString = "Abstract%s";
        String simpleName = String.format(formatString, tagInfo.getSimpleName());

        TypeSpec.Builder builder = TypeSpec.classBuilder(simpleName)
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
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);

        //add superclass if required
        ClassName superclass = tagInfo.getSuperClassName("Abstract%s");
        builder = builder.superclass(superclass);


        MethodSpec ctor = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(OptionsBase.class, "options")
                .addStatement("super(options)")
                .build();

        builder.addMethod(ctor);

        List<MethodDefinition> methods = getMethodsFromFile(tagInfo.getFileName());

        for (MethodDefinition option : methods) {

            //whole method def
            String methodName = option.getMethodName();

            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(methodName)
                    .addModifiers(Modifier.PUBLIC)
                    .returns(void.class);

            String propertyName = methodName.substring(3).toLowerCase();

            //method params
            methodBuilder.addParameters(option.getParameterSpecs());

            //thoughts: "action" property to notify JS?

            //these don't need special serialization
            //todo probably better to create a MethodInvocationBuilder to deal with serialization
            Set<TypeName> basicTypes = new HashSet<>();
            basicTypes.add(TypeName.get(Number.class));
            basicTypes.add(TypeName.get(Boolean.class));
            basicTypes.add(TypeName.get(String.class));

            if (methodName.equals("addTo")) {
                methodBuilder.addStatement("throw new $T($S)", RuntimeException.class, "Not implemented. Use add() method on element.");
            } else if (methodName.startsWith("get")) {
                methodBuilder.addStatement("return getElement().getProperty($S)", propertyName);
                ClassName returnClass = option.getReturnType();
                methodBuilder.returns(returnClass);

            } else if (methodName.equals("remove")) {

                methodBuilder.addStatement("getElement().removeFromParent()");
            } else {

                methodBuilder.addStatement("$T<Object> objects = new $T<>()", List.class, ArrayList.class);


                for (ParameterSpec parameterSpec : option.getParameterSpecs()) {
                    if (basicTypes.contains(parameterSpec.type)) {
                        methodBuilder.addStatement("objects.add(" + parameterSpec.name + ")");
                    } else {
                        methodBuilder.addStatement("objects.add(" + parameterSpec.name + ".serializable())");
                    }
                }
                methodBuilder.addStatement("setProperty($S, objects)", methodName);
            }

            methodBuilder.addJavadoc(option.getDescription());
            methodBuilder.addJavadoc("\n");

            //add the method
            builder.addMethod(methodBuilder.build());
        }

        TypeSpec typeSpec = builder.build();

        JavaFile javaFile =
                JavaFile.builder(tagInfo.packageName, typeSpec)
                .build();

        javaFile.writeTo(new File("./leaflet-map-flow/src/main/java").toPath());
    }

}
