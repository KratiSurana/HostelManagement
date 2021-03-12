package com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.edit.EditActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.status.StatusActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class ReportActivity extends AppCompatActivity  {

    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    FragmentManager fragmentManager;
    int fragmentTransaction;


    I_Year_Detail_Fragment i_year_detail_fragment = new I_Year_Detail_Fragment();
    I_Year_Fragment i_year_fragment = new I_Year_Fragment();


    II_Year_Detail_Fragment ii_year_detail_fragment = new II_Year_Detail_Fragment();
    II_Year_Fragment ii_year_fragment = new II_Year_Fragment();

    III_Year_Fragment iii_year_fragment = new III_Year_Fragment();

    IV_Year_Fragment iv_year_fragment = new IV_Year_Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        getSupportActionBar().setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //viewPagerAdapter
        viewPagerAdapter.AddFragment(new I_Year_Fragment(),"I Year");
        viewPagerAdapter.AddFragment(new II_Year_Fragment(),"II Year");
        viewPagerAdapter.AddFragment(new III_Year_Fragment(),"III Year");
        viewPagerAdapter.AddFragment(new IV_Year_Fragment(),"IV Year");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("I Year");
        tabLayout.getTabAt(1).setText("II Year");
        tabLayout.getTabAt(2).setText("III Year");
        tabLayout.getTabAt(3).setText("IV Year");



        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationMethod);

    }


    private final BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationMethod =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    if(item.getItemId() == R.id.nav_report)
                    {
                        //startActivity(new Intent(getApplicationContext(),ReportActivity.class));
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

