package com.yousef.iugguide;

import android.app.Application;

import com.yousef.iugguide.helpers.DataHelper;
import com.yousef.iugguide.models.Building;
import com.yousef.iugguide.models.College;
import com.yousef.iugguide.models.Department;

import java.util.ArrayList;

public class AppClass extends Application {

    public static ArrayList<Department> departmentsArrayList = new ArrayList<>();
    public static ArrayList<College> collegesArrayList = new ArrayList<>();
    public static ArrayList<Building> buildingArrayList = new ArrayList<>();
    public static  College chosen_college;
    public static  Department chosen_Department;
    public static  Building chosenBuilding;
//    public static  Building chosenBuilding;


    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");

        DataHelper.getInstance().readCollegesData(this);
        DataHelper.getInstance().readDepartmentsData(this);
        DataHelper.getInstance().readBuildingsData(this);

        for (int i = 0; i < collegesArrayList.size(); i++) {
            System.out.println(collegesArrayList.get(i).toString());
        }
    }
}