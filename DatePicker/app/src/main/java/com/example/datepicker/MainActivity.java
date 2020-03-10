package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ListIterator;

public class MainActivity extends AppCompatActivity  {

    String[] st={"Kush","basya","Pm"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter ad=new ArrayAdapter(this,R.layout.lay,st);
        ListView l=findViewById(R.id.ls);
        final DatePicker dp=findViewById(R.id.datePicker);
        l.setAdapter(ad);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String date=dp.getDayOfMonth()+"/"+dp.getMonth()+"/"+dp.getYear();
                Toast.makeText(getApplicationContext(),st[position]+"joined on"+date,Toast.LENGTH_SHORT).show();
            }
        });




    }
}
