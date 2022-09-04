package com.yousef.iugguide.helpers;

import android.content.Context;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.R;
import com.yousef.iugguide.models.Building;
import com.yousef.iugguide.models.College;
import com.yousef.iugguide.models.Department;
import com.yousef.iugguide.models.Doctor;
import com.yousef.iugguide.models.FAQ;
import com.yousef.iugguide.models.enums.DepartmentType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
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

                college.setBachelorDepartments(new ArrayList<>());
                college.setMasterDepartments(new ArrayList<>());
                college.setDoctorateDepartments(new ArrayList<>());
                college.setProfessors(new ArrayList<>());

                AppClass.collegesArrayList.add(college);
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
                department.setCollegeId(object.getInt("college_Id"));

                for (int j = 0; j < AppClass.collegesArrayList.size(); j++) {
                    if (AppClass.collegesArrayList.get(j).getId() == department.getCollegeId()) {
                        switch (object.getString("Type")) {
                            case "بكالوريوس":
                                department.setDepartmentType(DepartmentType.BACHELOR);
                                AppClass.collegesArrayList.get(j).getBachelorDepartments().add(department);
                                break;
                            case "ماجستير":
                                department.setDepartmentType(DepartmentType.MASTER);
                                AppClass.collegesArrayList.get(j).getMasterDepartments().add(department);
                                break;
                            case "دكتوراة":
                                department.setDepartmentType(DepartmentType.DOCTORATE);
                                AppClass.collegesArrayList.get(j).getDoctorateDepartments().add(department);
                                break;
                        }
                    }
                }

                AppClass.departmentsArrayList.add(department);
                System.out.println("Department: " + department);
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
//                building.setKey(object.getString("building_keysss"));
                building.setKey("K");

                ArrayList<String> imagesArrayList = new ArrayList<>();
                String[] other_images = object.getString("other_images").split("\r\n");

                for (int j = 0; j < other_images.length; j++) {
                    imagesArrayList.add(other_images[j]);
                }

                building.setImagesArrayList(imagesArrayList);

                AppClass.buildingArrayList.add(building);
                System.out.println("Building: " + building);
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

                System.out.println(object.toString());
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
        AppClass.faqArrayList.add(new FAQ(0, "1. متى تنتهي عملية السحب والإضافة ؟", "تنتهي عملية السحب بنهاية الأسبوع الثالث من بدء الدراسة، أما الإضافة فتنتهي بنهاية الأسبوع الثاني من بدء الدراسة في الفصل العادي، بينما في الفصل الصيفي تنتهي عملية السحب بنهاية الأسبوع الثاني من بدء الدراسة، أما الإضافة فتنتهي بنهاية الأسبوع الأول من بدء الدراسة."));
        AppClass.faqArrayList.add(new FAQ(1, "2. أنا طالب دفعت رسوم التسجيل بعد إيقاف التسجيل، هل يمكنني التسجيل؟", "لا يمكن تمديد فترة التسجيل و لكن ينظر في بعض الأعذار الخاصة من خلال القضايا الطلابية التي تقدم للجنة الثلاثية ولفترة محدودة."));
        AppClass.faqArrayList.add(new FAQ(2, "3. أثناء جلوسي على الانترنت سحبت مساق بالخطأ وأريد إرجاعه لكن فترة التسجيل انتهت، ماذا أفعل ؟", "أرسل رسالة عبر الايميل لمدير القبول والتسجيل في مدة لا تزيد عن 24 ساعة. أو يمكنك مراجعة المسجلين/ المسجلات في صالات القبول والتسجيل."));
        AppClass.faqArrayList.add(new FAQ(3, "4. إذا أردت معادلة مساق، ماذا أفعل ؟", "توجه إلى المرشد الأكاديمي أو الموظف المختص بالمعادلات في كليتك، و إذا واجهتك مشكلة توجه إلى رئيس قسمك."));
        AppClass.faqArrayList.add(new FAQ(4, "5. أنا طالب أريد الدخول برقم جديد، فماذا أفعل ؟", "يسمح لك ولمرة واحدة فقط على نفس شهادة الثانوية العامة حسب النظام."));
        AppClass.faqArrayList.add(new FAQ(5, "6. أنا طالب أريد تسجيل 22 ساعة، فماذا أفعل ؟", "يسمح للطالب بتسجيل 22 ساعة كحد أقصى في حالتين : أ. الطالب الحاصل على معدل تراكمي 80% فأكثر. ب. الطالب في المستوى الأخير بشرط ألا يقل معدله التراكمي عن 65%."));
        AppClass.faqArrayList.add(new FAQ(6, "7. أنا طالب محذر و متبقي لي (16) ساعة للتخرج، كيف أسجلها ؟", "لا يسمح للطالب المحذر بتسجيل أكثر من 15 ساعة معتمدة حسب النظام حتى في فصل التخرج."));
        AppClass.faqArrayList.add(new FAQ(7, "8. أنا طالب عندي غير مكتمل، أريد تسجيل ساعات مكتبية، كيف يمكنني ذلك ؟", "لا يحق للطالب تسجيل ساعات مكتبية إلا بعد النجاح في كافة المساقات التي تسبق فصل تسجيل الساعات المكتبية حتى مساقات غير المكتمل."));
        AppClass.faqArrayList.add(new FAQ(8, "9. ما هو حل الشعب المغلقة ؟", "لا يمكن توسيع الشعب المغلقة، ولكن في حالة الضرورة توجه لرئيس القسم الأكاديمي للمساق."));
        AppClass.faqArrayList.add(new FAQ(9, "10. أنا طالب خريج لم أستطع دفع رسوم التخرج وأريد استلام الشهادة، فماذا أفعل ؟ وهل يوجد إفادة خريج ؟", "لا يوجد إفادة تخرج، راجع شئون الطلبة لدراسة إمكانية المساعدة في الرسوم."));
        AppClass.faqArrayList.add(new FAQ(10, "11. إذا كان الطالب يستفيد من منحة أبناء الأسرى أو القرآن الكريم، ولم يستطع التسجيل عن طريق صفحته الإلكترونية، فماذا يفعل ؟", "تأكد من وجود المنحة في ملفك المالي.\n\nفي حال لم تكن المنحة موجودة تأكد من تحقق شروط المنحة و راجع شئون الطلبة."));
        AppClass.faqArrayList.add(new FAQ(11, "12. أنا طالب أريد تسجيل مساق له متطلب سابق و رئيس القسم يرفض تسجيلها، ماذا أفعل ؟", "رئيس القسم هو من يملك حق اتخاذ القرار في ذلك وحسب النظام."));
        AppClass.faqArrayList.add(new FAQ(12, "13. أنا طالب خريج، و عندي مساق غير مطروح، ماذا أفعل حتى أتخرج هذا الفصل ؟", "توجه إلى المرشد الأكاديمي أو رئيس القسم لتسجيل مساق بديل إذا توفر البديل."));
        AppClass.faqArrayList.add(new FAQ(13, "14. انتهت الفترة القانونية لتقديم طلبات الالتحاق في الجامعة فماذا أفعل ؟", "بإمكانك الالتحاق في الفصل التالي، حيث أن قبول الطلبة الجدد يكون على الفصلين الأول والثاني."));
        AppClass.faqArrayList.add(new FAQ(14, "15. هل يمكن تسجيل مساقات متعارضة بالمحاضرات ؟", "لا يمكن ذلك لمخالفة النظام الملزم بحضور 75% على الأقل من مجموع ساعات تدريس المساق."));
        AppClass.faqArrayList.add(new FAQ(15, "16. أنا طالب أنهى هذا الفصل دراسة كافة مساقات الخطة الدراسية المقرر علي دراستها ماذا أفعل ؟", "– تأكد من كتابة اسمك باللغة الإنجليزية بالطريقة الصحيحة حسب جواز السفر أو أي وثيقة رسمية.\n\n– تأكد من إنهاء جميع متعلقات الكلية والمكتبة المركزية.\n\n– تأكد من رصد جميع العلامات و معادلة المساقات إن وجدت.\n\n– تأكد من تحويل حالتك الأكاديمية من منتظم إلى خريج.\n\nتوجه بالترتيب حسب الآتي :\n\n– قم بتعبئة استبانه الخريج الموجودة على صفحتك الإلكترونية.\n\n– للطلبة المستفيدين من خدمات شؤون الطلبة (القروض و المنح الداخلية والخارجية) مراجعة شؤون الطلبة.\n\n– توجه للدائرة المالية لتدقيق ملفك المالي.\n\n– توجه للدائرة المالية لدفع رسوم التخرج.\n\n– راجع عمادة القبول والتسجيل بعد استلامك لرسالة SMS من العمادة بالتوجه لاستلام وثائق التخرج."));
        AppClass.faqArrayList.add(new FAQ(16, "17. كيف يمكن للطالب تغيير الخطة الدراسية التي يدرس عليها إلى خطة أخرى ؟", "عن طريق رئيس القسم."));
        AppClass.faqArrayList.add(new FAQ(17, "18. كيف يمكن للطالب تغيير مكان الدراسة (فرع الجامعة التي يدرس بها سواء غزة أو خانيونس) ؟", "يتم التغيير عن طريق عمادة القبول والتسجيل إما بإرسال طلب من خلال البريد الالكتروني، أو مراجعة العمادة شخصياً إن تعذر إرسال رسالة."));
        AppClass.faqArrayList.add(new FAQ(18, "19. ما هو الحد المسموح به للتغيب عن المحاضرات في مساق دراسي معين ؟", "– لا يسمح للطالب بالتغيب عن أكثر من 25% من مجموع ساعات تدريس المساق.\n\n– إذا تغيب الطالب عن أكثر من 25% من مجموع ساعات تدريس المساق دون عذر يقبله عميد الكلية يحرم الطالب من التقدم للامتحان النهائي لذلك المساق ويرصد له الصفر الجامعي، أما في حالة قبول العذر يعد منسحباً من المساق."));
        AppClass.faqArrayList.add(new FAQ(19, "20. ماذا يحدث إذا تغيب الطالب عن الامتحان النهائي ؟", "– يرسب الطالب في المقرر و ترصد علامته 40 (صفر جامعي)."));
        AppClass.faqArrayList.add(new FAQ(20, "21. ما هي الأعذار المقبولة للتغيب عن الامتحان النهائي، والتي بناء عليها يمكن منح قرار الغير مكتمل ؟", "– مرض مشفوع بتقريرطبي رسمي معتمد من الدائرة الطبية بالجامعة.\n\n– وفاة أحد المقربين من الدرجة الأولى مع إحضار صورة عن شهادة الوفاة."));
        AppClass.faqArrayList.add(new FAQ(21, "22. كيف يتم الحصول على القروض و المنح الجامعية ؟", "– قم بتعبئة استمارة البحث الاجتماعي من خلال صفحتك الإلكترونية.\n\n– تابع الإعلانات الصادرة عن عمادة شؤون الطلبة.\n\n– إذا كان هناك مشكلة راجع عمادة شؤون الطلبة."));
        AppClass.faqArrayList.add(new FAQ(22, "23. هل بإمكان الطلبة ممارسة هواياتهم أو الرياضة داخل الحرم الجامعي ؟", "نعم وهناك العديد من المجالات الرياضية والبدنية والذهنية ، وللمزيد راجع قسم الإشراف الرياضي في عمادة شؤون الطلبة."));
        AppClass.faqArrayList.add(new FAQ(23, "25. كم مرة يسمح للطالب بالتحويل داخل الجامعة ؟", "مرتان برغبته."));
        AppClass.faqArrayList.add(new FAQ(24, "26. أنا طالب لم أحصل على معدل جيد في السنة الدراسية الأولى، و أرغب بالالتحاق برقم جديد، هل يمكنني ذلك؟ و كم عدد الساعات التي يمكن معادلتها ؟", "– نعم يمكنك الالتحاق برقم جديد ولمرة واحدة فقط حسب النظام .\n– الحد الأقصى من الساعات المسموح معادلتها 30 ساعة معتمدة فقط و بعلامة لا تقل عن 70 لكل مساق يمكن معادلته."));

