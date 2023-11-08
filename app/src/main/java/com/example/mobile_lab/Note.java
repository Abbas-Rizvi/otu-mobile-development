package com.example.mobile_lab;

public class Note {

    private String title;
    private String description;
    private int colour;
    private byte[] image;
    private int id;

    public Note(String title, String description, int colour, byte[] image){

        this.title = title;
        this.description = description;
        this.colour = colour;
        this.image = image;

    }


    public Note(int id, String title, String description, int colour, byte[] image){

        this.id = id;
        this.title = title;
        this.description = description;
        this.colour = colour;
        this.image = image;

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

    public byte[] getImgBmp() {
        return image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
