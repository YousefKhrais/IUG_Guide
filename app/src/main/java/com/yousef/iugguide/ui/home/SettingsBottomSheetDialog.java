package com.yousef.iugguide.ui.home;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;
import com.yousef.iugguide.R;
import com.yousef.iugguide.helpers.SharedPreferenceHelper;

public class SettingsBottomSheetDialog extends BottomSheetDialogFragment {

    private Button iconColorButton, backgroundColorButton, fontColorButton, resetSettingsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bottomsheet_app_settings, container, false);

        iconColorButton = rootView.findViewById(R.id.icon_color_button);
        backgroundColorButton = rootView.findViewById(R.id.background_color_button);
        fontColorButton = rootView.findViewById(R.id.font_color_button);
        resetSettingsButton = rootView.findViewById(R.id.reset_settings_button);

        iconColorButton.setOnClickListener(view -> new ColorPickerDialog.Builder(getContext())
                .setTitle("Icon Color")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton(getString(R.string.confirm),
                        (ColorEnvelopeListener) (envelope, fromUser) -> {
                            Toast.makeText(getContext(), envelope.getHexCode(), Toast.LENGTH_SHORT).show();
                            SharedPreferenceHelper.setIconsColor(getActivity(), envelope.getColor());
                        })
                .setNegativeButton(getString(R.string.cancel), (dialogInterface, i) -> dialogInterface.dismiss())
                .attachAlphaSlideBar(true)
                .attachBrightnessSlideBar(true)
                .setBottomSpace(12)
                .show());

        backgroundColorButton.setOnClickListener(view -> new ColorPickerDialog.Builder(getContext())
                .setTitle("Background Color")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton(getString(R.string.confirm),
                        (ColorEnvelopeListener) (envelope, fromUser) -> {
                            Toast.makeText(getContext(), envelope.getHexCode(), Toast.LENGTH_SHORT).show();
                            SharedPreferenceHelper.setBackgroundColor(getActivity(), envelope.getColor());
                        })
                .setNegativeButton(getString(R.string.cancel), (dialogInterface, i) -> dialogInterface.dismiss())
                .attachAlphaSlideBar(true)
                .attachBrightnessSlideBar(true)
                .setBottomSpace(12)
                .show());

        fontColorButton.setOnClickListener(view -> new ColorPickerDialog.Builder(getContext())
                .setTitle("Font Color")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton(getString(R.string.confirm),
                        (ColorEnvelopeListener) (envelope, fromUser) -> {
                            Toast.makeText(getContext(), envelope.getHexCode(), Toast.LENGTH_SHORT).show();
                            SharedPreferenceHelper.setFontColor(getActivity(), envelope.getColor());
                        })
                .setNegativeButton(getString(R.string.cancel), (dialogInterface, i) -> dialogInterface.dismiss())
                .attachAlphaSlideBar(true)
                .attachBrightnessSlideBar(true)
                .setBottomSpace(12)
                .show());

        resetSettingsButton.setOnClickListener(view -> {
            SharedPreferenceHelper.resetSharedPreferences(getActivity());
            Toast.makeText(getContext(), "يرجى اعادة تشغيل التطبيق", Toast.LENGTH_SHORT).show();
        });

        return rootView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setOnShowListener(dialogInterface -> {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
            setupFullHeight(bottomSheetDialog);
        });
        return dialog;
    }

    private void setupFullHeight(BottomSheetDialog bottomSheetDialog) {
        FrameLayout bottomSheet = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();

        int windowHeight = getWindowHeight();
        if (layoutParams != null)
            layoutParams.height = windowHeight;

        bottomSheet.setLayoutParams(layoutParams);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        behavior.setSkipCollapsed(true);
        behavior.setDraggable(false);
    }

    private int getWindowHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void openWebPageFromUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}