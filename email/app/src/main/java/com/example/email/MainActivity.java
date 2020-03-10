package com.example.email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.INTERNET},1);
        final EditText e1=findViewById(R.id.editText);
        final EditText e2=findViewById(R.id.editText2);
        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"+e1.getText().toString()));
                i.putExtra(Intent.EXTRA_SUBJECT,e2.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT,e2.getText().toString());
                startActivity(i);
            }
        });

    }
}
