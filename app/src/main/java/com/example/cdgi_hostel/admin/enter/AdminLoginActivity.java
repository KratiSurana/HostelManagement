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

public class AdminLoginActivity extends AppCompatActivity {

    EditText etUsername,etPassword;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        etUsername =(EditText) findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btn_admin_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
    public void login()
    {
        String Username = etUsername.getText().toString();
        String Password = etPassword.getText().toString();

        if(Username.isEmpty() || Password.isEmpty())
            Toast.makeText(AdminLoginActivity.this, "Enter Username and Password", Toast.LENGTH_SHORT).show();
        else
        {
            if (Username.equals("Admin") && Password.equals("Password"))
            {
                Toast.makeText(AdminLoginActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminLoginActivity.this, AdminMainPageActivity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(AdminLoginActivity.this, "Wrong Login Credentials!Try Again", Toast.LENGTH_SHORT).show();
            }
        }
    }
}