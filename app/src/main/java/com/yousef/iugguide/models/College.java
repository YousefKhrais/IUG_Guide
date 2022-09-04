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
    private String infoLink;

    private ArrayList<Department> bachelorDepartments;
    private ArrayList<Department> masterDepartments;
    private ArrayList<Department> doctorateDepartments;

    private ArrayList<Doctor> professors;

    public College() {
    }

    public College(int id, int studentsCount, String name, String imageUrl, String location, String facebookPageLink, String description, String backGroundImageUrl, String iconUrl, String infoLink, ArrayList<Department> bachelorDepartments, ArrayList<Department> masterDepartments, ArrayList<Department> doctorateDepartments, ArrayList<Doctor> professors) {
        this.id = id;
        this.studentsCount = studentsCount;
        this.name = name;
        this.imageUrl = imageUrl;
        this.location = location;
        this.facebookPageLink = facebookPageLink;
        this.description = description;
        this.backGroundImageUrl = backGroundImageUrl;
        this.iconUrl = iconUrl;
        this.infoLink = infoLink;
        this.bachelorDepartments = bachelorDepartments;
        this.masterDepartments = masterDepartments;
        this.doctorateDepartments = doctorateDepartments;
        this.professors = professors;
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

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public ArrayList<Department> getBachelorDepartments() {
        return bachelorDepartments;
    }

    public void setBachelorDepartments(ArrayList<Department> bachelorDepartments) {
        this.bachelorDepartments = bachelorDepartments;
    }

    public ArrayList<Department> getMasterDepartments() {
        return masterDepartments;
    }

    public void setMasterDepartments(ArrayList<Department> masterDepartments) {
        this.masterDepartments = masterDepartments;
    }

    public ArrayList<Department> getDoctorateDepartments() {
        return doctorateDepartments;
    }

    public void setDoctorateDepartments(ArrayList<Department> doctorateDepartments) {
        this.doctorateDepartments = doctorateDepartments;
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
                ", infoLink='" + infoLink + '\'' +
                ", bachelorDepartments=" + bachelorDepartments +
                ", masterDepartments=" + masterDepartments +
                ", doctorateDepartments=" + doctorateDepartments +
                ", professors=" + professors +
                '}';
    }
}
