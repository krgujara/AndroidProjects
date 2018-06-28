package com.example.android.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowBookDetails extends AppCompatActivity {

    TextView nametv, paswtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_book_details);

        //Initializing views
        nametv = (TextView)findViewById(R.id.textViewname);
        paswtv = (TextView)findViewById(R.id.textViewpasword);

        //getting intent
        Intent intent = getIntent();

        //Displaying values by fetching from intent
        nametv.setText(String.valueOf(intent.getStringExtra(MainActivity.KEY_NAME)));
        paswtv.setText(String.valueOf(intent.getStringExtra(MainActivity.KEY_PASW)));
    }
}
