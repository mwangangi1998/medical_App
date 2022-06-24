package com.example.medicalapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class appointment extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
textView=(TextView) findViewById(R.id.appoint_name) ;
        setContentView(R.layout.activity_appointment);
        textView.setText("Appointments ");
    }
}