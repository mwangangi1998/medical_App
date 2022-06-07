package com.example.medicalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
    EditText editText1,editText2,edit3,editText4;
    Button btn1;
    TextView txtview1;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;
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

        mAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

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
        else{
            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            FirebaseUser user=mAuth.getCurrentUser();
                            Toast.makeText(signup.this, "Account created successful", Toast.LENGTH_SHORT).show();
                            DocumentReference df= fstore.collection("users").document(user.getUid());
                            Map<String,Object> userinfo=new HashMap<>();
                            userinfo.put("UserName",usrname);
                            userinfo.put("Email",email);
                            userinfo.put("Phone number",number);
                           // userinfo.put("password",password);
//specify access level
                            userinfo.put("isUser","1");
                           df.set(userinfo);

                            startActivity(new Intent(getApplicationContext(),signin.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(signup.this, "Failed to create Account", Toast.LENGTH_SHORT).show();
                        }
                    });

        }
    }
}