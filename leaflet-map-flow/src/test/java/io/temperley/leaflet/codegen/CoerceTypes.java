package io.temperley.leaflet.codegen;

public class CoerceTypes {

    /**
     *
     * @return the nearest class we can find for this JS type
     */
    public static Class classForJSType(String typeName) {

        typeName = typeName.toLowerCase().replaceAll(" ", "");

        switch (typeName) {
            case "string":
            case "<string>":
                return String.class;
            case "boolean":
                return Boolean.class;
            case "number":
                return Number.class;
            case "object":
            default:
                return Object.class;
        }

    }

}
