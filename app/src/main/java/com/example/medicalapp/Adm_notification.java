package com.example.medicalapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Adm_notification extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
textView=(TextView) findViewById(R.id.notif);
setContentView(R.layout.activity_adm_notification);
textView.setText("Notification");
    }
}