package com.example.medicalapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.medicalapp.databinding.ActivityHelpBinding;

public class help extends base_userActivity {
    ActivityHelpBinding activityHelpBinding;
Button btn1;
    Intent intent=null,choose= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHelpBinding =ActivityHelpBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Help center");
        setContentView(activityHelpBinding.getRoot());
        btn1=(Button) findViewById(R.id.sent);


btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        intent =new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to ={"mwangangimusyoka1998@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT,"First Email");
        intent.putExtra(Intent.EXTRA_TEXT,"Hey, help have issue with your Application on booking for Appointment");
        intent.setType("message/rfc822");
        choose=Intent.createChooser(intent,"Send Email");
        startActivity(choose);
    }
});

    }


}