package com.example.medicalapp;

import android.os.Bundle;

import com.example.medicalapp.databinding.ActivityHistoryBinding;

public class history extends base_userActivity {
ActivityHistoryBinding activityHistoryBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHistoryBinding=ActivityHistoryBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Records History");
        setContentView(activityHistoryBinding.getRoot());
    }
}