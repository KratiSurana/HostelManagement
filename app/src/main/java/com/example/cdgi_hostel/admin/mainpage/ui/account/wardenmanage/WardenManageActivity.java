package com.example.cdgi_hostel.admin.mainpage.ui.account.wardenmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.account.managermanage.AddManagerFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.managermanage.ViewManagerFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class WardenManageActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden_manage);

        getSupportActionBar().setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //viewPagerAdapter
        viewPagerAdapter.AddFragment(new AddManagerFragment(),"Add");
        viewPagerAdapter.AddFragment(new ViewManagerFragment(),"View");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Add");
        tabLayout.getTabAt(1).setText("View");


    }
}