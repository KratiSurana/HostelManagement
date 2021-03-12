package com.example.cdgi_hostel.warden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.enter.register.Register_Warden;

public class LoginWardenActivity extends AppCompatActivity {

    Button btn_warden_login;
    Button btn_warden_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_warden);

        btn_warden_login =findViewById(R.id.btn_warden_login);
        btn_warden_register = findViewById(R.id.btn_warden_register);

        btn_warden_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginWardenActivity.this, Register_Warden.class);
                startActivity(intent);
            }
        });
    }
}
