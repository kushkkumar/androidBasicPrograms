package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t=findViewById(R.id.t1);
        registerForContextMenu(t);


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.m1,menu);
        super.onCreateContextMenu(menu,v,menuInfo);

    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        ConstraintLayout cs=findViewById(R.id.back);
        switch (item.getItemId()){
            case R.id.i1:
                cs.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.i2:
                cs.setBackgroundColor(Color.RED);

        }


       return super.onContextItemSelected(item);
    }

}
