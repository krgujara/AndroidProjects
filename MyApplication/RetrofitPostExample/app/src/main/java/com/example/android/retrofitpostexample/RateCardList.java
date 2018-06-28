package com.example.android.retrofitpostexample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.retrofitpostexample.DataTransactionObjects.RateCard;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RateCardList extends AppCompatActivity {

    //List view to show data
    private ListView listView;

    //List of type Pojo that will store type Login name and Pwd which is our data model
    private List<RateCard> rateCardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_card_list);

        listView = (ListView)findViewById(R.id.listViewRateDetails);

        //calling the method that will fetch data
        getRateCard();

    }

public void getRateCard(){
    //while the app fetched data, show progress bar
    final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please Wait...", false, false);

    //create the rest adapter
    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(MainActivity.ROOT_URL).build();

    //creating an object of our api interface
    RegisterAPI api = restAdapter.create(RegisterAPI.class);

    api.getRateCard(new Callback<List<RateCard>>() {
        @Override
        public void success(List<RateCard> rateCards, Response response) {
            //dismiss the loading progress bar
            loading.dismiss();

            //storing the data in list
            rateCardList = rateCards;

            //calling a method to show the list
            showList();

        }

        @Override
        public void failure(RetrofitError error) {

        }
    });

}

    public void showList(){
        //string array to store all user names
        String[] items = new String[rateCardList.size()];

        //Traversing through the whole List to get all the names

        for (int i = 0; i < rateCardList.size(); i++) {
            //Storing names in the string array
            items[i] = rateCardList.get(i).getName();

        }

        //creating an arrayadapter for listview
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, items);

        //setting adapter to listview
        listView.setAdapter(adapter);


    }
}

