package com.example.medicalapp;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.medicalapp.databinding.ActivityDashboardBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


public class Dashboard extends base_userActivity {

TextView txt1,textView2;
public  String Username;
FirebaseAuth mAuth;
FirebaseFirestore fstore;
String UserId;
RelativeLayout relativeLayout;
ActivityDashboardBinding activityDashboardBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding=ActivityDashboardBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Dashboard");
        txt1=(TextView) findViewById(R.id.welcoming_note);

        //

      setContentView(activityDashboardBinding.getRoot());
        textView2=(TextView) findViewById(R.id.getusername);
        mAuth =FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        UserId =mAuth.getCurrentUser().getUid();


        DocumentReference documentReference=fstore.collection("users").document(mAuth.getCurrentUser().getUid());
       documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
           @Override
           public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
              textView2.setText( "Hi," + " "+value.getString("UserName"));
            // Log.d("TAG", "onEvent: "+value);


           }
       });
    }




}