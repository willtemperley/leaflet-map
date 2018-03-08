package io.temperley.leaflet.codegen;

import com.squareup.javapoet.*;
import io.temperley.leaflet.TakesServerOptions;
import io.temperley.leaflet.control.ControlOptions;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenOptions {

    private static List<OptionDefinition> getOptionsFromFile(String fileName) throws IOException, URISyntaxException {
        Stream<String> lines = Utils.getFile(fileName);

        Stream<OptionDefinition> optionStream = lines
                .map(f -> f.split("\t"))
                .map(f -> new OptionDefinition(f[0], f[1], f[2], f[3]));

        return optionStream.collect(Collectors.toList());
    }

    public static void genOptions(TagInfo tagInfo, Class<?> superclass) throws IOException, URISyntaxException {

        final boolean isOptions = true;
        ClassName newThis = ClassName.get(tagInfo.packageName, tagInfo.getSimpleName(isOptions));

        //fixme sometimes
        ParameterizedTypeName parameterizedTypeName = ParameterizedTypeName.get(tagInfo.getSuperClassName(isOptions), newThis);

        TypeSpec.Builder builder = TypeSpec.classBuilder(tagInfo.getSimpleName(isOptions))
                .superclass(parameterizedTypeName)
                .addModifiers(Modifier.PUBLIC);

        List<OptionDefinition> options = getOptionsFromFile(tagInfo.getFileName(isOptions));

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
            methodBuilder.addJavadoc("default: " + option.getDefaultValue());
            methodBuilder.addJavadoc("\n");

            builder.addMethod(methodBuilder.build());

        }

        TypeSpec built = builder.build();

        JavaFile javaFile = JavaFile.builder(tagInfo.packageName, built)
                .build();

        javaFile.writeTo(new File("./leaflet-map-flow/src/main/java").toPath());

    }

}
