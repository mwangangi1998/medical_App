package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivityHelpBinding;

public class help extends base_userActivity {
    ActivityHelpBinding activityHelpBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHelpBinding =ActivityHelpBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Help center");
        setContentView(activityHelpBinding.getRoot());
    }
}