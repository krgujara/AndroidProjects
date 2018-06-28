package com.example.android.lisrview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //created the thread to make the app wait at this activity and make it
        //wait for 5 ms
        //and then finally start the new intent StartActivity


        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep (5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openstartpoint=new Intent("android.intent.action.STARTPOINT");
                    startActivity(openstartpoint);
                }

            }
        };
        timer.start();

    }

    //NOw once we are done with this activity, and after 5 ms once we go to StartPoint Activity,
    //we have to kill this activity so that memory is freed and once we click the back button from the
    //startPoint activity class, we dnt see this page again
    //finish method of onPauase does this


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
