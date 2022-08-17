package com.yousef.iugguide.ui.guide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yousef.iugguide.R;
import com.yousef.iugguide.databinding.ActivityRegistrationGuideBinding;
import com.yousef.iugguide.ui.guide.steps.CompleteRegistrationFormStep;
import com.yousef.iugguide.ui.guide.steps.GoToAdmissionAndRegistrationStep;
import com.yousef.iugguide.ui.guide.steps.GoToNewStudentsPlaceStep;
import com.yousef.iugguide.ui.guide.steps.GoToUniversityStep;
import com.yousef.iugguide.ui.guide.steps.PayApplicationFeeStep;
import com.yousef.iugguide.ui.guide.steps.PayTuitionFeesStep;
import com.yousef.iugguide.ui.guide.steps.RequiredPaperworkStep;

import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;

public class RegistrationGuide extends AppCompatActivity implements StepperFormListener {

    ActivityRegistrationGuideBinding binding;
    private VerticalStepperFormView stepper_form;


    private GoToUniversityStep goToUniversityStep;
    private GoToNewStudentsPlaceStep goToNewStudentsPlaceStep;
    private RequiredPaperworkStep requiredPaperworkStep;
    private PayApplicationFeeStep payApplicationFeeStep;
    private CompleteRegistrationFormStep completeRegistrationFormStep;
    private PayTuitionFeesStep payTuitionFeesStep;
    private GoToAdmissionAndRegistrationStep goToAdmissionAndRegistrationStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        stepper_form = findViewById(R.id.stepper_form);

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
                .lastStepNextButtonText("تم")
                .init();
    }

    @Override
    public void onCompletedForm() {
        super.onBackPressed();
    }

    @Override
    public void onCancelledForm() {
        super.onBackPressed();
    }

    @Override
    public void onStepAdded(int index, Step<?> addedStep) {

    }

    @Override
    public void onStepRemoved(int index) {

    }
}