package com.example.root.qrscanner3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class car3 extends MainActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car3);
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    public  void onBackPressed(){
        scannerruning=false;
        System.exit(0);


    }
}
