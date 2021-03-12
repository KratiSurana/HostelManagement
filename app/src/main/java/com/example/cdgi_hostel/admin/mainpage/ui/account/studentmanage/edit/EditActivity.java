
package com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.edit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.enter.register.Register_Student;
import com.example.cdgi_hostel.admin.mainpage.AdminMainPageActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.status.StatusActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.ReportActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.report.ViewPagerAdapter;
import com.example.cdgi_hostel.admin.mainpage.ui.payment.PaidActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class EditActivity extends AppCompatActivity implements EditFragment.addStudentonClick {


    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        getSupportActionBar().setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //viewPagerAdapter
        viewPagerAdapter.AddFragment(new EditFragment(),"Add");
        viewPagerAdapter.AddFragment(new ViewFragment(),"View");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Add");
        tabLayout.getTabAt(1).setText("View");


        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationMethod);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationMethod =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    if(item.getItemId() == R.id.nav_status)
                    {
                        startActivity(new Intent(getApplicationContext(), StatusActivity.class));
                        return true;
                    }
                    else
                    if(item.getItemId() == R.id.nav_edit)
                    {
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

    @Override
    public void onButtonAddStudent() {
        startActivity(new Intent(EditActivity.this, Register_Student.class));
    }
}