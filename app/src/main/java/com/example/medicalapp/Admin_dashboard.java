package com.example.medicalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Admin_dashboard extends AppCompatActivity {
FirebaseAuth mAuth;
FirebaseFirestore fstore;
TextView tx1,txt2,txt3,txt4,txt5,txt6,text_adm;

    ImageButton imgBtn1,imgBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        tx1=(TextView) findViewById(R.id.textView1);
        txt2=(TextView) findViewById(R.id.textView20);
        txt3=(TextView) findViewById(R.id.textView21);
        txt4=(TextView) findViewById(R.id.textView22);
        txt5=(TextView) findViewById(R.id.textView23) ;
        txt6=(TextView) findViewById(R.id.textView4);
        text_adm=(TextView) findViewById(R.id.Adm_name);

        imgBtn1=(ImageButton) findViewById(R.id.logOutB);

        imgBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(),signin.class));
                finish();
            }
        });
tx1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(),Adm_home.class));

    }
});


txt2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(),adm_profile.class));

    }
});
txt3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(),Adm_notification.class));
    }
});
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Adm_notification.class));
            }
        });

        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),appointment.class));
            }
        });


        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),setting.class));
            }
        });
        mAuth=FirebaseAuth.getInstance();
fstore=FirebaseFirestore.getInstance();
        DocumentReference documentReference=fstore.collection("users").document(mAuth.getCurrentUser().getUid());
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                text_adm.setText( value.getString("UserName"));
             /*   txt2.setText( value.getString("Email"));
                txt3.setText( value.getString("Phone number"));
                // Log.d("TAG", "onEvent: "+value);*/


            }
        });


    }
}