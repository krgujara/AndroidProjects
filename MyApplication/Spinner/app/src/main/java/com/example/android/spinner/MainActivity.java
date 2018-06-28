package com.example.android.spinner;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 //Implicit Intent
                 String url="www.google.com";
                 Intent read1=new Intent(Intent.ACTION_VIEW);
                 //read1.setAction(android.content.Intent.ACTION_VIEW);
                 read1.setData(Uri.parse(url));
                 //read1.setData(ContactsContract.Contacts.CONTENT_URI);
                 startActivity(read1);

                 //Implicit Intent
/*
                 String url = "http://www.vogella.com";
                 Intent i = new Intent(Intent.ACTION_VIEW);
                 i.setData(Uri.parse(url));
                 startActivity(i);*/
             }
         });

    }
}