package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signin extends AppCompatActivity {
    EditText edit1,edit2;
    Button button1;
    TextView txtcreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        edit1=(EditText) findViewById(R.id.mail);
        edit2=(EditText) findViewById(R.id.passwd);
        button1=(Button) findViewById(R.id.logac);
        txtcreate=(TextView) findViewById(R.id.sign);
button1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        validatedetails();
    }
});

        //intent to signup
        txtcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencreateAc();

            }
        });
    }

    private void opencreateAc() {
        Intent opnsignup=new Intent(this,signup.class);
        startActivity(opnsignup);
    }

    private void validatedetails() {
        String email =edit1.getText().toString();
        String password =edit2.getText().toString();
        if (email.isEmpty()){
            Toast.makeText(this, "Fill all fields ", Toast.LENGTH_SHORT).show();
        }
        else if (password.isEmpty()||password.length()<6){
            Toast.makeText(this, "Password can't be less that 6 digits", Toast.LENGTH_SHORT).show();
        }
    }
}