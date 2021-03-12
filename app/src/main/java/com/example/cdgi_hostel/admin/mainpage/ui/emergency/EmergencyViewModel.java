package com.example.cdgi_hostel.admin.mainpage.ui.emergency;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EmergencyViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public EmergencyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is emergency fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
