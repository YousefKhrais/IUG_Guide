package com.yousef.iugguide.ui.buildings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.adapters.BuildingAdapter;
import com.yousef.iugguide.databinding.FragmentBuildingsBinding;

public class BuildingsFragment extends Fragment {

    private FragmentBuildingsBinding binding;
    private BuildingAdapter buildingAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBuildingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.collegeRv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        buildingAdapter = new BuildingAdapter(this.getContext(), AppClass.buildingArrayList);
        binding.collegeRv.setAdapter(buildingAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}