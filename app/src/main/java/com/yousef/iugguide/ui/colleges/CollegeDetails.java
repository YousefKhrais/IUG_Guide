package com.yousef.iugguide.ui.colleges;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.R;
import com.yousef.iugguide.adapters.CollegeAdapter;
import com.yousef.iugguide.adapters.DepartmentAdapter;
import com.yousef.iugguide.databinding.ActivityCollegeDetailsBinding;

public class CollegeDetails extends AppCompatActivity {
    ActivityCollegeDetailsBinding binding;
    DepartmentAdapter departmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityCollegeDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.collegeNameTextview.setText(AppClass.chosen_college.getName());
        binding.collegeInfoTextview.setText(AppClass.chosen_college.getDescription());
        binding.collegeLocationTextview.setText(AppClass.chosen_college.getLocation());
        binding.departmentRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        departmentAdapter = new DepartmentAdapter(getApplicationContext(), AppClass.chosen_college.getBachelorDepartments());
        binding.departmentRv.setAdapter(departmentAdapter);


        binding.departmentNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_bachelor:
                    binding.departmentRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    departmentAdapter = new DepartmentAdapter(getApplicationContext(), AppClass.chosen_college.getBachelorDepartments());
                    binding.departmentRv.setAdapter(departmentAdapter);
                    break;
                case R.id.nav_master:
                    binding.departmentRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    departmentAdapter = new DepartmentAdapter(getApplicationContext(), AppClass.chosen_college.getMasterDepartments());
                    binding.departmentRv.setAdapter(departmentAdapter);
                    break;
                case R.id.nav_phd:
                    binding.departmentRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    departmentAdapter = new DepartmentAdapter(getApplicationContext(), AppClass.chosen_college.getDoctorateDepartments());
                    binding.departmentRv.setAdapter(departmentAdapter);
                    break;


            }


            return true;
        });
    }
}