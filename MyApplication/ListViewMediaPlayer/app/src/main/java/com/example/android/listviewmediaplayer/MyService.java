package com.example.android.listviewmediaplayer;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer mp;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(MyService.this, "Service Created", Toast.LENGTH_LONG).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String playsong = intent.getStringExtra("song");

        Toast.makeText(MyService.this, playsong , Toast.LENGTH_LONG).show();
        //  String link = "android.resource://"+packagename+"/"+R.raw.maid;
        mp = MediaPlayer.create(this, getResources().getIdentifier(playsong,
                "raw", getPackageName()));
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}






