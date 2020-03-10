package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckBox p=findViewById(R.id.c1);
        final CheckBox b=findViewById(R.id.c2);
        final CheckBox t=findViewById(R.id.c3);
        final CheckBox c=findViewById(R.id.c4);
        Button bt=findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result="The item selected are:\n ";
                int total=0;
                if(p.isChecked()){
                    result+="Pizza\n150rs\n";
                    total+=150;
                }
                if(b.isChecked()){
                    result+="Burger\n90rs\n";
                    total+=90;
                }
                if(t.isChecked()){
                    result+="Tea \n50rs\n";
                    total+=50;
                }
                if(c.isChecked()){
                    result += "Coffee\n50rs\n";
                    total += 50;
                }

                Toast.makeText(getApplicationContext(),""+result+"Total is: "+total,Toast.LENGTH_LONG).show();

            }

        });

    }

}
