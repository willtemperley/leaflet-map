package io.temperley.leaflet.codegen;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenOptions {

    private static List<OptionDefinition> getOptionsFromFile(String fileName) throws IOException, URISyntaxException {

        Stream<String> lines = ResourceUtils.getFile(fileName);

        Stream<OptionDefinition> optionStream = lines
                .map(f -> f.split("\t"))
                .map(f -> new OptionDefinition(f[0], f[1], f[2], f[3]));

        return optionStream.collect(Collectors.toList());
    }


    public static void genOptions(TagInfo tagInfo) throws IOException, URISyntaxException {

        String formatString = "Abstract%sOptions";
        String simpleName = String.format(formatString, tagInfo.getSimpleName());

        TypeSpec.Builder builder =
                TypeSpec.classBuilder(simpleName)
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);
        ClassName newThis = ClassName.get(tagInfo.packageName, simpleName);


        TypeVariableName T = TypeVariableName.get("T");
        ParameterizedTypeName recursiveT = ParameterizedTypeName.get(newThis, T);

        ClassName superClassName = tagInfo.getSuperClassName(formatString);

        TypeVariableName typeVariableName = TypeVariableName.get("T", recursiveT);

        ParameterizedTypeName parameterizedSuperClass = ParameterizedTypeName.get(superClassName, typeVariableName);

        builder.addTypeVariable(typeVariableName)
                .superclass(parameterizedSuperClass);

        List<OptionDefinition> options = getOptionsFromFile(tagInfo.getFileName());

        for (OptionDefinition option : options) {
            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(option.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .returns(void.class);

            String name = option.getName();

            methodBuilder.addParameter(option.getType(), option.getName())
                    .build();
            methodBuilder.addStatement("addOption($S, " + name + ")", name);
            methodBuilder.addStatement("return this.get()");

            methodBuilder.returns(T);

            methodBuilder.addJavadoc(option.getDescription());
            methodBuilder.addJavadoc("\n");
            methodBuilder.addJavadoc("default: " + option.getDefaultValue());
            methodBuilder.addJavadoc("\n");

            builder.addMethod(methodBuilder.build());

        }

        TypeSpec built = builder.build();

        JavaFile javaFile = JavaFile.builder(tagInfo.packageName, built)
                .indent("    ")
                .build();

        javaFile.writeTo(new File("./leaflet-map-flow/src/main/java").toPath());

    }

}
