package com.example.android.lisrview;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Gujarathi on 5/5/2016.
 */
public class PlayMusic extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.startingpoint);

        MediaPlayer ourSong = MediaPlayer.create(PlayMusic.this,R.raw.ringtone);
        ourSong.start();


    }
}