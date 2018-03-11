package io.temperley.leaflet.codegen;

import com.jsoniter.output.JsonStream;
import com.squareup.javapoet.*;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import freemarker.template.*;
import io.temperley.leaflet.codegen.CoerceTypes;
import io.temperley.leaflet.codegen.MethodDefinition;
import io.temperley.leaflet.codegen.TagInfo;
import io.temperley.leaflet.codegen.js.MainTest;
import io.temperley.leaflet.codegen.js.ValueExampleObject;
import io.temperley.leaflet.options.OptionsBase;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.temperley.leaflet.codegen.ResourceUtils.getFile;

public class GenHtml {

    private static List<MethodDefinition> getMethodsFromFile(String fileName) throws IOException, URISyntaxException {
        Stream<String> lines = getFile(fileName);

        Stream<MethodDefinition> stream = lines
                .map(f -> f.split("\t"))
                .map(f -> new MethodDefinition(f[0], f[1], f[2]));

        return stream.collect(Collectors.toList());
    }


    public static void genHtml(TagInfo tagInfo) throws IOException, URISyntaxException {

        List<MethodDefinition> methods = getMethodsFromFile(tagInfo.getFileName(false));

        //generate properties for component
        Map<String, Object> objectMap = new HashMap<>();
        for (MethodDefinition method : methods) {
            String methodString = method.getMethodName();
            Map<String, String> property = new HashMap<>();
            property.put("type", "String");
            property.put("observer", "_methodObserver");
            objectMap.put(methodString, property);
        }

        Configuration configuration = new Configuration(new Version(2, 3, 23));
        configuration.setClassForTemplateLoading(MainTest.class, "/leaflet-template");

        // Some other recommended settings:
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.UK);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // 2. Proccess template(s)
        Map<String, Object> input = new HashMap<>();

        input.put("className", "Leaflet" + tagInfo.getTagName());
//
//        input.put("exampleObject", new ValueExampleObject("Java object", "me"));
//
//        List<ValueExampleObject> systems = new ArrayList<ValueExampleObject>();
//        systems.add(new ValueExampleObject("Android", "Google"));
//        systems.add(new ValueExampleObject("iOS States", "Apple"));
//        systems.add(new ValueExampleObject("Ubuntu", "Canonical"));
//        systems.add(new ValueExampleObject("Windows7", "Microsoft"));
//        input.put("systems", systems);

        Template template = configuration.getTemplate("leaflet-map.ftl");

        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        try {
            template.process(input, consoleWriter);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

        // For the sake of example, also write output into a file:
//        Writer fileWriter = new FileWriter(new File("output.html"));
//        try {
//            template.process(input, fileWriter);
//        } finally {
//            fileWriter.close();
//        }

    }
}
