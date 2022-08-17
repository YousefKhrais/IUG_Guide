package com.yousef.iugguide.ui.guide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yousef.iugguide.databinding.ActivityRegistrationGuideBinding;

public class RegistrationGuide extends AppCompatActivity {

    ActivityRegistrationGuideBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}