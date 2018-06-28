package com.example.android.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TopSectionFragment.TopSectionListener{

    @Override
    public void transferData(String top, String bottom) {
        BottonSectionFragment bottonSectionFragment =(BottonSectionFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottonSectionFragment.setValues(top,bottom);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
