package com.example.medicalapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class adm_profile extends AppCompatActivity {
TextView textp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_profile);
        textp=(TextView) findViewById(R.id.profile_title);
        textp.setText("Profile");
    }
}