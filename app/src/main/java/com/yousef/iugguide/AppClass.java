package com.yousef.iugguide;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import com.yousef.iugguide.helpers.DataHelper;
import com.yousef.iugguide.models.Building;
import com.yousef.iugguide.models.College;
import com.yousef.iugguide.models.Department;
import com.yousef.iugguide.models.Professor;

import java.util.ArrayList;

public class AppClass extends Application {

    public static ArrayList<Department> departmentsArrayList = new ArrayList<>();
    public static ArrayList<College> collegesArrayList = new ArrayList<>();
    public static ArrayList<Building> buildingArrayList = new ArrayList<>();
    public static ArrayList<Professor> professorsArrayList = new ArrayList<>();

    public static College chosenCollege;
    public static Department chosenDepartment;
    public static Building chosenBuilding;
    public static Professor chosenProfessor;

    @Override
    public void onCreate() {
        super.onCreate();
        //This is added to disable dark mode by default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        DataHelper.getInstance().readCollegesData(this);
        DataHelper.getInstance().readDepartmentsData(this);
        DataHelper.getInstance().readBuildingsData(this);
        DataHelper.getInstance().readProfessorsData(this);

        System.out.println(professorsArrayList.toString());
    }
}