package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText editText1,editText2,edit3,editText4;
    Button btn1;
    TextView txtview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editText1=(EditText) findViewById(R.id.username);
        editText2=(EditText) findViewById(R.id.mail);
        edit3=(EditText) findViewById(R.id.phone);
        editText4=(EditText) findViewById(R.id.passwd);
        btn1=(Button) findViewById(R.id.register);
        txtview1=(TextView) findViewById(R.id.already);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateDetails();
            }
        });
        txtview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmyloginActivity();
            }
        });
    }

    private void openmyloginActivity() {
        Intent newOpen=new Intent(this,signin.class);
        startActivity(newOpen);
    }

    private void validateDetails() {
        String usrname = editText1.getText().toString();
        String email = editText2.getText().toString();
        String number = edit3.getText().toString();
        String password = editText4.getText().toString();

        if (usrname.isEmpty() || email.isEmpty() || number.isEmpty()) {
            Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show();
        } else if
        (password.isEmpty() || password.length() < 6) {
            Toast.makeText(this, "password can't be less that 6 digit", Toast.LENGTH_SHORT).show();
        }
    }
}