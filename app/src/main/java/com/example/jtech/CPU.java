package com.example.jtech;

public class CPU {
    String modelName;
    Specs specs;

    public CPU() {
        // Empty constructor required for Firebase
    }

    public String getModelName() {
        return modelName;
    }

    public Specs getSpecs() {
        return specs;
    }
}
