package com.example.android.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    //ARRAYS THAT WILL BE CONTAONONG DATA
    String[] names = {"Priyanka","Poonam","Dipak","Nivedita","Tejal","Sonal","Komal","Vinita"};
    String[] teams = {"Mumbai", "Indians", "Kings","Punjab" , "Delhi" ,"Devils", "Man", " City"};
    String[] golas = {"10","10","12","45","5","23","19","23" };
    int[] images = {R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DECLARE LIST VIEW
        lv= (ListView)findViewById(R.id.listView);

        //Adapter
        Adapter adapter = new Adapter(this, names, golas,teams, images);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),names[position],Toast.LENGTH_LONG).show();
            }
        });
    }
}
