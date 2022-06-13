package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivityAboutBinding;

public class about extends base_userActivity {
ActivityAboutBinding activityAboutBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAboutBinding=ActivityAboutBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("About us");
        setContentView(activityAboutBinding.getRoot());
    }
}