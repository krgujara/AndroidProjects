package com.example.android.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_View extends AppCompatActivity {
    //Wo open the shared preferences file by supplying the file name
    private static final String NAME = "mypref";
    ImageView image;
    TextView name, birth, gender, bloodgroup, address, doctor, dctrNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = getSharedPreferences(NAME,MODE_APPEND);

        setContentView(R.layout.activity_activity__view);
        init();



        String value = pref.getString("name", "default value");
        name.setText(value);

        value = pref.getString("birth_date", "default value");
        birth.setText(value);

        value = pref.getString("gender", "default value");
        gender.setText(value);

        value = pref.getString("blood_group", "default value");
        bloodgroup.setText(value);

        value = pref.getString("address", "default value");
        address.setText(value);


        value = pref.getString("birth_date", "default value");
        birth.setText(value);

        value = pref.getString("doctor", "default value");
        doctor.setText(value);

        value = pref.getString("dctr_mobile", "default value");
        dctrNumber.setText(value);

    }

    void init() {
        image = (ImageView) findViewById(R.id.imgprofile);
        name = (TextView) findViewById(R.id.etname);
        birth = (TextView) findViewById(R.id.etbirth);
        gender = (TextView) findViewById(R.id.etgender);
        bloodgroup = (TextView) findViewById(R.id.etbloodgroup);
        address = (TextView) findViewById(R.id.etaddress);
        doctor = (TextView) findViewById(R.id.etfamdtrname);
        dctrNumber = (TextView) findViewById(R.id.etfamdtrmobile);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*Menus are created when the user presses the menu button on screen.
        * This internally triggers the onCreateOptionsMenuButton*/
        /*Just change the parameter to inflate method*/
        /*Override the onCreate options menu and use the MenuInflater object's
        inflate() method to bing up the menus in front of the activity*/


        super.onCreateOptionsMenu(menu);



        /*1. Do this*/

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.screen1_optionsmenu,menu);


        /*2. Or do this*/
        /*
        getMenuInflater().inflate(R.menu.screen1_optionsmenu,menu);
        */
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    /*To perform the action on the basis of selected menu, make the use of
    * onOptionItemSelected().
    * This method is called when ever menu is selected by user
    * */

        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.profile:
                Intent i=new Intent(Activity_View.this, Activity_Profile.class);
                startActivity(i);
                break;
            case R.id.medicines:

                break;
            case R.id.location:

                break;
            case R.id.sms:

                break;
        }
        return true;
    }

}

