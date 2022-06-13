package com.example.medicalapp;

import android.os.Bundle;


import com.example.medicalapp.databinding.ActivityAdminDashboardBinding;
import com.example.medicalapp.databinding.ActivityDashboardBinding;


public class Dashboard extends base_userActivity {


ActivityDashboardBinding activityDashboardBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding=ActivityDashboardBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Dashboard");
        setContentView(activityDashboardBinding.getRoot());

    }




}