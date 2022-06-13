package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivityBugBinding;

public class bug extends base_userActivity {
ActivityBugBinding activityBugBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBugBinding=ActivityBugBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Report a Bug");
        setContentView(activityBugBinding.getRoot());
    }
}