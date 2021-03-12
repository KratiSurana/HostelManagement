package com.example.cdgi_hostel.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.enter.register.Register_Student;

public class LoginStudentActivity extends AppCompatActivity {

    Button btn_student_login;
    Button btn_student_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_student);

        btn_student_login = findViewById(R.id.btn_student_login);
        btn_student_register = findViewById(R.id.btn_student_register);

        btn_student_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginStudentActivity.this, Register_Student.class);
                startActivity(intent);
            }
        });

    }
}