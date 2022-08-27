package com.yousef.iugguide.models;

public class Doctor {

    private int id;
    private String name;
    private int collegeId;
    private String degree;
    private String email;
    private String specialty;
    private String roomNumber;

    public Doctor() {
    }

    public Doctor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Doctor(int id, String name, int collegeId, String degree, String email, String specialty, String roomNumber) {
        this.id = id;
        this.name = name;
        this.collegeId = collegeId;
        this.degree = degree;
        this.email = email;
        this.specialty = specialty;
        this.roomNumber = roomNumber;
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

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

}
