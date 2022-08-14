package com.yousef.iugguide.ui.colleges;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yousef.iugguide.databinding.ActivityCollegeDetailsBinding;

public class CollegeDetails extends AppCompatActivity {
ActivityCollegeDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityCollegeDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}