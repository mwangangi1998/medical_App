package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivityShareBinding;

public class share extends base_userActivity {
ActivityShareBinding activityShareBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityShareBinding=ActivityShareBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Share with ");
        setContentView(activityShareBinding.getRoot());
    }
}