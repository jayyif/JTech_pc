package com.example.jtech;

public class Specs {
    private String Name;
    private String Image;
    private double Price;


    public Specs() {
        // Empty constructor required for Firebase
    }

    public String getName() {
        return Name;
    }

    public String getImage() {
        return Image;
    }

    public double getPrice() {
        return Price;
    }
}
