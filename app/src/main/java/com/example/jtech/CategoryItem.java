package com.example.jtech;

public class CategoryItem {
    private int imageResource;
    private String name;

    public CategoryItem(int imageResource, String name) {
        this.imageResource = imageResource;
        this.name = name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }
}
