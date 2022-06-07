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


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;



public class signin extends AppCompatActivity {
    EditText edit1,edit2;
    Button button1;
    TextView txtcreate;
private FirebaseAuth mAuth;
private FirebaseFirestore fstore;
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

mAuth=FirebaseAuth.getInstance();
fstore=FirebaseFirestore.getInstance();
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
        else{
mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
    @Override
    public void onSuccess(AuthResult authResult) {
        Toast.makeText(signin.this, "Logged in successful", Toast.LENGTH_SHORT).show();
    checkLevel(authResult.getUser().getUid());

    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {

    }
});
        }

    }

    private void checkLevel(String uid) {
        DocumentReference df= fstore.collection("Users").document(uid);
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),Dashboard.class));
            finish();
        }
    }
}