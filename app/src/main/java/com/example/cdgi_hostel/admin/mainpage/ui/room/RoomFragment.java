package com.example.cdgi_hostel.admin.mainpage.ui.room;

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
import com.example.cdgi_hostel.admin.mainpage.ui.account.AccountFragment;

public class RoomFragment extends Fragment implements View.OnClickListener {

    private onActivitySeaterButtonSelected seater_listener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //noinspection deprecation
        RoomViewModel roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);
            View root = inflater.inflate(R.layout.fragment_room, container, false);
            final TextView textView = root.findViewById(R.id.room);
            roomViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    textView.setText(s);
                }
            });

        ImageButton img_btn_3seater= root.findViewById(R.id.img_btn_3seater);
        ImageButton img_btn_4seater = root.findViewById(R.id.img_btn_4seater);
        ImageButton img_btn_5seater = root.findViewById(R.id.img_btn_5seater);
        ImageButton img_btn_roomManagement = root.findViewById(R.id.img_btn_roomManagement);

        img_btn_3seater.setOnClickListener(this);
        img_btn_4seater.setOnClickListener(this);
        img_btn_5seater.setOnClickListener(this);
        img_btn_roomManagement.setOnClickListener(this);

        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof RoomFragment.onActivitySeaterButtonSelected)
        {
            seater_listener = (RoomFragment.onActivitySeaterButtonSelected) context;
        } else
        {
            throw new ClassCastException(context.toString() + "Must implement listener");
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.img_btn_3seater) {
            seater_listener.onButton3SeaterSelected();
        } else if (v.getId() == R.id.img_btn_4seater) {
            seater_listener.onButton4SeaterSelected();
        } else if (v.getId() == R.id.img_btn_5seater) {
            seater_listener.onButton5SeaterSelected();
        }
        else if (v.getId() == R.id.img_btn_roomManagement) {
            seater_listener.onButtonRoomManagementSelected();
        }
    }

    public interface onActivitySeaterButtonSelected{
        void onButton3SeaterSelected();
        void onButton4SeaterSelected();
        void onButton5SeaterSelected();
        void onButtonRoomManagementSelected();

    }
}
