package com.example.cdgi_hostel.admin.mainpage.ui.account;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.account.AccountViewModel;

import static com.example.cdgi_hostel.R.id.img_btn_messaccount;

public class AccountFragment extends Fragment implements View.OnClickListener {

    private onActivityButtonSelected listener;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        //noinspection deprecation
        AccountViewModel accountViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_account, container, false);
        final TextView textView = root.findViewById(R.id.tvAccount);
        accountViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }


        });
        ImageButton img_btn_studentaccount = root.findViewById(R.id.img_btn_studentaccount);
        ImageButton img_btn_manageraccount = root.findViewById(R.id.img_btn_manageraccount);
        ImageButton img_btn_wardenaccount = root.findViewById(R.id.img_btn_wardenaccount);
        ImageButton img_btn_messaccount = root.findViewById(R.id.img_btn_messaccount);
        img_btn_studentaccount.setOnClickListener(this);
        img_btn_manageraccount.setOnClickListener(this);
        img_btn_wardenaccount.setOnClickListener(this);
        img_btn_messaccount.setOnClickListener(this);

        return root;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof onActivityButtonSelected)
        {
            listener = (onActivityButtonSelected) context;
        } else
        {
            throw new ClassCastException(context.toString() + "Must implement listener");
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.img_btn_studentaccount) {
            listener.onButtonStudentSelected();
        } else if (v.getId() == R.id.img_btn_manageraccount) {
            listener.onButtonManagerSelected();
        } else if (v.getId() == R.id.img_btn_wardenaccount) {
            listener.onButtonWardenSelected();
        }
        else if(v.getId() == img_btn_messaccount) {
            listener.onButtonMessSelected();
        }
    }
    public interface onActivityButtonSelected{
        void onButtonStudentSelected();
         void onButtonManagerSelected();
         void onButtonWardenSelected();
        void onButtonMessSelected();
   }
}