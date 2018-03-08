package io.temperley.leaflet.codegen;

public class OptionDefinition {

    private final String defaultValue;
    private final String description;
    private final String name;
    private final String type;

    public OptionDefinition(String name, String type, String defaultValue, String description) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
        this.description = description;
    }

    public String getDefaultValue() {

        if (CoerceTypes.classForJSType(type).equals(Boolean.class)) {
            return defaultValue.toLowerCase();
        }

        return defaultValue;
    }



    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Class getType() {

        return CoerceTypes.classForJSType(type);
    }
}
