package io.temperley.leaflet.codegen;

import com.squareup.javapoet.ClassName;
import io.temperley.leaflet.options.OptionsBase;
import io.temperley.leaflet.options.TakesServerOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagInfo {

    public final String packageName;
    private final String tag;
    private TagInfo superClassTagInfo = null;

    public void setIsOptions(boolean isOptions) {
        this.isOptions = isOptions;
    }

    private boolean isOptions = false;

    public TagInfo(String tag, String packageName) {
        this.tag = tag;
        this.packageName = packageName;
    }

    public TagInfo(String tag, String packageName, TagInfo tagInfo) {
        this.tag = tag;
        this.packageName = packageName;
        this.superClassTagInfo = tagInfo;
    }

    public Boolean fileExists() {
        return  ResourceUtils.exists(getFileName());
    }

    public String getFileName() {
        return String.format("leaflet-api/%s-%s.tsv", tag, isOptions ? "options" : "methods");
    }

    public String getTagName() {
        return tag;
    }
    public String getPolymerTagName() {
        return "leaflet-" + tag;
    }

    public String getHtmlImport() {
        return String.format("bower_components/leaflet-map/%s.html", getPolymerTagName());
    }

    public String getSimpleName() {

        String[] split = tag.split("-");
        List<String> nameParts = new ArrayList<>(Arrays.asList(split));

        return toCamelCase(nameParts);
    }

    public static String capitalize(String input) {
        if (input == null || input.length() < 1) {
            return "";
        }
        char[] chars = input.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
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
        if (!superClassTagInfo.getTagName().equals("object")) {
            String name = String.format(formatString, superClassTagInfo.getSimpleName());
            return ClassName.get(superClassTagInfo.packageName, name);
        } else  {
            if (isOptions) {
                return ClassName.get(OptionsBase.class);
            } else {

                return ClassName.get(TakesServerOptions.class);
            }
        }
    }

    public TagInfo getSuperClassTagInfo() {
        return superClassTagInfo;
    }
}
