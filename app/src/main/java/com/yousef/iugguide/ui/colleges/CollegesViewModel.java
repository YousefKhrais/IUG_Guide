package com.yousef.iugguide.ui.colleges;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CollegesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CollegesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is colleges fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}