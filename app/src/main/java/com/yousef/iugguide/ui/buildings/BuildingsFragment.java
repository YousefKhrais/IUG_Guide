package com.yousef.iugguide.ui.buildings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.MainActivity;
import com.yousef.iugguide.R;
import com.yousef.iugguide.adapters.BuildingAdapter;
import com.yousef.iugguide.databinding.FragmentBuildingsBinding;
import com.yousef.iugguide.databinding.InterntDialogBinding;
import com.yousef.iugguide.ui.home.HomeFragment;

public class BuildingsFragment extends Fragment {

    private FragmentBuildingsBinding binding;
    private BuildingAdapter buildingAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBuildingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.collegeRv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        buildingAdapter = new BuildingAdapter(this.getContext(), AppClass.buildingArrayList);
        binding.collegeRv.setAdapter(buildingAdapter);
if (!isNetworkConnected()){
    InterntDialogBinding binding = InterntDialogBinding.inflate(getLayoutInflater());
    AlertDialog.Builder alBuilder = new AlertDialog.Builder(this.getContext());
    alBuilder.setTitle("انتباه");

    alBuilder.setView(binding.getRoot());
    final AlertDialog ad = alBuilder.show();
    binding.show.setOnClickListener(v->{
        startActivity(new Intent(this.getContext(), MainActivity.class));
    });
    binding.close.setOnClickListener(v->{
        ad.dismiss();
    });

}
        return root;
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