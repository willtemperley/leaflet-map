package io.temperley.leaflet.codegen;

import com.squareup.javapoet.*;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import io.temperley.leaflet.OptionsBase;
import io.temperley.leaflet.TakesServerOptions;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenMethods {

    public static void main(String[] args) throws IOException, URISyntaxException {

//        genMethods(
//                getMethodsFromFile("leaflet-api/control-methods.tsv"),
//                "Control",
//                "io.temperley.leaflet.control",
//                TakesServerOptions.class
//        );

        genMethods(
                "layers-control",
                "io.temperley.leaflet.control",
                TakesServerOptions.class
        );
    }

    private static List<MethodDefinition> getMethodsFromFile(String fileName) throws IOException, URISyntaxException {
        Stream<String> lines = getFile(fileName);

        Stream<MethodDefinition> stream = lines
                .map(f -> f.split("\t"))
                .map(f -> new MethodDefinition(f[0], f[1], f[2]));

        return stream.collect(Collectors.toList());
    }

    public static void genMethods(String tag, String packageName, Class superclass) throws IOException, URISyntaxException {

        String tagName = "leaflet-" + tag;
        String htmlImport = String.format("bower_components/leaflet-map/%s.html", tagName);
        String fileName = String.format("leaflet-api/%s-methods.tsv", tag);

        String[] nameParts = tag.split("-");
        StringBuilder stringBuilder = new StringBuilder();
        for (String namePart : nameParts) {
            char c = Character.toUpperCase(namePart.charAt(0));
            stringBuilder.append(c);
            stringBuilder.append(namePart.substring(1));
        }
        String simpleName = stringBuilder.toString();

        //build class
        TypeSpec.Builder builder = TypeSpec.classBuilder(simpleName)
                .addAnnotation(
                        AnnotationSpec.builder(Tag.class)
                            .addMember("value", "$S", tagName)
                            .build()
                )
                .addAnnotation(
                        AnnotationSpec.builder(HtmlImport.class)
                            .addMember("value", "$S", htmlImport)
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

        List<MethodDefinition> methods = getMethodsFromFile(fileName);
        for (MethodDefinition option : methods) {

            String methodString = option.getMethodString();

            String methodName = methodString.substring(0, methodString.indexOf('('));

            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(methodName)
                    .addModifiers(Modifier.PUBLIC)
                    .returns(void.class);

            String propertyName = methodName.substring(3).toLowerCase();

            if (methodString.startsWith("get")) {
                methodBuilder.addStatement("return getElement().getProperty($S)", propertyName);
                Class aClass = CoerceTypes.classForJSType(option.getReturnType());
                methodBuilder.returns(aClass);
            } else if (methodString.startsWith("set")) {
                methodBuilder.addStatement("getElement().setProperty($S, " + propertyName + ")", propertyName);

                String propertyType = methodString.substring(methodString.indexOf('(') + 1, methodString.indexOf(' '));
                Class aClass = CoerceTypes.classForJSType(propertyType);
                methodBuilder.addParameter(aClass, propertyName);

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

        JavaFile javaFile = JavaFile.builder(packageName, built)
                .build();

        javaFile.writeTo(new File("./leaflet-map-flow/src/main/java").toPath());

    }

    private static Stream<String> getFile(String name) throws IOException, URISyntaxException {

        Path path = Paths.get(Objects.requireNonNull(GenMethods.class.getClassLoader()
                .getResource(name)).toURI());

        return Files.lines(path);

    }
}
