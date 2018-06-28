package com.example.android.retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

//Class having onItemClickListener to handle the click on list
public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    public static final String ROOT_URL = "http://192.168.43.157:8081/Rest1182016";

    //Strings to bind this list will store type Book which is our data model

    public static final String KEY_NAME = "key_name";
    public static final String KEY_PASW = "key_pasw";

    //List view to show data
    private ListView listView;

    //List of type Pojo that will store type Login name and Pwd which is our data model
    private List<Pojo> PeopleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing ListView
        listView = (ListView) findViewById(R.id.listViewLoginDetails);

        //calling the method that will fetch data
        getBooks();

        //setting onItemClickListener on listView
        listView.setOnItemClickListener(this);

    }

    private void getBooks() {
        //while the app fetched data, show progress bar
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please Wait...", false, false);

        //create the rest adapter
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ROOT_URL).build();

        //creating an object of our api interface
        MInterface api = restAdapter.create(MInterface.class);

        //defining the method
        api.getUser(new Callback<List<Pojo>>() {
            @Override
            public void success(List<Pojo> pojos, Response response) {
                //dismiss the loading progress bar
                loading.dismiss();

                //storing the data in list
                PeopleList = pojos;

                //calling a method to show the list
                showList();
            }

            @Override
            public void failure(RetrofitError error) {
                //handle errors here

                Log.d("Message","Failure");

                Toast.makeText(MainActivity.this,"Conoection failure",Toast.LENGTH_LONG).show();
            }
        });
    }

    //method to show list
    public void showList() {
        //string array to store all user names
        String[] items = new String[PeopleList.size()];

        //Traversing through the whole List to get all the names

        for (int i = 0; i < PeopleList.size(); i++) {
            //Storing names in the string array
            items[i] = PeopleList.get(i).getName();
        }

        //creating an arrayadapter for listview
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.simple_list, items);

        //setting adapter to listview
        listView.setAdapter(adapter);

    }

    //This method will execute on list item click
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //creating an intent
        Intent intent = new Intent(this, ShowBookDetails.class);
        //getting the requested user from list
        Pojo pojo = PeopleList.get(position);

        intent.putExtra(KEY_NAME, pojo.getName());
        intent.putExtra(KEY_PASW, pojo.getPasword());

        //starting another activity
        startActivity(intent);
    }


}
