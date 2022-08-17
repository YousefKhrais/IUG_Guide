package com.yousef.iugguide.ui.guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.yousef.iugguide.databinding.FragmentGuideBinding;


public class GuideFragment extends Fragment {

    private FragmentGuideBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGuideBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button registrationGuideButton = binding.registrationGuideButton;
        final Button acceptanceKeyButton = binding.acceptanceKeyButton;
        final Button moodleButton = binding.moodleButton;
        final Button universityWebsiteButton = binding.universityWebsiteButton;
        final Button admissionApplicationButton = binding.admissionApplicationButton;

        registrationGuideButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), RegistrationGuide.class);
            getActivity().startActivity(intent);
        });

        acceptanceKeyButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AcceptanceKeys.class);
            getActivity().startActivity(intent);
        });

        moodleButton.setOnClickListener(v -> {
            String url = "https://moodle.iugaza.edu.ps";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

        universityWebsiteButton.setOnClickListener(v -> {
            String url = "http://iugaza.edu.ps";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

        admissionApplicationButton.setOnClickListener(v -> {
            String url = "https://eportal.iugaza.edu.ps/ords/f?p=142:LOGIN:12002841936534:::::";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}