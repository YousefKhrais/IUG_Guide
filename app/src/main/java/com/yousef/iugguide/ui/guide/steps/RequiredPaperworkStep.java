package com.yousef.iugguide.ui.guide.steps;

import android.view.LayoutInflater;
import android.view.View;

import com.yousef.iugguide.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class RequiredPaperworkStep extends Step<String> {


    private View stepContent;

    public RequiredPaperworkStep(String stepTitle) {
        super(stepTitle);
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        stepContent = inflater.inflate(R.layout.step_3_required_paperwork_layout, null, false);

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