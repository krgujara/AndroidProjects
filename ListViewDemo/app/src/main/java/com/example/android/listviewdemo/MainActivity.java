package com.example.android.listviewdemo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    String mobileArray[] = {"REDMI", "SAMSANG", "MICROMAX", "Lenovo", "Windows"};
    ArrayList<String> list;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll = (LinearLayout)findViewById(R.id.linearlayout);
        registerForContextMenu(ll);


        list = new ArrayList<String>();
        for (int i = 0; i < mobileArray.length; ++i) {
            list.add(mobileArray[i]);
        }


        adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, list);
        ListView listV = (ListView) findViewById(R.id.mobile_list);
        listV.setAdapter(adapter);
        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {


                switch (position) {

                    case 0:
                        Intent ourIntent = new Intent(MainActivity.this, Redmi.class);
                        startActivity(ourIntent);
                        break;


                    case 1:
                        Intent ourIntent1 = new Intent(MainActivity.this, Samsang.class);
                        startActivity(ourIntent1);
                        break;

                    default:
                        Intent ourIntent3 = new Intent(MainActivity.this, Samsang.class);
                        startActivity(ourIntent3);
                        break;
                }
            }
        });

        registerForContextMenu(listV);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
      /*  menu.setHeaderTitle("Custom Context Menu");*/
        menu.add("Remove");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menu = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        list.remove(adapter.getItem(menu.position));
        return super.onContextItemSelected(item);
    }
}

