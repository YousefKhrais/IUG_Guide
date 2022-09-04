package com.yousef.iugguide.models;

import java.util.ArrayList;

public class Building {

    private int id;

    private String name;
    private String mainImageUrl;
    private String location;
    private String description;
    private String key;

    private ArrayList<String> imagesArrayList;

    public Building() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<String> getImagesArrayList() {
        return imagesArrayList;
    }

    public void setImagesArrayList(ArrayList<String> imagesArrayList) {
        this.imagesArrayList = imagesArrayList;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mainImageUrl='" + mainImageUrl + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", key='" + key + '\'' +
                ", imagesArrayList=" + imagesArrayList +
                '}';
    }
}
