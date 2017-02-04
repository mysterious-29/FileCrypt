package com.example.mysterious.filecrypt.Models;

/**
 * Created by aditya on 4/2/17.
 */

public class NavDrawItemModel {


    private String name;
    private int imageId;

    public NavDrawItemModel(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}