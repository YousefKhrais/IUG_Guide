package com.yousef.iugguide.ui.colleges;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.R;
import com.yousef.iugguide.adapters.DepartmentAdapter;
import com.yousef.iugguide.adapters.DoctorsAdapter;
import com.yousef.iugguide.databinding.ActivityCollegeDetailsBinding;

public class CollegeDetails extends AppCompatActivity {

    private ActivityCollegeDetailsBinding binding;
    private DepartmentAdapter departmentAdapter;
    private DoctorsAdapter doctorsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityCollegeDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.collegeNameTextview.setText(AppClass.chosenCollege.getName());
        binding.collegeInfoTextview.setText(AppClass.chosenCollege.getDescription());
        binding.collegeLocationTextview.setText(AppClass.chosenCollege.getLocation());
        binding.departmentRv.setLayoutManager(new LinearLayoutManager(this));

        departmentAdapter = new DepartmentAdapter(this, AppClass.chosenCollege.getBachelorDepartments());
        binding.departmentRv.setAdapter(departmentAdapter);

        ViewGroup.LayoutParams params = binding.departmentRv.getLayoutParams();

        binding.departmentNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_bachelor:
                    if (AppClass.chosenCollege.getBachelorDepartments().size() == 0) {
                        params.height = 1;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.INVISIBLE);
                        binding.infoText.setVisibility(View.VISIBLE);
                    } else {
                        params.height = 1200;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.VISIBLE);
                        binding.infoText.setVisibility(View.INVISIBLE);
                        binding.departmentRv.setLayoutManager(new LinearLayoutManager(this));
                        departmentAdapter = new DepartmentAdapter(this, AppClass.chosenCollege.getBachelorDepartments());
                        binding.departmentRv.setAdapter(departmentAdapter);
                    }
                    break;

                case R.id.nav_master:
                    if (AppClass.chosenCollege.getMasterDepartments().size() == 0) {
                        params.height = 1;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.INVISIBLE);
                        binding.infoText.setVisibility(View.VISIBLE);
                    } else {
                        params.height = 1200;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.VISIBLE);
                        binding.infoText.setVisibility(View.INVISIBLE);
                        binding.departmentRv.setLayoutManager(new LinearLayoutManager(this));
                        departmentAdapter = new DepartmentAdapter(this, AppClass.chosenCollege.getMasterDepartments());
                        binding.departmentRv.setAdapter(departmentAdapter);
                    }
                    break;

                case R.id.nav_phd:
                    if (AppClass.chosenCollege.getDoctorateDepartments().size() == 0) {
                        params.height = 1;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.INVISIBLE);
                        binding.infoText.setVisibility(View.VISIBLE);
                    } else {
                        params.height = 1200;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.VISIBLE);
                        binding.infoText.setVisibility(View.INVISIBLE);
                        binding.departmentRv.setLayoutManager(new LinearLayoutManager(this));
                        departmentAdapter = new DepartmentAdapter(this, AppClass.chosenCollege.getDoctorateDepartments());
                        binding.departmentRv.setAdapter(departmentAdapter);
                    }
                    break;

                case R.id.nav_doctors:
                    params.height = 1200;
                    binding.departmentRv.setLayoutParams(params);
                    binding.departmentRv.setVisibility(View.VISIBLE);
                    binding.departmentRv.setLayoutManager(new LinearLayoutManager(this));
                    doctorsAdapter = new DoctorsAdapter(this, AppClass.chosenCollege.getProfessors());
                    binding.departmentRv.setAdapter(doctorsAdapter);
                    break;
            }

            return true;
        });
    }
}