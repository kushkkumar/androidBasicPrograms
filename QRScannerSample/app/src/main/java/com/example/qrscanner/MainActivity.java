package com.example.qrscanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
   private static final int CAMERA_PERMISSION_CODE =101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView barcode=findViewById(R.id.qrcodeg);


                String data="hello 123";

        //barcode generator

        MultiFormatWriter multiFormatWriter=new MultiFormatWriter();



        try {
            BitMatrix bitMatrix=multiFormatWriter.encode(data, BarcodeFormat.QR_CODE,200,200); //encode the string
            BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
            Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);  //conver into the qr code
            barcode.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();

        }

        //barcode scanner
        findViewById(R.id.button_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT>=23){
                    if(checkPermission(Manifest.permission.CAMERA)){
                        openScanner();
                    }
                    else
                        requestPermission(Manifest.permission.CAMERA,CAMERA_PERMISSION_CODE);
                }
                else{
                    openScanner();
                }

            }
        });



    }

    private void openScanner() {
        new IntentIntegrator(MainActivity.this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null){
            if(result.getContents()==null){
                Toast.makeText(this,"blank",Toast.LENGTH_SHORT).show();
            }
            else{
                ((TextView)findViewById(R.id.data_text)).setText("Data: "+result.getContents());
            }

        }
        else{
            Toast.makeText(getApplicationContext(),"Blank",Toast.LENGTH_SHORT).show();
        }
    }




    //to check whether it works on below API level if not provide the permission




    private boolean checkPermission(String permission){
        int result= ContextCompat.checkSelfPermission(MainActivity.this,permission);
        if(result== PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else
            return false;
    }
    private void requestPermission(String permission,int code){

        if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,permission)){

        }
        else
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{permission},code);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case CAMERA_PERMISSION_CODE:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    openScanner();
                }

        }
    }
}
