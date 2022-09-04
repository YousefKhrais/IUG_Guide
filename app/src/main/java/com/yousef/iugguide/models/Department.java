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
    private int collegeId;

    public Department() {
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

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
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
                ", collegeId=" + collegeId +
                '}';
    }
}
