package com.example.cdgi_hostel.admin.enter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.AdminMainPageActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername =(EditText) findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.password);
        btnLogin = (Button)findViewById(R.id.btn_admin_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.equals("  ") || etPassword.equals(" "))
                {
                    Toast.makeText(LoginActivity.this, "Enter Username and Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (etUsername.equals("Admin") && etPassword.equals("Password"))
                    {
                        Toast.makeText(LoginActivity.this, "Succsessfully Login", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, AdminMainPageActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Wrong Login Credentials!Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}