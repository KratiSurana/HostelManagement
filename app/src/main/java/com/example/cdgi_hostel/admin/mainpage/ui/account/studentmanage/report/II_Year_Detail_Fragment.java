package com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cdgi_hostel.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link II_Year_Detail_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class II_Year_Detail_Fragment extends Fragment {

    public II_Year_Detail_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_i_i__year__detail_, container, false);
    }
}