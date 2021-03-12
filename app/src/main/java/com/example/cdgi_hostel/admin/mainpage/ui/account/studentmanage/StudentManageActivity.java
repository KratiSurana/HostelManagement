package com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.edit.EditActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.ReportActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.status.StatusActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StudentManageActivity extends AppCompatActivity {
   BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_manage);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationMethod);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationMethod =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if(item.getItemId() == R.id.nav_report)
            {
                startActivity(new Intent(getApplicationContext(), ReportActivity.class));
                return true;
            }
            else
            if(item.getItemId() == R.id.nav_edit)
            {
                startActivity(new Intent(getApplicationContext(), EditActivity.class));
                return true;
            }
            else
            if(item.getItemId() == R.id.nav_status)
            {
                startActivity(new Intent(getApplicationContext(), StatusActivity.class));
                return true;
            }


            return false;
        }
    };

    }

