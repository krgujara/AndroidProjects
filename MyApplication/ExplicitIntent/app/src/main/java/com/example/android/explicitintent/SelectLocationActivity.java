package com.example.administrator.locationsearch;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectLocationAcivity extends AppCompatActivity implements LocationListener {


    public static double latitude;
    public static double longitude;
    public static LocationManager lManager;
    public Location lastLoc;
    public static Location loc;
    TextView tv;
    private ProgressDialog pg;
    private static String loc1;
    public static String fin_loc;
    public String provider;
    private  ProgressDialog dlg;

    private static AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_select_location_acivity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Select Places");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView lv = (ListView) findViewById(R.id.list);

        lManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //List<String> providers = lManager.getProviders(true);

        // boolean gpsEnabled = lManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        //Toast.makeText(this, "in on create" + gpsEnabled, Toast.LENGTH_LONG).show();
        //boolean netEnabled = lManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        //Toast.makeText(this, "in on create" +netEnabled, Toast.LENGTH_LONG).show();
        provider = LocationManager.GPS_PROVIDER ;

       // if (lManager.isProviderEnabled(LocationManager.GPS_PROVIDER) && isNetworkAvailable())
        //{
           // dlg= ProgressDialog.show(SelectLocationAcivity.this, "Fetching your current location.....please wait!!", "please wait");
          /* loc = lManager.getLastKnownLocation(provider);
            if(loc!=null)
                updateLocation(loc);*/

       // }
        //else {

          //  if ((!lManager.isProviderEnabled(LocationManager.GPS_PROVIDER))) {
               // dlg= ProgressDialog.show(this, "Fetching your current location.....please wait!!", "please wait");
                //turnGPSOn();
                /*loc = lManager.getLastKnownLocation(provider);
                if(loc!=null)
                    updateLocation(loc);*/
           // }

           /* if((!isNetworkAvailable()))
            {

                Toast.makeText(this,"please enable ur network", Toast.LENGTH_LONG).show();
                Intent in=new Intent(SelectLocationAcivity.this,MainActivity.class);
                startActivity(in);


            }*/

        }

      /*  loc = lManager.getLastKnownLocation(provider);
        if(loc!=null)
            updateLocation(loc);*/

        lManager.requestLocationUpdates(provider, 60, 1, this);
       // lv.setAdapter(new LocationAdapter(this));  //for custom adapter
       // lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           // @Override
           // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  dlg= ProgressDialog.show(SelectLocationAcivity.this, "Fetching your current location.....please wait!!","please");



               // if(lManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                  //  if (isNetworkAvailable()) {
                        //dlg.cancel();


                      //  loc1 = LocationAdapter.category[position];

                       // Intent i = new Intent(SelectLocationAcivity.this, PlaceList.class);
                        //fin_loc = loc1.toLowerCase();
                        //if (fin_loc.contains(" ")) {
                          //  String fin_loc1[] = fin_loc.split(" ");
                            //String fin_loc2 = fin_loc1[0].concat("_");
                            //fin_loc2 = fin_loc2.concat(fin_loc1[1]);
                            //fin_loc = fin_loc2;
                       // }

                        //i.putExtra("selected_location", fin_loc);
                        //i.putExtra("current_latitude", String.valueOf(latitude));
                        //i.putExtra("current_longitude", String.valueOf(longitude));
                        //startActivity(i);
                        //dlg.cancel();
                    //} else// {
                        // Toast.makeText(SelectLocationAcivity.this, "please enable network", Toast.LENGTH_LONG).show();
                      //  Intent i = new Intent(SelectLocationAcivity.this, MainActivity.class);
                        //startActivity(i);
                        //finish();
                    //}
                //}
                //else{
                    // dlg= ProgressDialog.show(SelectLocationAcivity.this, "Fetching Device Location", "please wait");
                  //  turnGPSOn();
                    loc = lManager.getLastKnownLocation(provider);
                    if (loc != null)
                        updateLocation(loc);


                }

            }

      //  });

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void turnGPSOn() {
        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = service
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!enabled) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);
            alertDialogBuilder
                    .setMessage("GPS is disabled in your device. Enable it?")
                    .setCancelable(false)
                    .setPositiveButton("Enable GPS",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {


                                    Intent callGPSSettingIntent = new Intent(
                                            android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                    startActivity(callGPSSettingIntent);
                                }
                            });
            alertDialogBuilder.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            // updateLocation(loc);
                            //Toast.makeText(SelectLocationAcivity.this, "Click on Enable GPS", Toast.LENGTH_LONG).show();
                        }
                    });
            alert = alertDialogBuilder.create();
            alert.show();



        }

//return true;
//pg.cancel();
    }


    private void updateLocation(Location loc) {



        longitude = loc.getLongitude();
        latitude = loc.getLatitude();
        // lastLoc = loc;

        tv = (TextView) findViewById(R.id.text);

        String streetAddr = "";
        Geocoder gc = new Geocoder(this);
        try {

            // Toast.makeText(this, "hhhhhhhhhhhhhhhh" + latitude, Toast.LENGTH_LONG).show();
            List<Address> addresses = gc.getFromLocation(latitude, longitude, 2);
            if (addresses != null && !addresses.isEmpty()) {
                Address address = addresses.get(0);
                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    streetAddr += address.getAddressLine(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv.setText("");

        tv.append(streetAddr);
      //  dlg.cancel();



    }

    @Override
    public void onLocationChanged(Location location) {

        updateLocation(location);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }




}
















