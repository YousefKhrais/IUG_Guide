package com.yousef.iugguide.ui.colleges;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.R;
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
        binding.departmentRv.setLayoutManager(new LinearLayoutManager(this));
        departmentAdapter = new DepartmentAdapter(this, AppClass.chosen_college.getBachelorDepartments());
        binding.departmentRv.setAdapter(departmentAdapter);

        ViewGroup.LayoutParams params=binding.departmentRv.getLayoutParams();
        binding.departmentNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_bachelor:
                    if ( AppClass.chosen_college.getBachelorDepartments().size()==0){
                        params.height=1;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.INVISIBLE);
                        binding.infoText.setVisibility(View.VISIBLE);
                    }else{
                        params.height=500;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.VISIBLE);
                        binding.infoText.setVisibility(View.INVISIBLE);
                    binding.departmentRv.setLayoutManager(new LinearLayoutManager(this));
                    departmentAdapter = new DepartmentAdapter(this, AppClass.chosen_college.getBachelorDepartments());
                    binding.departmentRv.setAdapter(departmentAdapter);}
                    break;
                case R.id.nav_master:
                    if ( AppClass.chosen_college.getMasterDepartments().size()==0){
                        params.height=1;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.INVISIBLE);
                        binding.infoText.setVisibility(View.VISIBLE);
                    }else{
                        params.height=500;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.VISIBLE);
                        binding.infoText.setVisibility(View.INVISIBLE);
                        binding.departmentRv.setLayoutManager(new LinearLayoutManager(this));
                        departmentAdapter = new DepartmentAdapter(this, AppClass.chosen_college.getMasterDepartments());
                        binding.departmentRv.setAdapter(departmentAdapter);}
                    break;
                case R.id.nav_phd:
                    if ( AppClass.chosen_college.getDoctorateDepartments().size()==0){
                        params.height=1;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.INVISIBLE);
                        binding.infoText.setVisibility(View.VISIBLE);
                    }else{
                        params.height=500;
                        binding.departmentRv.setLayoutParams(params);
                        binding.departmentRv.setVisibility(View.VISIBLE);
                        binding.infoText.setVisibility(View.INVISIBLE);
                        binding.departmentRv.setLayoutManager(new LinearLayoutManager(this));
                        departmentAdapter = new DepartmentAdapter(this, AppClass.chosen_college.getDoctorateDepartments());
                        binding.departmentRv.setAdapter(departmentAdapter);}
                    break;


            }


            return true;
        });
    }
}