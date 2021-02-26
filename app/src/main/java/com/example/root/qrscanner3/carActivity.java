package com.example.root.qrscanner3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class carActivity extends  MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
    }


    @Override
    public void onBackPressed() {
        scannerruning = false;
        System.exit(0);


    }
}