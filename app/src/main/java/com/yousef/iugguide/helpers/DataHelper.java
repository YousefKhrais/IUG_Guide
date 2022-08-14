package com.yousef.iugguide.helpers;

import android.content.Context;

import com.yousef.iugguide.MainActivity;
import com.yousef.iugguide.R;
import com.yousef.iugguide.models.College;
import com.yousef.iugguide.models.Department;
import com.yousef.iugguide.models.enums.DepartmentType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class DataHelper {
    private static DataHelper INSTANCE;

    private DataHelper() {
    }

    public static DataHelper getInstance() {
        if (INSTANCE == null)
            INSTANCE = new DataHelper();

        return INSTANCE;
    }

    public void readCollegesData(Context context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.colleges);
            String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();

            JSONObject root = new JSONObject(jsonString);

            JSONArray array = root.getJSONArray("colleges");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                College college = new College();
                college.setId(object.getInt("Id"));
                college.setStudentsCount(object.getInt("num_of_student"));
                college.setLocation(object.getString("location"));
                college.setImageUrl(object.getString("image"));
                college.setFacebookPageLink(object.getString("facebookLink"));
                college.setDescription(object.getString("basic_info"));
                college.setName(object.getString("name"));

                System.out.println("College: " + college);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readDepartmentsData(Context context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.departments);
            String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();

            JSONObject root = new JSONObject(jsonString);

            JSONArray array = root.getJSONArray("departments");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                Department department = new Department();
                department.setId(object.getInt("Id"));
                department.setName(object.getString("name"));
                department.setDescription(object.getString("basic_info"));
                department.setPlanUrl(object.getString("plan_link"));
                department.setFormatKey(object.getString("Format_key"));
                department.setSection(object.getString("section"));
                department.setStudentsCount(object.getInt("num_of_student"));

                department.setCollege(getCollegeById(object.getInt("college_Id")));

                switch (object.getString("Type")) {
                    case "بكالوريوس":
                        department.setDepartmentType(DepartmentType.BACHELOR);
                        break;
                    case "ماجستير":
                        department.setDepartmentType(DepartmentType.MASTER);
                        break;
                    case "دكتوراة":
                        department.setDepartmentType(DepartmentType.DOCTORATE);
                        break;
                }

                System.out.println("Department: " + department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readBuildingsData(Context context) {
    }

    public College getCollegeById(int id) {
        for (int i = 0; i < MainActivity.collegesArrayList.size(); i++) {
            if (MainActivity.collegesArrayList.get(i).getId() == id)
                return MainActivity.collegesArrayList.get(i);
        }
        return null;
    }
}
