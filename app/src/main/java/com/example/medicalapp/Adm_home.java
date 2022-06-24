package com.example.medicalapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Adm_home extends AppCompatActivity {
TextView txthome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_home);
        txthome=(TextView) findViewById(R.id.home_name);

                txthome.setText("Dashboard");
    }
}