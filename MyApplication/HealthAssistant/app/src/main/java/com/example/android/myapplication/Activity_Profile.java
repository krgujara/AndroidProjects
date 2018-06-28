package com.example.android.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Calendar;
public class Activity_Profile extends AppCompatActivity {
    //Wo open the shared preferences file by supplying the file name
    private static final String NAME = "mypref";
    private ImageView image;
    private EditText name, bloodgroup, address, doctor, dctrNumber;
    private Button save, refresh,view;
    private Button dateButton;
    private Spinner genderSpinner;
    private Calendar calendar;
    private TextView dateView;
    private int year, month,day;
    private String birthDate;
    private StringBuilder finalDate;
    private ArrayAdapter<CharSequence>genderAdapter;
    private String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__profile);
        init();


        //GENDER SPINNER CODE
        genderAdapter = ArrayAdapter.createFromResource(Activity_Profile.this,R.array.Gender,android.R.layout.simple_spinner_item);
        genderSpinner.setAdapter(genderAdapter);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender= parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Activity_Profile.this);

                //set title
                alertDialog.setTitle("Confirm Profile Creation");

                //setting Dialog Message
                alertDialog.setMessage("Are you sure you want to add this Data");

                //Setting icon to Dialog
                alertDialog.setIcon(R.drawable.profile2);

                //setting positive "yes" button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //write code here to save profile

                        //Get the reference to the internal storage preference
                        SharedPreferences preference = getSharedPreferences(NAME, MODE_APPEND);

                        //Access the editor to modify the shared preferences
                        SharedPreferences.Editor editor = preference.edit();

                        //Clear the data already stored
                        editor.clear();





                        //Use the editor, store new values in form of map(key, value pair)
                        String key = "name";
                        String value = name.getText().toString();

                        editor.putString(key,value);
                        editor.commit();

                        key = "birth_date";

                        value = finalDate.toString();
                        editor.putString(key,value);
                        editor.commit();


                        key = "gender";

                        value = gender;
                        editor.putString(key,value);
                        editor.commit();


                        key = "blood_group";
                        value = bloodgroup.getText().toString();
                        editor.putString(key,value);
                        editor.commit();

                        key = "address";
                        value = address.getText().toString();
                        editor.putString(key,value);
                        editor.commit();


                        key = "doctor";
                        value = doctor.getText().toString();
                        editor.putString(key,value);
                        editor.commit();


                        key = "dctr_mobile";
                        value = dctrNumber.getText().toString();
                        editor.putString(key,value);
                        editor.commit();


                        Toast.makeText(Activity_Profile.this, "Saved values in Shared References",Toast.LENGTH_LONG).show();

                    }
                });


                //setting no button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                //show alert message
                alertDialog.show();


            }
        });


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");


                bloodgroup.setText("");
                address.setText("");
                doctor.setText("");
                address.setText("");
                dctrNumber.setText("");
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressWarnings("deprecation")
            public void onClick(View v) {
                showDialog(999);

            }
        });





        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //View the profile of person from the Shared preferences
                SharedPreferences pref = getSharedPreferences(NAME,MODE_APPEND);
                Intent i = new Intent(Activity_Profile.this, Activity_View.class);
                startActivity(i);

            }
        });
    }
    void init() {
        image = (ImageView) findViewById(R.id.imgprofile);
        name = (EditText) findViewById(R.id.etname);
        /*birth = (EditText) findViewById(R.id.etbirth);*/
        dateButton=(Button)findViewById(R.id.buttonDate);
        genderSpinner = (Spinner) findViewById(R.id.spinner1);
        bloodgroup = (EditText) findViewById(R.id.etbloodgroup);
        address = (EditText) findViewById(R.id.etaddress);
        doctor = (EditText) findViewById(R.id.etfamdtrname);
        dctrNumber = (EditText) findViewById(R.id.etfamdtrmobile);
        save = (Button) findViewById(R.id.btnsav);
        refresh = (Button) findViewById(R.id.btnrefresh);
        view= (Button)findViewById(R.id.btnview);
        calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month = calendar.get(calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        //Month is 0 based so add 1

    }


    @Override
    protected Dialog onCreateDialog(int id) {

        if(id==999)
        {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };


    private void showDate(int year, int month, int day){
        finalDate = new StringBuilder();
        finalDate.append(day);
        finalDate.append("/");
        finalDate.append(month);
        finalDate.append("/");
        finalDate.append(year);

        Toast.makeText(Activity_Profile.this,finalDate,Toast.LENGTH_LONG).show();

    }

}
