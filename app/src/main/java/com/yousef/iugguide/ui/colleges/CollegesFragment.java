package com.yousef.iugguide.ui.colleges;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.yousef.iugguide.databinding.FragmentCollegesBinding;

public class CollegesFragment extends Fragment {

    private FragmentCollegesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCollegesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ImageView imageView = binding.titleView;
        Resources resources = getActivity().getResources();
        final int resourceId = resources.getIdentifier("mid_img", "drawable", getActivity().getPackageName());

        imageView.setImageDrawable(resources.getDrawable(resourceId));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}