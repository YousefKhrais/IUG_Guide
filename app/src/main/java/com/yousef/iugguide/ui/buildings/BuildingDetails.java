package com.yousef.iugguide.ui.buildings;

import android.content.res.Resources;
import android.net.Uri;
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
//        for (String image : AppClass.chosenBuilding.getImagesArrayList()) {
//            Resources resources = this.getResources();
//            final int resourceId = resources.getIdentifier("img_" + image, "drawable", this.getPackageName());
//            Uri imageURI = Uri.parse("android.resource://com.yousef.iugguide/" + resourceId);
//            slideModels.add(new SlideModel(imageURI.toString(), ScaleTypes.FIT));
//        }
        slideModels.add(new SlideModel("https://lh3.googleusercontent.com/drive-viewer/AJc5JmTloANyCHLRPGcY0NacwxhC-AzH0ksRTkxMWJMDm1ZB4b7nGV9oVOlckR-HTMWoKUYCtTBy6Qg=w1366-h697",ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://lh3.googleusercontent.com/drive-viewer/AJc5JmR5fAhZJez48q07Fdvn7RJNkR8WoPp2xbuV0xV83ydsXpJ3YMaTnRtzMhYse-QQXJ_R9GtK2f8=w1920-h929",ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        binding.buildingName.setText(AppClass.chosenBuilding.getName());
        binding.buildingInfo.setText("تاريخ المبنى : " + AppClass.chosenBuilding.getDescription());
        binding.buildingLocation.setText("مكان المبنى : " + AppClass.chosenBuilding.getLocation());
        binding.buildingKey.setText(AppClass.chosenBuilding.getKey());
    }
}