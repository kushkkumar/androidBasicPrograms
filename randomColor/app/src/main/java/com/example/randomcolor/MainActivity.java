package com.example.randomcolor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=findViewById(R.id.bt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r=new Random();
                ConstraintLayout b=findViewById(R.id.back);
              //  int c=Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256));
               // b.setBackgroundColor(c);;
                b.setBackgroundColor(Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256)));

              //  Toast.makeText(getApplicationContext(),"The color is  "+String.valueOf(c),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
