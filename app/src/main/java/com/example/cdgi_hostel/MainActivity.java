package com.example.cdgi_hostel;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.cdgi_hostel.admin.enter.AdminLoginActivity;
import com.example.cdgi_hostel.manager.enter.ManagerLoginActivity;
import com.example.cdgi_hostel.mess.MessLoginActivity;
import com.example.cdgi_hostel.student.LoginStudentActivity;
import com.example.cdgi_hostel.warden.LoginWardenActivity;


public class MainActivity extends AppCompatActivity {

    ImageButton img_btn_admin;
    ImageButton img_btn_manager;
    ImageButton img_btn_student;
    ImageButton img_btn_warden;
    ImageButton img_btn_mess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_btn_admin = (ImageButton) findViewById(R.id.img_btn_admin);
        img_btn_manager = (ImageButton)findViewById(R.id.img_btn_manager);
        img_btn_student = (ImageButton)findViewById(R.id.img_btn_student);
        img_btn_warden = (ImageButton)findViewById(R.id.img_btn_warden);
        img_btn_mess = (ImageButton)findViewById(R.id.img_btn_mess);

        img_btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, AdminLoginActivity.class);
                startActivity(intent);
            }
        });

        img_btn_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, ManagerLoginActivity.class);
                startActivity(intent);
            }
        });

        img_btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, LoginStudentActivity.class);
                startActivity(intent);
            }
        });

        img_btn_warden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, LoginWardenActivity.class);
                startActivity(intent);
            }
        });

        img_btn_mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, MessLoginActivity.class);
                startActivity(intent);
            }
        });


    }



}