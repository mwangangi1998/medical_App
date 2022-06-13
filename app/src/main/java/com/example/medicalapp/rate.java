package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivityRateBinding;

public class rate extends base_userActivity {
ActivityRateBinding activityRateBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRateBinding=ActivityRateBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Rate us");
        setContentView(activityRateBinding.getRoot());
    }
}