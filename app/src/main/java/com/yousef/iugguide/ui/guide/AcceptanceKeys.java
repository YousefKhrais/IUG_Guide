package com.yousef.iugguide.ui.guide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yousef.iugguide.databinding.ActivityAcceptanceKeysBinding;

public class AcceptanceKeys extends AppCompatActivity {

    ActivityAcceptanceKeysBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAcceptanceKeysBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}