package com.example.android.learningproperties;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Gujarathi on 5/9/2016.
 */
public class Menu extends Activity{

    String myArray[]= {"Email","Photo","AnalogClock"};
    @Override
    protected void onCreate(Bundle b){

        super.onCreate(b);

        setContentView(R.layout.menu);
        ArrayAdapter adapter = new ArrayAdapter(Menu.this,R.layout.activity_list_view,myArray);

        ListView lv = (ListView) findViewById(R.id.menu_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        Intent ourIntent = new Intent(Menu.this, Email.class);
                        startActivity(ourIntent);
                        break;
                    case 1:
                        Intent ourIntent1 = new Intent(Menu.this, Photo.class);
                        startActivity(ourIntent1);
                        break;
                    case 2 :
                        Intent ourIntent2 = new Intent(Menu.this, AnalogClock.class);
                        startActivity(ourIntent2);
                        break;

                }
            }
        });
    }
}
