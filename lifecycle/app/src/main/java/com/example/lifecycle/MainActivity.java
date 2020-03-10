package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.i("life cyle","start");
        Toast.makeText(getApplicationContext(),"Started",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.i("On stop","stoped");
        Toast.makeText(getApplicationContext(),"Pause",Toast.LENGTH_SHORT).show();


    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("On stop","stoped");
        Toast.makeText(getApplicationContext(),"Destroy",Toast.LENGTH_SHORT).show();


    }
    @Override
    public void onStop(){
        super.onStop();
        Log.i("On stop","stoped");
        Toast.makeText(getApplicationContext(),"stopped",Toast.LENGTH_SHORT).show();


    }
    @Override
    public void onResume(){
        super.onResume();
        Log.i("On stop","stoped");
        Toast.makeText(getApplicationContext(),"Resume",Toast.LENGTH_SHORT).show();


    }




}
