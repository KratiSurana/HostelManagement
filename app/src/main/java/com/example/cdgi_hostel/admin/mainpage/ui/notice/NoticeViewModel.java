package com.example.cdgi_hostel.admin.mainpage.ui.notice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NoticeViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public NoticeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notice fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
