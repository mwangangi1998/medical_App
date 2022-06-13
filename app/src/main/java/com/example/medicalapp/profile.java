package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivityDashboardBinding;
import com.example.medicalapp.databinding.ActivityProfileBinding;

public class profile extends base_userActivity {
ActivityProfileBinding activityProfileBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      activityProfileBinding=ActivityProfileBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Profile");
        setContentView(activityProfileBinding.getRoot());
    }
}