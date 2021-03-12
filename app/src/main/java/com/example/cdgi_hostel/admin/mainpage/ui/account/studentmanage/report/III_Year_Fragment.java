package com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cdgi_hostel.R;

public class III_Year_Fragment extends Fragment {

    View view;
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] data = {"Rama", "Ajay", "Gehna", "Atharv", "Hema", "Hina"};

    public III_Year_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_i_i_i__year_, container, false);
        listView = view.findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        return view;
    }
}