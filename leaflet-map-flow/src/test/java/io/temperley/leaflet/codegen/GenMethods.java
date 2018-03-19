package io.temperley.leaflet.codegen;

import com.squareup.javapoet.*;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementConstants;
import io.temperley.leaflet.codegen.markers.ConstructorMarker;
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
            if (line.startsWith("#")) {
                continue;
            }
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
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);

        //fixme better way to define abstract tags
        if (!tagInfo.getTagName().equals("leaflet-control")) {

                builder.addAnnotation(
                        AnnotationSpec.builder(Tag.class)
                            .addMember("value", "$S", tagInfo.getTagName())
                            .build()
                )
                .addAnnotation(
                        AnnotationSpec.builder(HtmlImport.class)
                            .addMember("value", "$S", tagInfo.getHtmlImport())
                            .build()
                );
        }

        //add superclass if required
        ClassName superclass = tagInfo.getSuperClassName(formatString);
        builder = builder.superclass(superclass);

        List<MethodDefinition> methods = getMethodsFromFile(tagInfo.getFileName());

        for (MethodDefinition option : methods) {

            String methodName = option.getMethodName();
            boolean isConstructor = option.getReturnType().equals(ClassName.get(ConstructorMarker.class));

            MethodSpec.Builder methodBuilder;
            if (isConstructor) {
                methodBuilder = MethodSpec.constructorBuilder();
            } else {
                methodBuilder = MethodSpec.methodBuilder(methodName)
                        .returns(void.class);
            }

            methodBuilder.addModifiers(Modifier.PUBLIC);

            //method params
            methodBuilder.addParameters(option.getParameterSpecs());

            //these don't need special serialization
            Set<TypeName> basicTypes = new HashSet<>();
            basicTypes.add(TypeName.get(Number.class));
            basicTypes.add(TypeName.get(Boolean.class));
            basicTypes.add(TypeName.get(String.class));

            if (methodName.equals("addTo")) {
                methodBuilder.addStatement("throw new $T($S)", RuntimeException.class, "Not implemented. Use add() method on element.");
            } else if (methodName.equals("getContainer")) {

                methodBuilder.addStatement("return getElement().getParent()");
                methodBuilder.returns(Element.class);

            } else if (methodName.startsWith("get")) {
                String propertyName = methodName.substring(3).toLowerCase();
                ClassName returnClass = option.getReturnType();
                if (basicTypes.contains(returnClass)) {
                    methodBuilder.addStatement("return getElement().getProperty($S)", propertyName);
                } else {
                    methodBuilder.addStatement("String str = getElement().getProperty($S)", propertyName);
                    methodBuilder.addStatement("return $T.fromString(str)", returnClass);
                }
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

                String property = isConstructor ? "constructorargs" : methodName;
                methodBuilder.addStatement("setProperty($S, objects)", property);
            }

            methodBuilder.addJavadoc(option.getDescription());
            methodBuilder.addJavadoc("\n");

            //add the method
            builder.addMethod(methodBuilder.build());
        }

        TypeSpec typeSpec = builder.build();

        JavaFile javaFile =
                JavaFile.builder(tagInfo.packageName, typeSpec)
                .indent("    ")
                .build();

        javaFile.writeTo(new File("./leaflet-map-flow/src/main/java").toPath());
    }

}
