package com.example.cdgi_hostel.admin.mainpage.ui.account.messmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.account.managermanage.AddManagerFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.managermanage.ViewManagerFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.III_Year_Fragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.II_Year_Fragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.IV_Year_Fragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.I_Year_Fragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MessManageActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_manage);

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