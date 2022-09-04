package com.yousef.iugguide.models;

public class Doctor {

    private int id;
    private String name;
    private String college;
    private String department;
    private String degree;
    private String insidePhone;
    private String email;
    private int collegeId;

    public Doctor() {
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInsidePhone() {
        return insidePhone;
    }

    public void setInsidePhone(String insidePhone) {
        this.insidePhone = insidePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", department='" + department + '\'' +
                ", degree='" + degree + '\'' +
                ", insidePhone='" + insidePhone + '\'' +
                ", email='" + email + '\'' +
                ", collegeId=" + collegeId +
                '}';
    }
}
