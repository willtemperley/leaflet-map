package io.temperley.leaflet.codegen;

public class MethodDefinition {

    private final String methodString;
    private final String returnType;
    private final String description;

    public MethodDefinition(String methodString, String returnType, String description) {
        this.methodString = methodString;
        this.returnType = returnType;
        this.description = description;
    }

    public String getMethodString() {
        return methodString;
    }

    public String getReturnType() {
        return returnType;
    }

    public String getDescription() {
        return description;
    }

    public String getMethodName() {
        return methodString.substring(0, methodString.indexOf('('));
    }

    public String getParamString() {
        return methodString.substring(methodString.indexOf('(') + 1, methodString.indexOf(')'));
    }
}
