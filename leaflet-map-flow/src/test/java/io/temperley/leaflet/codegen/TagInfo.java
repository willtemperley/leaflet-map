package io.temperley.leaflet.codegen;

import com.squareup.javapoet.ClassName;
import io.temperley.leaflet.options.OptionsBase;

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
        //fixme need to return the correct superclass. Expected to be in the same package.
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

    public String getSimpleName(boolean isOptions) {

        //Todo to camel case to use in GenHtml
        String[] nameParts = tag.split("-");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Abstract");
        for (String namePart : nameParts) {
            char c = Character.toUpperCase(namePart.charAt(0));
            stringBuilder.append(c);
            stringBuilder.append(namePart.substring(1));
        }
        if (isOptions) {
            stringBuilder.append("Options");
        }
        return stringBuilder.toString();
    }

    public ClassName getSuperClassName(boolean isOptions) {
        if (superClassTagInfo != null) {
            return ClassName.get(superClassTagInfo.packageName, superClassTagInfo.getSimpleName(isOptions));
        } else if (isOptions) {
            return ClassName.get(OptionsBase.class);
        }
        return null;
    }
}
