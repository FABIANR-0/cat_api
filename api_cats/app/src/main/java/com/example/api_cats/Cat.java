package com.example.api_cats;

public class Cat {
    private String name;
    private String origin;
    private int intelligence;
    private String reference_image_id;

    public Cat(String name, String origin, int intelligence, String image) {
        this.name = name;
        this.origin = origin;
        this.intelligence = intelligence;
        this.reference_image_id = image;
    }

    // Constructor, getters y setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getImage() {
        return reference_image_id;
    }

    public void setImage(String image) {
        this.reference_image_id = image;
    }
}