//        AppClass.faqArrayList.add(new FAQ(25, "", ""));
//        AppClass.faqArrayList.add(new FAQ(26, "", ""));
//        AppClass.faqArrayList.add(new FAQ(27, "", ""));
//        AppClass.faqArrayList.add(new FAQ(28, "", ""));
//        AppClass.faqArrayList.add(new FAQ(29, "", ""));
//        AppClass.faqArrayList.add(new FAQ(30, "", ""));
//        AppClass.faqArrayList.add(new FAQ(31, "", ""));
//        AppClass.faqArrayList.add(new FAQ(32, "", ""));
//        AppClass.faqArrayList.add(new FAQ(33, "", ""));
//        AppClass.faqArrayList.add(new FAQ(34, "", ""));
//        AppClass.faqArrayList.add(new FAQ(35, "", ""));
//        AppClass.faqArrayList.add(new FAQ(36, "", ""));
//        AppClass.faqArrayList.add(new FAQ(37, "", ""));
//        AppClass.faqArrayList.add(new FAQ(38, "", ""));
//        AppClass.faqArrayList.add(new FAQ(39, "", ""));
//        AppClass.faqArrayList.add(new FAQ(40, "", ""));
//        AppClass.faqArrayList.add(new FAQ(41, "", ""));
    }
}
