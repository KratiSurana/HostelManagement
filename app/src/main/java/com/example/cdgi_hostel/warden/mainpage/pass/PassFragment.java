package com.example.cdgi_hostel.warden.mainpage.pass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.cdgi_hostel.R;

public class PassFragment extends Fragment {

    private PassViewModel passViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        passViewModel =
                ViewModelProviders.of(this).get(PassViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pass, container, false);
      ///  final TextView textView = root.findViewById(R.id.tvPass);
        passViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
              //  textView.setText(s);
            }
        });
        return root;
    }
}