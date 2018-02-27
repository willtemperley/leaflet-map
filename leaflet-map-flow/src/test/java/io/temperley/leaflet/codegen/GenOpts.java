package io.temperley.leaflet.codegen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
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

public class GenOpts {

    public static void main(String[] args) throws IOException, URISyntaxException {

        Stream<String> lines = getFile("leaflet-scale-options.tsv");

        Stream<Option> optionStream = lines
                .map(f -> f.split("\t"))
                .map(f -> new Option(f[0], f[1], f[2], f[3]));

        List<Option> collect = optionStream.collect(Collectors.toList());

        genOptions(
                collect,
                "ScaleControlOptions",
                "io.temperley.leaflet.control",
                ControlOptions.class
        );

    }

    public static void genOptions(List<Option> collect, String simpleName, String packageName, Class<ControlOptions> superclass) throws IOException {

        TypeSpec.Builder builder = TypeSpec.classBuilder(simpleName)
                .superclass(superclass)
                .addModifiers(Modifier.PUBLIC);


        for (Option option : collect) {
            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(option.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .returns(void.class);

            String name = option.getName();

            methodBuilder.addParameter(option.getType(), option.getName())
                    .build();
            methodBuilder.addStatement("addOption($S, " + name + ")", name);
            methodBuilder.addStatement("return this");

            methodBuilder.returns(ClassName.get(packageName, simpleName));

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

        Path path = Paths.get(Objects.requireNonNull(GenOpts.class.getClassLoader()
                .getResource(name)).toURI());

        return Files.lines(path);

    }
}
