package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Activity_Screen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__screen1);
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
                Intent i=new Intent(Activity_Screen1.this, Activity_Profile.class);
                startActivity(i);
                break;
            case R.id.medicines:
                Intent i1 = new Intent(Activity_Screen1.this,Activity_medicines.class);
                startActivity(i1);
                break;
            case R.id.location:

                break;
            case R.id.sms:

                break;
        }
        return true;
    }
}
