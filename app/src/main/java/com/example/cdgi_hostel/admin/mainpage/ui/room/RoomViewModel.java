package com.example.cdgi_hostel.admin.mainpage.ui.room;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RoomViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RoomViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Room Management");
    }

    public LiveData<String> getText() {
        return mText;
    }

}

