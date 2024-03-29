package com.example.cdgi_hostel.warden.mainpage.extra;

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

public class ExtraFragment extends Fragment {

    private ExtraViewModel extraViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        extraViewModel =
                ViewModelProviders.of(this).get(ExtraViewModel.class);
        View root = inflater.inflate(R.layout.fragment_extra, container, false);
        final TextView textView = root.findViewById(R.id.tvExtra);
        extraViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}