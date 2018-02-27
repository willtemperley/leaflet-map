package io.temperley.leaflet.codegen;

public class Option {

    private final String defaultValue;
    private final String description;
    private final String name;
    private final String type;

    public Option(String name, String type, String defaultValue, String description) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
        this.description = description;
    }

    public String getDefaultValue() {

        if (getType().equals(Boolean.class)) {
            return defaultValue.toLowerCase();
        }

        return defaultValue;
    }


    public Class getType() {
        switch (type) {
            case "String":
                return String.class;
            case "Boolean":
                return Boolean.class;
            case "Number":
                return Number.class;
            case "Object":
                return Object.class;
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
