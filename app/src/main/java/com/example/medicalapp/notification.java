package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivityNotificationBinding;

public class notification extends base_userActivity {
ActivityNotificationBinding activityNotificationBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNotificationBinding=ActivityNotificationBinding.inflate(getLayoutInflater());

        allocatedActivityTitle("Notifications");
        setContentView(activityNotificationBinding.getRoot());
    }
}