package com.yousef.iugguide.ui.colleges;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.adapters.CollegeAdapter;
import com.yousef.iugguide.databinding.FragmentCollegesBinding;

public class CollegesFragment extends Fragment {
CollegeAdapter collegeAdapter;

    private FragmentCollegesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCollegesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
      //  GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(),2,GridLayoutManager.VERTICAL,false);
        binding.collegeRv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        collegeAdapter = new CollegeAdapter(this.getContext(), AppClass.collegesArrayList);
        binding.collegeRv.setAdapter(collegeAdapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}