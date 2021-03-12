package com.example.cdgi_hostel.manager.mainpage.canteen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CanteenViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CanteenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Canteen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
