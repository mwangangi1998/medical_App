package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.createaccount);
        btn2=(Button) findViewById(R.id.login);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateAccount();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(getApplicationContext(),signin.class));
                //openloginActivity();
            }
        });
    }

//    private void openloginActivity() {
//        Intent openlogin=new Intent(this,signin.class);
//        startActivity(openlogin);
//        finish();
//
//    }

    private void openCreateAccount() {
        Intent opencreate=new Intent(this,signup.class);
        startActivity(opencreate);

    }
}