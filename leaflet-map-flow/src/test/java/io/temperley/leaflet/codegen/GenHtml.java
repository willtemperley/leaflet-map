package io.temperley.leaflet.codegen;

import freemarker.template.*;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.temperley.leaflet.codegen.ResourceUtils.getFile;

public class GenHtml {


    public static void genHtml(TagInfo tagInfo) throws IOException, URISyntaxException {

        String tagName = tagInfo.getTagName();

        List<MethodDefinition> methodDefinitions = GenMethods.getMethodsFromFile(tagInfo.getFileName());
        Set<String> methodNames = methodDefinitions
                .stream()
                .map(MethodDefinition::getMethodName)
                .collect(Collectors.toSet());

        Configuration configuration = new Configuration(new Version(2, 3, 23));
        configuration.setClassForTemplateLoading(GenHtml.class, "/leaflet-template");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.UK);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        String templateName = "leaflet-x.ftl";
        if (tagName.equals("leaflet-map")) {
            templateName = "leaflet-map.ftl";
        }

        Template template = configuration.getTemplate(templateName);
        Map<String, Object> input = new HashMap<>();
        {
            input.put("className", "Leaflet" + tagInfo.getSimpleName());
            input.put("tagName", tagName);
            input.put("methodNames", methodNames);
        }

        Writer consoleWriter = new OutputStreamWriter(System.out);
        try {
            template.process(input, consoleWriter);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }


        String outputLocation = "leaflet-map-flow/src/main/resources/generated/";
        try (Writer fileWriter = new FileWriter(new File(outputLocation + tagName + ".html"))) {
            template.process(input, fileWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
