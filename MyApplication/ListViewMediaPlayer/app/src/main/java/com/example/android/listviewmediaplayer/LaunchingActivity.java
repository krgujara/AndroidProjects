package com.example.android.listviewmediaplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LaunchingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep (5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openstartpoint=new Intent("android.intent.action.MAINACT");
                    startActivity(openstartpoint);
                }
            }
        };
        timer.start();


    }
}
