package com.example.medicalapp;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivityDoctorsBinding;

public class doctors extends base_userActivity {
    ActivityDoctorsBinding activityDoctorsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDoctorsBinding=ActivityDoctorsBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Doctors");
        setContentView(activityDoctorsBinding.getRoot());
    }
}