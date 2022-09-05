package com.yousef.iugguide.ui.buildings;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
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
import com.yousef.iugguide.databinding.InterntDialogBinding;
import com.yousef.iugguide.ui.home.InternetGuideBottomSheetDialog;

public class BuildingsFragment extends Fragment {

    private FragmentBuildingsBinding binding;
    private BuildingAdapter buildingAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBuildingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.collegeRv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        buildingAdapter = new BuildingAdapter(this.getContext(), AppClass.buildingArrayList);
        binding.collegeRv.setAdapter(buildingAdapter);

        if (!isNetworkConnected()) {
            InterntDialogBinding binding = InterntDialogBinding.inflate(getLayoutInflater());
            AlertDialog.Builder alBuilder = new AlertDialog.Builder(this.getContext());
            alBuilder.setTitle("alert");

            alBuilder.setView(binding.getRoot());
            final AlertDialog ad = alBuilder.show();
            binding.show.setOnClickListener(v -> {
                openInternetGuidePage();
            });
            binding.close.setOnClickListener(v -> {
                ad.dismiss();
            });

        }

        return root;
    }

    private void openInternetGuidePage() {
        InternetGuideBottomSheetDialog internetGuideBottomSheetDialog = new InternetGuideBottomSheetDialog();
        internetGuideBottomSheetDialog.setCancelable(true);
        internetGuideBottomSheetDialog.show(getChildFragmentManager(), "internetGuideBottomSheetDialog");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


}