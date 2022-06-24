package com.example.medicalapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.medicalapp.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends base_userActivity {
    private static final int SELECT_PICTURE =200 ;
    ActivityProfileBinding activityProfileBinding;
CircleImageView cimageV;
FirebaseAuth mAuth;
FirebaseFirestore fstore;
TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      activityProfileBinding=ActivityProfileBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Profile");
        setContentView(activityProfileBinding.getRoot());
        txt1=(TextView) findViewById(R.id.username_fet);
        txt2 =(TextView) findViewById(R.id.email_fetch);
        txt3=(TextView) findViewById(R.id.phone_no);
        mAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        cimageV=(CircleImageView)findViewById(R.id.imagecir) ;
        cimageV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });

        DocumentReference documentReference=fstore.collection("users").document(mAuth.getCurrentUser().getUid());
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                txt1.setText( value.getString("UserName"));
                txt2.setText( value.getString("Email"));
                txt3.setText( value.getString("Phone number"));
                // Log.d("TAG", "onEvent: "+value);


            }
        });


    }

    private void imageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }
    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    cimageV.setImageURI(selectedImageUri);
                }
            }
        }
    }
}