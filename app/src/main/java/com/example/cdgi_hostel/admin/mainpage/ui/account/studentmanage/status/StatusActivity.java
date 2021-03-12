package com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.status;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.edit.EditActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.edit.EditFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.edit.ViewFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.ReportActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class StatusActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);


        getSupportActionBar().setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //viewPagerAdapter
        viewPagerAdapter.AddFragment(new LivingFragment(),"Living Students");
        viewPagerAdapter.AddFragment(new LeavedFragment(),"Leaved Students");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Living Students");
        tabLayout.getTabAt(1).setText("Leaved Students");

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationMethod);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationMethod =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    if(item.getItemId() == R.id.nav_status)
                    {
                        //startActivity(new Intent(getApplicationContext(),StatusActivity.class));
                        return true;
                    }
                    else
                    if(item.getItemId() == R.id.nav_edit)
                    {
                        startActivity(new Intent(getApplicationContext(), EditActivity.class));
                        return true;
                    }
                    else
                    if(item.getItemId() == R.id.nav_report)
                    {
                        startActivity(new Intent(getApplicationContext(), ReportActivity.class));
                        return true;
                    }


                    return false;
                }
            };
}