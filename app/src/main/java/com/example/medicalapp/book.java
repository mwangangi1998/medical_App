package com.example.medicalapp;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.medicalapp.databinding.ActivityBookBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class book extends base_userActivity {
ActivityBookBinding activityBookBinding;
EditText edit;
DatePickerDialog.OnDateSetListener onDateSetListener;
Spinner spinner;
List<String> consultation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBookBinding = ActivityBookBinding.inflate(getLayoutInflater());
        allocatedActivityTitle("Book Appointment");
        setContentView(activityBookBinding.getRoot());
        edit = (EditText) findViewById(R.id.datepicker);
        spinner=(Spinner) findViewById(R.id.mylist);

     /*  list of consulatation*/
        consultation =new ArrayList<>();
        consultation.add("");
        consultation.add("Malaria");
        consultation.add("Maternal");
        consultation.add("Diabites");
        consultation.add("HIV ");
        consultation.add("surgical");
        consultation.add("Family planning");
        consultation.add("Emergency");
        consultation.add("Others");


        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                androidx.transition.R.layout.support_simple_spinner_dropdown_item,consultation);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(book.this, "you have selected:"+consultation.get(position), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


/*
                Toast.makeText(book.this, "you have selected:"+consultation.get(position), Toast.LENGTH_SHORT).show();
*/


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(book.this, onDateSetListener, year, month, day);

                datePickerDialog.show();

            }
        });
        onDateSetListener =new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                Date dt= new Date();
             ;

                 month=month+1;


                String date= dayofmonth+"/" +month + "/"+year;


          edit.setText(date);


            }
        };

    }


}