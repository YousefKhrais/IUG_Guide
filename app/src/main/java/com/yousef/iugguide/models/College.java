package com.yousef.iugguide.models;

import java.util.ArrayList;

public class College {

    private int id;
    private int studentsCount;

    private String name;
    private String imageUrl;
    private String location;
    private String facebookPageLink;
    private String description;

    private ArrayList<Department> BachelorDepartments;
    private ArrayList<Department> MasterDepartments;
    private ArrayList<Department> DoctorateDepartments;

    public College() {
    }

    public College(int id, int studentsCount, String name, String imageUrl, String location, String facebookPageLink, String description) {
        this.id = id;
        this.studentsCount = studentsCount;
        this.name = name;
        this.imageUrl = imageUrl;
        this.location = location;
        this.facebookPageLink = facebookPageLink;
        this.description = description;
    }

    public College(int id, int studentsCount, String name, String imageUrl, String location, String facebookPageLink, String description, ArrayList<Department> bachelorDepartments, ArrayList<Department> masterDepartments, ArrayList<Department> doctorateDepartments) {
        this.id = id;
        this.studentsCount = studentsCount;
        this.name = name;
        this.imageUrl = imageUrl;
        this.location = location;
        this.facebookPageLink = facebookPageLink;
        this.description = description;
        BachelorDepartments = bachelorDepartments;
        MasterDepartments = masterDepartments;
        DoctorateDepartments = doctorateDepartments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFacebookPageLink() {
        return facebookPageLink;
    }

    public void setFacebookPageLink(String facebookPageLink) {
        this.facebookPageLink = facebookPageLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Department> getBachelorDepartments() {
        return BachelorDepartments;
    }

    public void setBachelorDepartments(ArrayList<Department> bachelorDepartments) {
        BachelorDepartments = bachelorDepartments;
    }

    public ArrayList<Department> getMasterDepartments() {
        return MasterDepartments;
    }

    public void setMasterDepartments(ArrayList<Department> masterDepartments) {
        MasterDepartments = masterDepartments;
    }

    public ArrayList<Department> getDoctorateDepartments() {
        return DoctorateDepartments;
    }

    public void setDoctorateDepartments(ArrayList<Department> doctorateDepartments) {
        DoctorateDepartments = doctorateDepartments;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", studentsCount=" + studentsCount +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", location='" + location + '\'' +
                ", facebookPageLink='" + facebookPageLink + '\'' +
                ", description='" + description + '\'' +
                ", BachelorDepartments=" + BachelorDepartments +
                ", MasterDepartments=" + MasterDepartments +
                ", DoctorateDepartments=" + DoctorateDepartments +
                '}';
    }
}
