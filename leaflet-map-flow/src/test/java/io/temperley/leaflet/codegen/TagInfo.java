package io.temperley.leaflet.codegen;

import com.squareup.javapoet.ClassName;
import io.temperley.leaflet.options.OptionsBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagInfo {

    public final String packageName;
    private final String tag;
    private TagInfo superClassTagInfo = null;
    private Class superClass = null;

    public TagInfo(String tag, String packageName) {
        this.tag = tag;
        this.packageName = packageName;
    }
    public TagInfo(String tag, String packageName, String superClass) {
        this.tag = tag;
        this.packageName = packageName;
        this.superClassTagInfo = new TagInfo(superClass, packageName);
    }

    public String getFileName(boolean isOptions) {
        return String.format("leaflet-api/%s-%s.tsv", tag, isOptions ? "options" : "methods");
    }

    public String getTagName() {
        return "leaflet-" + tag;
    }

    public String getHtmlImport() {
        return String.format("bower_components/leaflet-map/%s.html", getTagName());
    }

    public String getSimpleName() {

        String[] split = tag.split("-");
        List<String> nameParts = new ArrayList<>(Arrays.asList(split));

        return toCamelCase(nameParts);
    }

    public static String toCamelCase(List<String> nameParts) {

        StringBuilder stringBuilder = new StringBuilder();
        for (String namePart : nameParts) {
            char c = Character.toUpperCase(namePart.charAt(0));
            stringBuilder.append(c);
            stringBuilder.append(namePart.substring(1));
        }
        return stringBuilder.toString();
    }

    public ClassName getSuperClassName(String formatString) {
        if (superClassTagInfo != null) {
            String name = String.format(formatString, superClassTagInfo.getSimpleName());
            return ClassName.get(superClassTagInfo.packageName, name);
        } else  {
            return ClassName.get(OptionsBase.class);
        }
    }
}
