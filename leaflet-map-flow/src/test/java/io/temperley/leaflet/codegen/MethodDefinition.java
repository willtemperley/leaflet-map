package io.temperley.leaflet.codegen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterSpec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodDefinition {

    private ClassName returnType;
    private final List<ParameterSpec> parameterSpecs;
    private String description;
    private String methodName;

    private MethodDefinition(String methodName, ClassName returnType, List<ParameterSpec> parameterSpecs, String description) {
        this.methodName = methodName;
        this.returnType = returnType;
        this.parameterSpecs = parameterSpecs;
        this.description = description;
    }

    static List<MethodDefinition> getDefs(String methodString, String returnType, String description) {

        List<MethodDefinition> methodDefinitions = new ArrayList<>();


        //Get required and optional params
        String paramString = methodString.substring(methodString.indexOf('(') + 1, methodString.indexOf(')'));
        List<ParameterSpec> parameterSpecsRequired = buildParamList(paramString, false);
        List<ParameterSpec> parameterSpecsOptional = buildParamList(paramString, true);


        ClassName className = CoerceTypes.classForJSType(returnType);

        String methodName =  methodString.substring(0, methodString.indexOf('('));

        //Start with the required params
        MethodDefinition methodDefinition = new MethodDefinition(methodName, className, parameterSpecsRequired, description);
        methodDefinitions.add(methodDefinition);

        //Incrementally add optionals, creating a new method each time
        List<ParameterSpec> optionals = new ArrayList<>();
        for (ParameterSpec parameterSpec : parameterSpecsOptional) {
            List<ParameterSpec> parameterSpecs = new ArrayList<>(parameterSpecsRequired);
            optionals.add(parameterSpec);
            parameterSpecs.addAll(optionals);
            MethodDefinition def = new MethodDefinition(methodName, className, parameterSpecs, description);
            methodDefinitions.add(def);
        }


        return methodDefinitions;
    }


    public String getDescription() {
        return description;
    }


    public static List<ParameterSpec> buildParamList(String paramString, boolean getOptionals) {

        List<ParameterSpec> parameterSpecs = new ArrayList<>();
        if (paramString.isEmpty()) {
            return parameterSpecs;
        }
        String[] split = paramString.split(",");

        for (String singleParamString : split) {
            String regex;
            if (singleParamString.contains(">")) {
                regex = "> ";
            } else {
                regex = " ";
            }
            String[] typeAndVar = singleParamString.split(regex);
            String name = typeAndVar[1];
            ClassName className = CoerceTypes.classForJSType(typeAndVar[0]);

            if (name.contains("?")) {
                if (getOptionals) {
                    name = name.replace("?", "");
                    parameterSpecs.add(ParameterSpec.builder(className, name).build());
                }
            } else {
                if (!getOptionals) {
                    parameterSpecs.add(ParameterSpec.builder(className, name).build());
                }
            }
        }

        return parameterSpecs;
    }

    public List<ParameterSpec> getParameterSpecs() {
        return parameterSpecs;
    }
    public List<ParameterSpec> getRequiredParameterSpecs() {
        return parameterSpecs.stream()
                .filter(f -> !f.name.contains("?"))
                .collect(Collectors.toList());
    }

    public ClassName getReturnType() {
        return returnType;
    }

    public String getMethodName() {
        return methodName;
    }
}
