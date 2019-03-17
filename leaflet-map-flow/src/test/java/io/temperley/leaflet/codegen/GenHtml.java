package io.temperley.leaflet.codegen;

import com.squareup.javapoet.ClassName;
import freemarker.template.*;
import io.temperley.leaflet.codegen.markers.ConstructorMarker;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenHtml {

    public static void genHtml(TagInfo tagInfo) throws IOException, URISyntaxException {

        String tagName = tagInfo.getTagName();
        if (tagName.equals("map")) {
            return;
        }
        ClassName constructorMarkerClassName = ClassName.get(ConstructorMarker.class);
        Predicate<MethodDefinition> methodDefinitionPredicate = f -> f.getReturnType().equals(constructorMarkerClassName);

        List<MethodDefinition> methodDefinitions = GenMethods.getMethodsFromFile(tagInfo.getFileName());
        Set<String> methodNames = methodDefinitions
                .stream()
                .filter(methodDefinitionPredicate.negate())
                .map(MethodDefinition::getMethodName)
                .collect(Collectors.toSet());

        Configuration configuration = new Configuration(new Version(2, 3, 23));
        configuration.setClassForTemplateLoading(GenHtml.class, "/leaflet-template");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.UK);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        TagInfo superClassTagInfo = tagInfo.getSuperClassTagInfo();
        //fixme figure out from the superclass tag info
        String templateName = "leaflet-x.ftl";
        String superClassTagName = TagInfo.capitalize(superClassTagInfo.getTagName());
        if (tagName.equals("layer") || tagName.equals("control")) {
            templateName = "leaflet-abstract.ftl";
        }
        if (tagName.equals("marker")) {
            templateName = "leaflet-marker.ftl";
        }

        Template template = configuration.getTemplate(templateName);
        Map<String, Object> input = new HashMap<>();
        {
            input.put("className", "Leaflet" + tagInfo.getSimpleName());
            input.put("superClassName", "Leaflet" + superClassTagName);
            input.put("tagName", tagInfo.getPolymerTagName());
            input.put("methodNames", methodNames);
        }

        Optional<MethodDefinition> first = methodDefinitions.stream()
                .filter(methodDefinitionPredicate).findFirst();

        if (first.isPresent()) {
            MethodDefinition methodDefinition = first.get();
            input.put("factoryMethod", methodDefinition.getMethodName());
        } else {
            input.put("factoryMethod", "fixme");
        }

//        Writer consoleWriter = new OutputStreamWriter(System.out);
//        try {
//            template.process(input, consoleWriter);
//        } catch (TemplateException e) {
//            throw new RuntimeException(e);
//        }


        String outputLocation = "leaflet-map-flow/src/test/resources/generated/";
        try (Writer fileWriter = new FileWriter(new File(outputLocation + tagInfo.getPolymerTagName() + ".html"))) {
            template.process(input, fileWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
