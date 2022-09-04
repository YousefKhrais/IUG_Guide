package com.yousef.iugguide.ui.buildings;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.databinding.ActivityBuildingDetailsBinding;

import java.util.ArrayList;

public class BuildingDetails extends AppCompatActivity {

    ActivityBuildingDetailsBinding binding;
    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBuildingDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageSlider = binding.imageslider;

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        for (String image : AppClass.chosenBuilding.getImagesArrayList())
            slideModels.add(new SlideModel(image, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        binding.buildingName.setText(AppClass.chosenBuilding.getName());
        binding.buildingInfo.setText("تاريخ المبنى : " + AppClass.chosenBuilding.getDescription());
        binding.buildingLocation.setText("مكان المبنى : " + AppClass.chosenBuilding.getLocation());
        binding.buildingKey.setText(AppClass.chosenBuilding.getKey());
    }
}