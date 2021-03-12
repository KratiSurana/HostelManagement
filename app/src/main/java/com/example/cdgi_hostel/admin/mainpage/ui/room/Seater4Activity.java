package com.example.cdgi_hostel.admin.mainpage.ui.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Seater4Activity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seater4);

        getSupportActionBar().setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //viewPagerAdapter
        viewPagerAdapter.AddFragment(new Seater4_Allocated_Fragment(),"Allotted Room");
        viewPagerAdapter.AddFragment(new Seater4_Available_Fragment(),"Available Room");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Allotted Room");
        tabLayout.getTabAt(1).setText("Available Room");


    }
}