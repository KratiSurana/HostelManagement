package com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cdgi_hostel.R;

public class I_Year_Detail_Fragment extends Fragment {

    View view;

    public I_Year_Detail_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_i__year__detail_, container, false);
        return  view;
    }
}