package com.example.cdgi_hostel.manager.mainpage.extra;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExtraViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ExtraViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is extra fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
