package com.example.cdgi_hostel.admin.mainpage.ui.payment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.account.AccountFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.pass.PassFragment;

import static com.example.cdgi_hostel.R.id.img_btn_messaccount;


public class PaymentFragment extends Fragment implements View.OnClickListener {

    private PaymentViewModel paymentViewModel;
    private onButtonPaySelected pay_listener;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        paymentViewModel =
                ViewModelProviders.of(this).get(PaymentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_payment, container, false);
        // final TextView textView = root.findViewById(R.id.tvPayment);
        paymentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //    textView.setText(s);
            }
        });
        ImageButton img_btn_paid = root.findViewById(R.id.img_btn_paid);
        ImageButton img_btn_pending = root.findViewById(R.id.img_btn_pending);
        img_btn_paid.setOnClickListener(this);
        img_btn_pending.setOnClickListener(this);


        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof PaymentFragment.onButtonPaySelected)
        {
            pay_listener = (PaymentFragment.onButtonPaySelected) context;
        } else
        {
            throw new ClassCastException(context.toString() + "Must implement listener");
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.img_btn_paid) {
            pay_listener.onButtonPaidSelected();
        } else if (v.getId() == R.id.img_btn_pending) {
            pay_listener.onButtonPendingSelected();
        }
    }
    public interface onButtonPaySelected{
        void onButtonPaidSelected();
        void onButtonPendingSelected();
    }
}