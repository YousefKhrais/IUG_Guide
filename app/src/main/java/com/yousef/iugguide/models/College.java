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

    private String backGroundImageUrl;
    private String iconUrl;

    private ArrayList<Department> BachelorDepartments;
    private ArrayList<Department> MasterDepartments;
    private ArrayList<Department> DoctorateDepartments;

    private ArrayList<Doctor> professors;

    public College() {
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

    public String getBackGroundImageUrl() {
        return backGroundImageUrl;
    }

    public void setBackGroundImageUrl(String backGroundImageUrl) {
        this.backGroundImageUrl = backGroundImageUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public ArrayList<Doctor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Doctor> professors) {
        this.professors = professors;
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
                ", backGroundImageUrl='" + backGroundImageUrl + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", BachelorDepartments=" + BachelorDepartments +
                ", MasterDepartments=" + MasterDepartments +
                ", DoctorateDepartments=" + DoctorateDepartments +
                ", professors=" + professors +
                '}';
    }
}
