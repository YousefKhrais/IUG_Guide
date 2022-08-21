package com.yousef.iugguide.ui.home.steps;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.yousef.iugguide.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class CompleteRegistrationFormStep extends Step<String> {

    private View stepContent;
    private Button admissionVideoButton;

    public CompleteRegistrationFormStep(String stepTitle) {
        super(stepTitle);
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        stepContent = inflater.inflate(R.layout.step_5_complete_registration_form_layout, null, false);

        admissionVideoButton = stepContent.findViewById(R.id.admissionVideoButton);
        admissionVideoButton.setOnClickListener(v -> {
            String url = "https://www.youtube.com/watch?v=KZBHwBP-Xv8&ab_channel=AdmissionIUG";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            stepContent.getContext().startActivity(i);
        });

        return stepContent;
    }

    @Override
    protected IsDataValid isStepDataValid(String stepData) {
        return new IsDataValid(true);
    }

    @Override
    public String getStepData() {
        return "";
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return "";
    }

    @Override
    protected void onStepOpened(boolean animated) {
        // This will be called automatically whenever the step gets opened.
    }

    @Override
    protected void onStepClosed(boolean animated) {
        // This will be called automatically whenever the step gets closed.
    }

    @Override
    protected void onStepMarkedAsCompleted(boolean animated) {
        // This will be called automatically whenever the step is marked as completed.
    }

    @Override
    protected void onStepMarkedAsUncompleted(boolean animated) {
        // This will be called automatically whenever the step is marked as uncompleted.
    }

    @Override
    protected void restoreStepData(String stepData) {
        // To restore the step after a configuration change, we restore the text of its EditText view.
    }
}