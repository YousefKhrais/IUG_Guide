package com.yousef.iugguide;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import com.yousef.iugguide.helpers.DataHelper;
import com.yousef.iugguide.models.Building;
import com.yousef.iugguide.models.College;
import com.yousef.iugguide.models.Department;

import java.util.ArrayList;

public class AppClass extends Application {

    public static ArrayList<Department> departmentsArrayList = new ArrayList<>();
    public static ArrayList<College> collegesArrayList = new ArrayList<>();
    public static ArrayList<Building> buildingArrayList = new ArrayList<>();
    public static College chosen_college;
    public static Department chosen_Department;
    public static Building chosenBuilding;

    @Override
    public void onCreate() {
        super.onCreate();
        //This is added to disable dark mode by default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        DataHelper.getInstance().readCollegesData(this);
        DataHelper.getInstance().readDepartmentsData(this);
        DataHelper.getInstance().readBuildingsData(this);
    }
}