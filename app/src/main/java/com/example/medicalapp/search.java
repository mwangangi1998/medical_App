package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivitySearchBinding;

public class search extends base_userActivity {
ActivitySearchBinding activitySearchBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySearchBinding=ActivitySearchBinding.inflate(getLayoutInflater());

        allocatedActivityTitle("Search ");
        setContentView(activitySearchBinding.getRoot());
    }
}