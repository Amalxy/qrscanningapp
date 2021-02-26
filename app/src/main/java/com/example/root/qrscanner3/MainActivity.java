package com.example.root.qrscanner3;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.icu.text.StringSearch;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.google.zxing.Result;

import java.util.List;

import androidx.annotation.NonNull;

public class MainActivity extends Activity {
    private CodeScanner mCodeScanner;
    CodeScannerView scannerView;
    private int permissonint = 1;
    boolean scannerruning= false;
    public String[] token = {"car2" ,"car","car3"};
    public boolean runningactivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setScanMode(ScanMode.CONTINUOUS);






        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            new AlertDialog.Builder(this).setTitle("Permission is needed for the Camera!")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, permissonint);


                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        }
        else{
        mCodeScanner.startPreview();}

        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {

                if (token[0].matches(result.toString()) && !runningactivity){

                    runningactivity=true;
                    mCodeScanner.stopPreview();
                    mCodeScanner.releaseResources();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                           starcaractivity2();


                    }
                });
            }
                if (token[1].matches(result.toString())&& !runningactivity){
                    runningactivity=true;
                    mCodeScanner.stopPreview();
                    mCodeScanner.releaseResources();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            starcaractivity();

                        }
                    });
                }

                if (token[2].matches(result.toString())&& !runningactivity){
                    runningactivity=true;
                    mCodeScanner.stopPreview();
                    mCodeScanner.releaseResources();


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            starcaractivity3();

                        }
                    });
                }


            }
        });



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @android.support.annotation.NonNull String[] permissions, @android.support.annotation.NonNull int[] grantResults) {
       if(requestCode ==permissonint){
           if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
               mCodeScanner.startPreview();
               scannerruning=true;
           }
       }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(!scannerruning){
        mCodeScanner.startPreview();}
    }

    @Override
    protected void onPause() {
        if(scannerruning){
            mCodeScanner.stopPreview();
            mCodeScanner.releaseResources();
        }
        super.onPause();
    }

    public void starcaractivity2(){


        Intent intent = new Intent(MainActivity.this,car2.class);
        intent.putExtra("run",runningactivity);
        startActivity(intent);


    }

    public void starcaractivity(){

        Intent intent = new Intent(MainActivity.this,carActivity.class);
        intent.putExtra("run",runningactivity);
        startActivity(intent);



    }
    public void starcaractivity3(){


        Intent intent = new Intent(MainActivity.this,car3.class);
        intent.putExtra("run",runningactivity);
        startActivity(intent);



    }
}
