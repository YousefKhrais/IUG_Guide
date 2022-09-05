package com.yousef.iugguide.ui.colleges;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.databinding.ActivityDepartmentDetailsBinding;

public class DepartmentDetails extends AppCompatActivity {

    private ActivityDepartmentDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityDepartmentDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Resources resources = this.getResources();
        final int resourceId = resources.getIdentifier("logo_" + AppClass.chosenCollege.getImageUrl(), "drawable", this.getPackageName());
        binding.collegeIcon.setImageDrawable(resources.getDrawable(resourceId));

        binding.collegeName.setText(AppClass.chosenCollege.getName());
        binding.departmentName.setText(AppClass.chosenDepartment.getName());
        binding.departmentInfo.setText(AppClass.chosenDepartment.getDescription());
        binding.departmentKey.setText(AppClass.chosenDepartment.getFormatKey() + " " + AppClass.chosenDepartment.getSection());
        binding.departmentStudyLink.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(AppClass.chosenDepartment.getPlanUrl()));
            startActivity(i);
        });

        binding.numberOfStudent.setText(String.valueOf(AppClass.chosenDepartment.getStudentsCount()));

    }
}