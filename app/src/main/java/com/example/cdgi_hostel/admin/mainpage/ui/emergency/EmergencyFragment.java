package com.example.cdgi_hostel.admin.mainpage.ui.emergency;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.extra.ExtraViewModel;

public class EmergencyFragment extends Fragment {

    private EmergencyViewModel emergencyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        emergencyViewModel =
                ViewModelProviders.of(this).get(EmergencyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_emergency, container, false);
       // final TextView textView = root.findViewById(R.id.tvEmergency);
        emergencyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
          //      textView.setText(s);
            }
        });
        return root;
    }
}