package com.example.cdgi_hostel.admin.mainpage.ui.pass;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.account.AccountFragment;


public class PassFragment extends Fragment implements View.OnClickListener {

    private PassViewModel passViewModel;
    private onButtonPassSelected pass_listener;
    @SuppressWarnings("deprecation")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        passViewModel =
                ViewModelProviders.of(this).get(PassViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pass, container, false);
        //final TextView textView = root.findViewById(R.id.tvPass);
        passViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
              //  textView.setText(s);
            }
        });

        ImageButton img_btn_gatePass = root.findViewById(R.id.img_btn_gatePass);
        ImageButton img_btn_leavePass = root.findViewById(R.id.img_btn_leavePass);
        img_btn_gatePass.setOnClickListener(this);
        img_btn_leavePass.setOnClickListener(this);

        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof PassFragment.onButtonPassSelected)
        {
            pass_listener = (PassFragment.onButtonPassSelected) context;
        } else
        {
            throw new ClassCastException(context.toString() + "Must implement listener");
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_gatePass )
        {
            pass_listener.onButtonGatepassSelected();
        } else if (v.getId() == R.id.img_btn_leavePass)
        {
            pass_listener.onButtonLeavepassSelected();
        }
    }
    public interface onButtonPassSelected{
        void onButtonGatepassSelected();
        void onButtonLeavepassSelected();
    }
}