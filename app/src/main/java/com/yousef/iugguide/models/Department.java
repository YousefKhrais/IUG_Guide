package com.yousef.iugguide.models;

import com.yousef.iugguide.models.enums.DepartmentType;

public class Department {

    private int id;
    private int studentsCount;
    private String name;
    private String section;
    private String planUrl;
    private String description;
    private String formatKey;
    private DepartmentType departmentType;
    private College college;
    //    private int collegeId;
//    private String type;

    public Department() {
    }

    public Department(int id, int studentsCount, String name, String section, String planUrl, String description, String formatKey, DepartmentType departmentType, College college) {
        this.id = id;
        this.studentsCount = studentsCount;
        this.name = name;
        this.section = section;
        this.planUrl = planUrl;
        this.description = description;
        this.formatKey = formatKey;
        this.departmentType = departmentType;
        this.college = college;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPlanUrl() {
        return planUrl;
    }

    public void setPlanUrl(String planUrl) {
        this.planUrl = planUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormatKey() {
        return formatKey;
    }

    public void setFormatKey(String formatKey) {
        this.formatKey = formatKey;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", studentsCount=" + studentsCount +
                ", name='" + name + '\'' +
                ", section='" + section + '\'' +
                ", planUrl='" + planUrl + '\'' +
                ", description='" + description + '\'' +
                ", formatKey='" + formatKey + '\'' +
                ", departmentType=" + departmentType +
                ", college=" + college +
                '}';
    }
}
