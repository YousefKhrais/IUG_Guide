package com.yousef.iugguide.ui.colleges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.adapters.CollegeAdapter;
import com.yousef.iugguide.databinding.FragmentCollegesBinding;

public class CollegesFragment extends Fragment {

    private FragmentCollegesBinding binding;
    private CollegeAdapter collegeAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCollegesBinding.inflate(inflater, container, false);

        binding.collegeRv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        collegeAdapter = new CollegeAdapter(this.getContext(), AppClass.collegesArrayList);
        binding.collegeRv.setAdapter(collegeAdapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}