package com.yousef.iugguide.helpers;

import android.content.Context;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.R;
import com.yousef.iugguide.models.Building;
import com.yousef.iugguide.models.Center;
import com.yousef.iugguide.models.College;
import com.yousef.iugguide.models.Contact;
import com.yousef.iugguide.models.Department;
import com.yousef.iugguide.models.Doctor;
import com.yousef.iugguide.models.FAQ;
import com.yousef.iugguide.models.enums.DepartmentType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
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

    public static Contact findContactByTitle(String title) {
        for (int i = 0; i < AppClass.contactsArrayList.size(); i++) {
            if (AppClass.contactsArrayList.get(i).getTitle().equals(title))
                return AppClass.contactsArrayList.get(i);
        }
        return null;
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
                college.setInfoLink(object.getString("infoLink"));
                college.setBachelorDepartments(new ArrayList<>());
                college.setMasterDepartments(new ArrayList<>());
                college.setDoctorateDepartments(new ArrayList<>());
                college.setProfessors(new ArrayList<>());

                AppClass.collegesArrayList.add(college);
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
                department.setCollegeId(object.getInt("college_Id"));

                for (int j = 0; j < AppClass.collegesArrayList.size(); j++) {
                    if (AppClass.collegesArrayList.get(j).getId() == department.getCollegeId()) {
                        switch (object.getString("Type")) {
                            case "??????????????????":
                                department.setDepartmentType(DepartmentType.BACHELOR);
                                AppClass.collegesArrayList.get(j).getBachelorDepartments().add(department);
                                break;
                            case "??????????????":
                                department.setDepartmentType(DepartmentType.MASTER);
                                AppClass.collegesArrayList.get(j).getMasterDepartments().add(department);
                                break;
                            case "??????????????":
                                department.setDepartmentType(DepartmentType.DOCTORATE);
                                AppClass.collegesArrayList.get(j).getDoctorateDepartments().add(department);
                                break;
                        }
                    }
                }

                AppClass.departmentsArrayList.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readBuildingsData(Context context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.buildings);
            String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();

            JSONObject root = new JSONObject(jsonString);

            JSONArray array = root.getJSONArray("buildings");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                Building building = new Building();

                building.setId(i);
                building.setName(object.getString("building_name"));
                building.setMainImageUrl(object.getString("main_image"));
                building.setDescription(object.getString("main_info"));
                building.setLocation(object.getString("location"));
                building.setKey(object.getString("building_key"));

                ArrayList<String> imagesArrayList = new ArrayList<>();
                String[] other_images = object.getString("other_images").split("\r\n");

                Collections.addAll(imagesArrayList, other_images);

                building.setImagesArrayList(imagesArrayList);

                AppClass.buildingArrayList.add(building);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readProfessorsData(Context context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.professor);
            String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();

            JSONObject root = new JSONObject(jsonString);

            JSONArray array = root.getJSONArray("professors");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                Doctor doctor = new Doctor();
                doctor.setId(object.getInt("id"));
                doctor.setName(object.getString("fullName"));
                doctor.setCollege(object.getString("college"));
                doctor.setDepartment(object.getString("department"));
                doctor.setDegree(object.getString("degre"));
                doctor.setInsidePhone(object.getString("insidePhone"));
                doctor.setEmail(object.getString("email"));

                for (int j = 0; j < AppClass.collegesArrayList.size(); j++) {
                    if (AppClass.collegesArrayList.get(j).getName().equals(doctor.getCollege())) {
                        doctor.setCollegeId(AppClass.collegesArrayList.get(j).getId());
                        AppClass.collegesArrayList.get(j).getProfessors().add(doctor);
                    }
                }

                AppClass.doctorsArrayList.add(doctor);
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }

    public void readFaqData(Context context) {
        AppClass.faqArrayList.add(new FAQ(0, "1. ?????? ?????????? ?????????? ?????????? ???????????????? ??", "?????????? ?????????? ?????????? ???????????? ?????????????? ???????????? ???? ?????? ???????????????? ?????? ?????????????? ???????????? ???????????? ?????????????? ???????????? ???? ?????? ?????????????? ???? ?????????? ?????????????? ?????????? ???? ?????????? ???????????? ?????????? ?????????? ?????????? ???????????? ?????????????? ???????????? ???? ?????? ???????????????? ?????? ?????????????? ???????????? ???????????? ?????????????? ?????????? ???? ?????? ??????????????."));
        AppClass.faqArrayList.add(new FAQ(1, "2. ?????? ???????? ???????? ???????? ?????????????? ?????? ?????????? ???????????????? ???? ???????????? ?????????????? ??", "???? ???????? ?????????? ???????? ?????????????? ?? ?????? ???????? ???? ?????? ?????????????? ???????????? ???? ???????? ?????????????? ???????????????? ???????? ???????? ?????????? ???????????????? ???????????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(2, "3. ?????????? ?????????? ?????? ???????????????? ???????? ???????? ???????????? ?????????? ???????????? ?????? ???????? ?????????????? ???????????? ???????? ???????? ??", "???????? ?????????? ?????? ?????????????? ?????????? ???????????? ???????????????? ???? ?????? ???? ???????? ???? 24 ????????. ???? ?????????? ???????????? ????????????????/ ???????????????? ???? ?????????? ???????????? ????????????????."));
        AppClass.faqArrayList.add(new FAQ(3, "4. ?????? ???????? ???????????? ?????????? ???????? ???????? ??", "???????? ?????? ???????????? ?????????????????? ???? ???????????? ???????????? ???????????????????? ???? ???????????? ?? ?????? ???????????? ?????????? ???????? ?????? ???????? ????????."));
        AppClass.faqArrayList.add(new FAQ(4, "5. ?????? ???????? ???????? ???????????? ???????? ?????????? ?????????? ???????? ??", "???????? ???? ?????????? ?????????? ?????? ?????? ?????? ?????????? ???????????????? ???????????? ?????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(5, "6. ?????? ???????? ???????? ?????????? 22 ?????????? ?????????? ???????? ??", "???????? ???????????? ???????????? 22 ???????? ?????? ???????? ???? ???????????? : ??. ???????????? ???????????? ?????? ???????? ???????????? 80% ??????????. ??. ???????????? ???? ?????????????? ???????????? ???????? ?????? ?????? ?????????? ???????????????? ???? 65%."));
        AppClass.faqArrayList.add(new FAQ(6, "7. ?????? ???????? ???????? ?? ?????????? ???? (16) ???????? ?????????????? ?????? ???????????? ??", "???? ???????? ???????????? ???????????? ???????????? ???????? ???? 15 ???????? ???????????? ?????? ???????????? ?????? ???? ?????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(7, "8. ?????? ???????? ???????? ?????? ???????????? ???????? ?????????? ?????????? ?????????????? ?????? ???????????? ?????? ??", "???? ?????? ???????????? ?????????? ?????????? ???????????? ?????? ?????? ???????????? ???? ???????? ???????????????? ???????? ???????? ?????? ?????????? ?????????????? ???????????????? ?????? ???????????? ?????? ??????????????."));
        AppClass.faqArrayList.add(new FAQ(8, "9. ???? ???? ???? ?????????? ?????????????? ??", "???? ???????? ?????????? ?????????? ???????????????? ???????? ???? ???????? ?????????????? ???????? ?????????? ?????????? ?????????????????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(9, "10. ?????? ???????? ???????? ???? ?????????? ?????? ???????? ???????????? ?????????? ???????????? ???????????????? ?????????? ???????? ?? ?????? ???????? ?????????? ???????? ??", "???? ???????? ?????????? ?????????? ???????? ???????? ???????????? ???????????? ?????????????? ???????????????? ???? ????????????."));
        AppClass.faqArrayList.add(new FAQ(10, "11. ?????? ?????? ???????????? ???????????? ???? ???????? ?????????? ???????????? ???? ???????????? ?????????????? ?????? ?????????? ?????????????? ???? ???????? ?????????? ???????????????????????? ?????????? ???????? ??", "???????? ???? ???????? ???????????? ???? ???????? ????????????.\n\n???? ?????? ???? ?????? ???????????? ???????????? ???????? ???? ???????? ???????? ???????????? ?? ???????? ???????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(11, "12. ?????? ???????? ???????? ?????????? ???????? ???? ?????????? ???????? ?? ???????? ?????????? ???????? ???????????????? ???????? ???????? ??", "???????? ?????????? ???? ???? ???????? ???? ?????????? ???????????? ???? ?????? ???????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(12, "13. ?????? ???????? ?????????? ?? ???????? ???????? ?????? ???????????? ???????? ???????? ?????? ?????????? ?????? ?????????? ??", "???????? ?????? ???????????? ?????????????????? ???? ???????? ?????????? ???????????? ???????? ???????? ?????? ???????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(13, "14. ?????????? ???????????? ?????????????????? ???????????? ?????????? ???????????????? ???? ?????????????? ?????????? ???????? ??", "?????????????? ???????????????? ???? ?????????? ?????????????? ?????? ???? ???????? ???????????? ?????????? ???????? ?????? ?????????????? ?????????? ??????????????."));
        AppClass.faqArrayList.add(new FAQ(14, "15. ???? ???????? ?????????? ???????????? ?????????????? ???????????????????? ??", "???? ???????? ?????? ?????????????? ???????????? ???????????? ?????????? 75% ?????? ?????????? ???? ?????????? ?????????? ?????????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(15, "16. ?????? ???????? ???????? ?????? ?????????? ?????????? ???????? ???????????? ?????????? ???????????????? ???????????? ?????? ?????????????? ???????? ???????? ??", "??? ???????? ???? ?????????? ???????? ???????????? ???????????????????? ???????????????? ?????????????? ?????? ???????? ?????????? ???? ???? ?????????? ??????????.\n\n??? ???????? ???? ?????????? ???????? ?????????????? ???????????? ???????????????? ????????????????.\n\n??? ???????? ???? ?????? ???????? ???????????????? ?? ???????????? ???????????????? ???? ????????.\n\n??? ???????? ???? ?????????? ?????????? ???????????????????? ???? ?????????? ?????? ????????.\n\n???????? ???????????????? ?????? ?????????? :\n\n??? ???? ???????????? ?????????????? ???????????? ???????????????? ?????? ?????????? ??????????????????????.\n\n??? ???????????? ???????????????????? ???? ?????????? ???????? ???????????? (???????????? ?? ?????????? ???????????????? ??????????????????) ???????????? ???????? ????????????.\n\n??? ???????? ?????????????? ?????????????? ???????????? ???????? ????????????.\n\n??? ???????? ?????????????? ?????????????? ???????? ???????? ????????????.\n\n??? ???????? ?????????? ???????????? ???????????????? ?????? ?????????????? ???????????? SMS ???? ?????????????? ?????????????? ?????????????? ?????????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(16, "17. ?????? ???????? ???????????? ?????????? ?????????? ???????????????? ???????? ???????? ?????????? ?????? ?????? ???????? ??", "???? ???????? ???????? ??????????."));
        AppClass.faqArrayList.add(new FAQ(17, "18. ?????? ???????? ???????????? ?????????? ???????? ?????????????? (?????? ?????????????? ???????? ???????? ?????? ???????? ?????? ???? ??????????????) ??", "?????? ?????????????? ???? ???????? ?????????? ???????????? ???????????????? ?????? ???????????? ?????? ???? ???????? ???????????? ?????????????????????? ???? ???????????? ?????????????? ???????????? ???? ???????? ?????????? ??????????."));
        AppClass.faqArrayList.add(new FAQ(18, "19. ???? ???? ???????? ?????????????? ???? ???????????? ???? ?????????????????? ???? ???????? ?????????? ???????? ??", "??? ???? ???????? ???????????? ?????????????? ???? ???????? ???? 25% ???? ?????????? ?????????? ?????????? ????????????.\n\n??? ?????? ???????? ???????????? ???? ???????? ???? 25% ???? ?????????? ?????????? ?????????? ???????????? ?????? ?????? ?????????? ???????? ???????????? ???????? ???????????? ???? ???????????? ???????????????? ?????????????? ???????? ???????????? ?????????? ???? ?????????? ???????????????? ?????? ???? ???????? ???????? ?????????? ?????? ?????????????? ???? ????????????."));
        AppClass.faqArrayList.add(new FAQ(19, "20. ???????? ???????? ?????? ???????? ???????????? ???? ???????????????? ?????????????? ??", "??? ???????? ???????????? ???? ???????????? ?? ???????? ???????????? 40 (?????? ??????????)."));
        AppClass.faqArrayList.add(new FAQ(20, "21. ???? ???? ?????????????? ???????????????? ???????????? ???? ???????????????? ???????????????? ?????????? ???????? ?????????? ???????? ?????? ???????? ?????????? ?????????? ??", "??? ?????? ?????????? ?????????????????? ???????? ?????????? ???? ?????????????? ???????????? ????????????????.\n\n??? ???????? ?????? ???????????????? ???? ???????????? ???????????? ???? ?????????? ???????? ???? ?????????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(21, "22. ?????? ?????? ???????????? ?????? ???????????? ?? ?????????? ???????????????? ??", "??? ???? ???????????? ?????????????? ?????????? ?????????????????? ???? ???????? ?????????? ??????????????????????.\n\n??? ???????? ?????????????????? ?????????????? ???? ?????????? ???????? ????????????.\n\n??? ?????? ?????? ???????? ?????????? ???????? ?????????? ???????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(22, "23. ???? ???????????? ???????????? ???????????? ???????????????? ???? ?????????????? ???????? ?????????? ?????????????? ??", "?????? ?????????? ???????????? ???? ???????????????? ???????????????? ???????????????? ???????????????? ?? ?????????????? ???????? ?????? ?????????????? ?????????????? ???? ?????????? ???????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(23, "25. ???? ?????? ???????? ???????????? ???????????????? ???????? ?????????????? ??", "?????????? ????????????."));
        AppClass.faqArrayList.add(new FAQ(24, "26. ?????? ???????? ???? ???????? ?????? ???????? ?????? ???? ?????????? ???????????????? ?????????????? ?? ???????? ?????????????????? ???????? ?????????? ???? ???????????? ???????? ?? ???? ?????? ?????????????? ???????? ???????? ???????????????? ??", "??? ?????? ?????????? ???????????????? ???????? ???????? ?????????? ?????????? ?????? ?????? ???????????? .\n??? ???????? ???????????? ???? ?????????????? ?????????????? ???????????????? 30 ???????? ???????????? ?????? ?? ???????????? ???? ?????? ???? 70 ?????? ???????? ???????? ??????????????."));
    }

    public void readFacilitiesData(Context context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.facilities);
            String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();

            JSONObject root = new JSONObject(jsonString);

            JSONArray array = root.getJSONArray("facilities");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                Building building = new Building();

                building.setId(i);
                building.setName(object.getString("building_name"));
                building.setMainImageUrl(object.getString("main_image"));
                building.setDescription(object.getString("main_info"));
                building.setLocation(object.getString("location"));
                building.setKey(object.getString("building_key"));

                ArrayList<String> imagesArrayList = new ArrayList<>();
                String[] other_images = object.getString("other_images").split("\r\n");

                Collections.addAll(imagesArrayList, other_images);

                building.setImagesArrayList(imagesArrayList);

                AppClass.facilitiesArrayList.add(building);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readContactsData(Context context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.contacts);
            String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();

            JSONObject root = new JSONObject(jsonString);

            JSONArray array = root.getJSONArray("contacts");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                Contact contact = new Contact();

                contact.setId(i);
                contact.setTitle(object.getString("title"));
                contact.setType(object.getString("type"));
                contact.setUrl(object.getString("url"));
                contact.setEmail(object.getString("email"));
                contact.setAbout(object.getString("about"));

                AppClass.contactsArrayList.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readCentersData(Context context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.centers);
            String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();

            JSONObject root = new JSONObject(jsonString);

            JSONArray array = root.getJSONArray("centers");

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                Center center = new Center();

                center.setId(i);
                center.setTitle(object.getString("title"));
                center.setImageUrl(object.getString("image"));
                center.setUrl(object.getString("url"));
                center.setEmail(object.getString("email"));
                center.setAbout(object.getString("about"));

                if (center.getImageUrl().equals("0"))
                    center.setImageUrl("logo_iug");

                AppClass.centersArrayList.add(center);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
