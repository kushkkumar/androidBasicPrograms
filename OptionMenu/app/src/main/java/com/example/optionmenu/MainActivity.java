package com.example.optionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.f1:
                Intent i=new Intent(this,Main2Activity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"This",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.f2:
                Toast.makeText(getApplicationContext(),"2nd",Toast.LENGTH_SHORT).show();


        }
        return super.onOptionsItemSelected(item);
    }



}
