package com.yousef.iugguide.models;

public class Professor {

    private int id;
    private String name;
    private int collegeId;
    private int departmentId;

    public Professor() {
    }

    public Professor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Professor(int id, String name, int collegeId, int departmentId) {
        this.id = id;
        this.name = name;
        this.collegeId = collegeId;
        this.departmentId = departmentId;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", collegeId=" + collegeId +
                ", departmentId=" + departmentId +
                '}';
    }
}
