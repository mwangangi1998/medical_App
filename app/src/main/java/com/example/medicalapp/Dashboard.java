package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout =(DrawerLayout) findViewById(R.id.drawerlayout_id);
        navigationView =(NavigationView) findViewById(R.id.navigation_view);
        imageView=(ImageView) findViewById(R.id.imageMenu);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.isDrawerOpen(GravityCompat.START);
            }
        });
    }
}