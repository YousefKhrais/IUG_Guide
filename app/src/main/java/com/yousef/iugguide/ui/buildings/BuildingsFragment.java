package com.yousef.iugguide.ui.buildings;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.yousef.iugguide.R;
import com.yousef.iugguide.databinding.FragmentBuildingsBinding;

import java.util.ArrayList;

public class BuildingsFragment extends Fragment {

    private ImageSlider imageSlider;
    int[] images = {R.drawable.art_img,
            R.drawable.it_img,
            R.drawable.nurce_img,
            R.drawable.mid_img,
            R.drawable.shareaa_law_img,
            R.drawable.osool_aldeen_img};
    private FragmentBuildingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBuildingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        imageSlider = binding.imageslider;
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        Uri imageURI= Uri.parse("android.resource://com.yousef.iugguide/" + R.drawable.it_img);
        Uri imageURI1= Uri.parse("android.resource://com.yousef.iugguide/" + R.drawable.mid_img);
        Uri imageURI2= Uri.parse("android.resource://com.yousef.iugguide/" + R.drawable.shareaa_law_img);
        Uri imageURI3= Uri.parse("android.resource://com.yousef.iugguide/" + R.drawable.tarbeaa_img);
        Uri imageURI4= Uri.parse("android.resource://com.yousef.iugguide/" + R.drawable.osool_aldeen_img);
        slideModels.add(new SlideModel(imageURI.toString(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageURI1.toString(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageURI2.toString(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageURI3.toString(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageURI4.toString(), ScaleTypes.FIT));
        Log.e("TAG", imageURI4.toString() );
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}