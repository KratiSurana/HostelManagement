package com.example.cdgi_hostel.admin.mainpage;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.cdgi_hostel.R;
import com.example.cdgi_hostel.admin.mainpage.ui.account.AccountFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.account.managermanage.ManagerManageActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.messmanage.MessManageActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.studentmanage.StudentManageActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.account.wardenmanage.WardenManageActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.pass.GatepassActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.pass.LeavepassActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.pass.PassFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.payment.PaidActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.payment.PaymentFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.payment.PendingActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.room.RoomFragment;
import com.example.cdgi_hostel.admin.mainpage.ui.room.RoomManagementActivity;
import com.example.cdgi_hostel.admin.mainpage.ui.room.Seater3_Activity;
import com.example.cdgi_hostel.admin.mainpage.ui.room.Seater4Activity;
import com.example.cdgi_hostel.admin.mainpage.ui.room.Seater5_Activity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AdminMainPageActivity extends AppCompatActivity implements AccountFragment.onActivityButtonSelected,
        RoomFragment.onActivitySeaterButtonSelected, PassFragment.onButtonPassSelected, PaymentFragment.onButtonPaySelected {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_page);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //noinspection deprecation
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_account, R.id.nav_room, R.id.nav_canteen, R.id.nav_pass,
                R.id.nav_emergency, R.id.nav_payment, R.id.nav_notice, R.id.nav_extra, R.id.nav_settings)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_main_page, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

            @Override
            public void onButtonStudentSelected() {
                startActivity(new Intent(AdminMainPageActivity.this, StudentManageActivity.class));
            }

            @Override
            public void onButtonManagerSelected() {
                startActivity(new Intent(AdminMainPageActivity.this, ManagerManageActivity.class));

            }

            @Override
            public void onButtonWardenSelected() {
                startActivity(new Intent(AdminMainPageActivity.this, WardenManageActivity.class));

            }

            @Override
            public void onButtonMessSelected() {
                startActivity(new Intent(AdminMainPageActivity.this, MessManageActivity.class));

            }

    @Override
    public void onButton3SeaterSelected() {
        startActivity(new Intent(AdminMainPageActivity.this, Seater3_Activity.class));
        }

    @Override
    public void onButton4SeaterSelected() {
        startActivity(new Intent(AdminMainPageActivity.this, Seater4Activity.class));
    }

    @Override
    public void onButton5SeaterSelected() {
        startActivity(new Intent(AdminMainPageActivity.this, Seater5_Activity.class));
    }

    @Override
    public void onButtonRoomManagementSelected() {
        startActivity(new Intent(AdminMainPageActivity.this, RoomManagementActivity.class));
    }

    @Override
    public void onButtonGatepassSelected() {
        startActivity(new Intent(AdminMainPageActivity.this, GatepassActivity.class));
    }

    @Override
    public void onButtonLeavepassSelected() {
        startActivity(new Intent(AdminMainPageActivity.this, LeavepassActivity.class));
    }

    @Override
    public void onButtonPaidSelected() {
        startActivity(new Intent(AdminMainPageActivity.this, PaidActivity.class));
    }

    @Override
    public void onButtonPendingSelected() {
        startActivity(new Intent(AdminMainPageActivity.this, PendingActivity.class));
    }
}