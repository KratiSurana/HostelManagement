package com.example.cdgi_hostel.warden.mainpage.pass;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PassViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public PassViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pass fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
