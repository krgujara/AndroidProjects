
package com.example.android.listviewmediaplayer;

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

    String mobileArray[] = {"maid", "kalimba", "sleepaway", "maid", "kalimba", "sleepaway", "maid", "kalimba", "sleepaway", "maid", "kalimba", "sleepaway", "maid", "kalimba", "sleepaway"};
    ArrayList<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearlayout);
        registerForContextMenu(ll);


        list = new ArrayList<String>();
        for (int i = 0; i < mobileArray.length; ++i) {
            list.add(mobileArray[i]);
        }


        adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, list);
        final ListView listV = (ListView) findViewById(R.id.mobile_list);
        listV.setAdapter(adapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                Intent i = new Intent(MainActivity.this, MyService.class);
                stopService(i);

                Intent i1 = new Intent(MainActivity.this, MyService.class);
                i1.putExtra("song", listV.getItemAtPosition(position).toString());

                // b.putString("song",listV.getItemAtPosition(position).toString());
                startService(i1);
            }
        });

        registerForContextMenu(listV);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add("Stop Song");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menu = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();


        Intent i = new Intent(MainActivity.this, MyService.class);
        stopService(i);

        return super.onContextItemSelected(item);
    }
}

