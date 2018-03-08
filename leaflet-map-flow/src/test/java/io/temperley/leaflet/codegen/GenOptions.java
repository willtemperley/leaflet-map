package io.temperley.leaflet.codegen;

import com.squareup.javapoet.*;
import io.temperley.leaflet.control.ControlOptions;

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

public class GenOptions {

    public static void main(String[] args) throws IOException, URISyntaxException {

        //        genOptions(
//                collect,
//                "ScaleControlOptions",
//                "io.temperley.leaflet.control",
//                ControlOptions.class
//        );

//        genOptions(
//                getOptionsFromFile("leaflet-api/zoom-control-options.tsv"),
//                "ZoomControlOptions",
//                "io.temperley.leaflet.control",
//                ControlOptions.class
//        );
        genOptions(
                getOptionsFromFile("leaflet-api/layers-control-options.tsv"),
                "LayersControlOptions",
                "io.temperley.leaflet.control",
                ControlOptions.class
        );
    }

    private static List<OptionDefinition> getOptionsFromFile(String fileName) throws IOException, URISyntaxException {
        Stream<String> lines = getFile(fileName);

        Stream<OptionDefinition> optionStream = lines
                .map(f -> f.split("\t"))
                .map(f -> new OptionDefinition(f[0], f[1], f[2], f[3]));

        return optionStream.collect(Collectors.toList());
    }

    public static void genOptions(List<OptionDefinition> options, String simpleName, String packageName, Class<ControlOptions> superclass) throws IOException {

        ClassName newThis = ClassName.get(packageName, simpleName);

        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(ClassName.get(superclass), newThis);

        TypeSpec.Builder builder = TypeSpec.classBuilder(simpleName)
                .superclass(parameterizedTypeName)
                .addModifiers(Modifier.PUBLIC);


        for (OptionDefinition option : options) {
            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(option.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .returns(void.class);

            String name = option.getName();

            methodBuilder.addParameter(option.getType(), option.getName())
                    .build();
            methodBuilder.addStatement("addOption($S, " + name + ")", name);
            methodBuilder.addStatement("return this");

            methodBuilder.returns(newThis);

            methodBuilder.addJavadoc(option.getDescription());
            methodBuilder.addJavadoc("\n");
            methodBuilder.addJavadoc("default: " +  option.getDefaultValue());
            methodBuilder.addJavadoc("\n");

            builder.addMethod(methodBuilder.build());

        }

        TypeSpec built = builder.build();

        JavaFile javaFile = JavaFile.builder(packageName, built)
                .build();

        javaFile.writeTo(new File("./leaflet-map-flow/src/main/java").toPath());

    }

    private static Stream<String> getFile(String name) throws IOException, URISyntaxException {

        Path path = Paths.get(Objects.requireNonNull(GenOptions.class.getClassLoader()
                .getResource(name)).toURI());

        return Files.lines(path);

    }
}
