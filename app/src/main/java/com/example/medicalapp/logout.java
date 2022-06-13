package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivityLogoutBinding;

public class logout extends base_userActivity {
ActivityLogoutBinding activityLogoutBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLogoutBinding=ActivityLogoutBinding.inflate(getLayoutInflater());
       // allocatedActivityTitle("");
        setContentView(activityLogoutBinding.getRoot());
    }
}