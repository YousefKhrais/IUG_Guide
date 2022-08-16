package com.yousef.iugguide.ui.colleges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.databinding.ActivityDepartmentDetailsBinding;

public class DepartmentDetails extends AppCompatActivity {
ActivityDepartmentDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityDepartmentDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Resources resources = this.getResources();
        final int resourceId = resources.getIdentifier(AppClass.chosen_college.getImageUrl()+"_logo", "drawable", this.getPackageName());
        binding.collegeIcon.setImageDrawable(resources.getDrawable(resourceId));
        final int resourceId1 = resources.getIdentifier(AppClass.chosen_college.getImageUrl()+"_bg", "drawable", this.getPackageName());
        binding.backgroundOfDep.setBackground(resources.getDrawable(resourceId1));

        binding.collegeName.setText(AppClass.chosen_college.getName());
        binding.departmentName.setText(AppClass.chosen_Department.getName());
        binding.departmentInfo.setText(AppClass.chosen_Department.getDescription());
        binding.departmentKey.setText(AppClass.chosen_Department.getFormatKey()+" "+AppClass.chosen_Department.getSection());
        binding.departmentStudyLink.setOnClickListener(v->{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(AppClass.chosen_Department.getPlanUrl()));
            startActivity(i);
        });

        binding.numberOfStudent.setText(String.valueOf(AppClass.chosen_Department.getStudentsCount()));

    }
}