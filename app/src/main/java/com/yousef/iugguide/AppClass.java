package com.yousef.iugguide;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import com.yousef.iugguide.helpers.DataHelper;
import com.yousef.iugguide.models.Building;
import com.yousef.iugguide.models.Center;
import com.yousef.iugguide.models.College;
import com.yousef.iugguide.models.Contact;
import com.yousef.iugguide.models.Department;
import com.yousef.iugguide.models.Doctor;
import com.yousef.iugguide.models.FAQ;

import java.util.ArrayList;

public class AppClass extends Application {

    public static ArrayList<Department> departmentsArrayList = new ArrayList<>();
    public static ArrayList<College> collegesArrayList = new ArrayList<>();
    public static ArrayList<Building> buildingArrayList = new ArrayList<>();
    public static ArrayList<Doctor> doctorsArrayList = new ArrayList<>();
    public static ArrayList<FAQ> faqArrayList = new ArrayList<>();
    public static ArrayList<Building> facilitiesArrayList = new ArrayList<>();
    public static ArrayList<Center> centersArrayList = new ArrayList<>();
    public static ArrayList<Contact> contactsArrayList = new ArrayList<>();

    public static College chosenCollege;
    public static Department chosenDepartment;
    public static Building chosenBuilding;
    public static Doctor chosenDoctor;
    public static Center chosenCenter;

    @Override
    public void onCreate() {
        super.onCreate();
        //This is added to disable dark mode by default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        DataHelper.getInstance().readCollegesData(this);
        DataHelper.getInstance().readDepartmentsData(this);
        DataHelper.getInstance().readBuildingsData(this);
        DataHelper.getInstance().readProfessorsData(this);
        DataHelper.getInstance().readFaqData(this);
        DataHelper.getInstance().readFacilitiesData(this);
        DataHelper.getInstance().readContactsData(this);
        DataHelper.getInstance().readCentersData(this);
    }
}