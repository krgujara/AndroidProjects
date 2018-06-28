package com.example.android.explicitintent;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener {

        Button b1;
    private ProgressDialog dlg;
    private static AlertDialog alert;
    public static LocationManager lManager;
    public String provider;
    public static double latitude;
    public static double longitude;
    public static Location loc;



    private  TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button)findViewById(R.id.btn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    dlg= ProgressDialog.show(MainActivity.this, "Fetching your current location.....please wait!!", "please wait");
              /* AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
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
        }); */
                lManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                provider = LocationManager.GPS_PROVIDER;
                loc = lManager.getLastKnownLocation(provider);
                if (loc != null)
                    updateLocation(loc);
                lManager.requestLocationUpdates(provider, 60, 1, this);


            }

        });
            public  void updateLocation(Location loc) {


                longitude = loc.getLongitude();
                latitude = loc.getLatitude();
                // lastLoc = loc;

                tv = (TextView) findViewById(R.id.tv1);

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
                dlg.cancel();


            }






    }
}