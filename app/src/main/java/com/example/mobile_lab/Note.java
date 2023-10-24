package com.example.mobile_lab;

public class Note {

    private String title;
    private String description;
    private int colour;

    public Note(String title, String description, int colour){

        this.title = title;
        this.description = description;
        this.colour = colour;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }
}
