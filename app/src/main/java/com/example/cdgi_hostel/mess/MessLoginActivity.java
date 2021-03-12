package com.example.cdgi_hostel.mess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.enter.register.Register_Mess;
import com.example.cdgi_hostel.admin.mainpage.AdminMainPageActivity;
import com.example.cdgi_hostel.mess.mainpage.MessMainPageActivity;

public class MessLoginActivity extends AppCompatActivity {

    Button btn_mess_login;
    Button btn_mess_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mess);

        btn_mess_login = findViewById(R.id.btn_mess_login);
        btn_mess_register= findViewById(R.id.btn_mess_register);

        btn_mess_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessLoginActivity.this, MessMainPageActivity.class);
                startActivity(intent);
            }
        });

        btn_mess_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessLoginActivity.this, Register_Mess.class);
                startActivity(intent);
            }
        });


    }
}