package com.example.cdgi_hostel.warden.enter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.enter.register.Register_Manager;
import com.example.cdgi_hostel.manager.mainpage.ManagerMainPageActivity;

public class ManagerLoginActivity extends AppCompatActivity {

    Button btn_manager_login;
    Button btn_manager_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_manager);

        btn_manager_login = findViewById(R.id.btn_manager_login);
        btn_manager_register = findViewById(R.id.btn_manager_register);

        btn_manager_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerLoginActivity.this, ManagerMainPageActivity.class);
                startActivity(intent);
            }
        });

        btn_manager_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerLoginActivity.this, Register_Manager.class);
                startActivity(intent);
            }
        });
    }
}
