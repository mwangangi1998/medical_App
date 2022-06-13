package com.example.medicalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class base_userActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    FirebaseAuth mAuth;

    @Override
    public void setContentView(View view) {
        drawerLayout=(DrawerLayout)getLayoutInflater().inflate(R.layout.activity_base_user,null);

        FrameLayout container =drawerLayout.findViewById(R.id.navHostFragment);
        container.addView(view);
        super.setContentView(drawerLayout);
        Toolbar toolbar=drawerLayout.findViewById(R.id.LayoutToolBar);
        setSupportActionBar(toolbar);

        NavigationView navigationView=drawerLayout.findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
   drawerLayout.addDrawerListener(toggle);
   toggle.syncState();
   mAuth =FirebaseAuth.getInstance();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    drawerLayout.closeDrawer(GravityCompat.START);
    switch (item.getItemId()){
        case R.id.profile:
            startActivity(new Intent(this,profile.class));
            overridePendingTransition(0,0);
    break;
        case R.id.notification:
            startActivity(new Intent(this,notification.class));
            overridePendingTransition(0,0);
            break;
        case R.id.search:
            startActivity(new Intent(this,search.class));
            overridePendingTransition(0,0);
            break;
        case R.id.about:
            startActivity(new Intent(this,about.class));
            overridePendingTransition(0,0);
            break;
        case R.id.bug:
            startActivity(new Intent(this,bug.class));
            overridePendingTransition(0,0);
            break;
        case R.id.rate:
            startActivity(new Intent(this,rate.class));
            overridePendingTransition(0,0);
            break;
        case R.id.help:
            startActivity(new Intent(this,help.class));
            overridePendingTransition(0,0);
            break;
        case R.id.share:
            startActivity(new Intent(this,share.class));
            overridePendingTransition(0,0);
            break;
        case R.id.logout:
            mAuth.signOut();
             startActivity(new Intent(this,signin.class));
             finish();
            overridePendingTransition(0,0);
            break;
    }

        return false;
    }
    protected void allocatedActivityTitle(String titleString)
    {
        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setTitle(titleString);
        }
    }
}