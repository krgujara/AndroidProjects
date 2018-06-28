package com.example.android.implicitandexplicitintents;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button b1,b2,b3;
    private int reqCode=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            b1=(Button)findViewById(R.id.button1);
            b2=(Button)findViewById(R.id.button2);
            b3=(Button)findViewById(R.id.button3);
    }



    public void gotoActivity(View v){
        switch (v.getId()){



            case R.id.button1:

                break;

            case R.id.button2:
                Intent i = new Intent("android.intent.action.myIntent");
                startActivity(i);
                break;
            case R.id.button3:

                break;


        }

    }
}
