package com.yousef.iugguide.ui.home;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.yousef.iugguide.R;
import com.yousef.iugguide.ui.home.steps.registration.CompleteRegistrationFormStep;
import com.yousef.iugguide.ui.home.steps.registration.GoToAdmissionAndRegistrationStep;
import com.yousef.iugguide.ui.home.steps.registration.GoToNewStudentsPlaceStep;
import com.yousef.iugguide.ui.home.steps.registration.GoToUniversityStep;
import com.yousef.iugguide.ui.home.steps.registration.PayApplicationFeeStep;
import com.yousef.iugguide.ui.home.steps.registration.PayTuitionFeesStep;
import com.yousef.iugguide.ui.home.steps.registration.RequiredPaperworkStep;

import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;

public class RegistrationGuideBottomSheetDialog extends BottomSheetDialogFragment implements StepperFormListener {

    private VerticalStepperFormView stepper_form;
    private GoToUniversityStep goToUniversityStep;
    private GoToNewStudentsPlaceStep goToNewStudentsPlaceStep;
    private RequiredPaperworkStep requiredPaperworkStep;
    private PayApplicationFeeStep payApplicationFeeStep;
    private CompleteRegistrationFormStep completeRegistrationFormStep;
    private PayTuitionFeesStep payTuitionFeesStep;
    private GoToAdmissionAndRegistrationStep goToAdmissionAndRegistrationStep;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bottomsheet_registration_guide, container, false);

        stepper_form = rootView.findViewById(R.id.stepper_form);

        goToUniversityStep = new GoToUniversityStep("التوجه إلى الجامعة الإسلامية");
        goToNewStudentsPlaceStep = new GoToNewStudentsPlaceStep("الذهاب الى مكان استقبال الطلبة الجدد");
        requiredPaperworkStep = new RequiredPaperworkStep("الوثائق المطلوبة");
        payApplicationFeeStep = new PayApplicationFeeStep("دفع رسوم طلب الالتحاق");
        completeRegistrationFormStep = new CompleteRegistrationFormStep("تعبئة طلب الالتحاق");
        payTuitionFeesStep = new PayTuitionFeesStep("دفع الرسوم الدراسية");
        goToAdmissionAndRegistrationStep = new GoToAdmissionAndRegistrationStep("الحصول على الجدول الدراسي");

        stepper_form
                .setup(this,
                        goToUniversityStep,
                        goToNewStudentsPlaceStep,
                        requiredPaperworkStep,
                        payApplicationFeeStep,
                        completeRegistrationFormStep,
                        payTuitionFeesStep,
                        goToAdmissionAndRegistrationStep
                )
                .includeConfirmationStep(false)
                .stepNextButtonText("التالي")
                .displayBottomNavigation(false)
                .lastStepNextButtonText("تم")
                .init();

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

    @Override
    public void onCompletedForm() {
        this.dismiss();
    }

    @Override
    public void onCancelledForm() {
        this.dismiss();
    }

    @Override
    public void onStepAdded(int index, Step<?> addedStep) {}

    @Override
    public void onStepRemoved(int index) {}
}