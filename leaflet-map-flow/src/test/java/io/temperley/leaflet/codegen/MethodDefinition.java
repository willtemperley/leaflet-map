package io.temperley.leaflet.codegen;

public class MethodDefinition {

    private final String name;
    private final String returnType;
    private final String description;

    public MethodDefinition(String name, String returnType, String description) {
        this.name = name;
        this.returnType = returnType;
        this.description = description;
    }

    public String getMethodString() {
        return name;
    }

    public String getReturnType() {
        return returnType;
    }

    public String getDescription() {
        return description;
    }
}
