package com.yousef.iugguide.ui.buildings;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.yousef.iugguide.R;
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
        Uri imageURI= Uri.parse("android.resource://com.yousef.iugguide/" + R.drawable.mid_img);
        Uri imageURI1= Uri.parse("android.resource://com.yousef.iugguide/" + R.drawable.mid_img);
        Uri imageURI2= Uri.parse("android.resource://com.yousef.iugguide/" + R.drawable.art_img);
        Uri imageURI3= Uri.parse("android.resource://com.yousef.iugguide/" + R.drawable.tarbeea_img);
        Uri imageURI4= Uri.parse("android.resource://com.yousef.iugguide/" + R.drawable.osool_bg);
        slideModels.add(new SlideModel(imageURI.toString(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageURI1.toString(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageURI2.toString(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageURI3.toString(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageURI4.toString(), ScaleTypes.FIT));
        Log.e("TAG", imageURI4.toString() );
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
    }
}