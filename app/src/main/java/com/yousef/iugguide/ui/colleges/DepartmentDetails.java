package com.yousef.iugguide.ui.colleges;

import androidx.appcompat.app.AppCompatActivity;

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
        binding.collegeInfoTextview.setText(AppClass.chosen_Department.getName());
    }
}