package com.example.android.retrofitpostexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity{
    //Declaring views
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPasword;
    private EditText editTextMobile;
    private EditText editTextReferal;

    private Button buttonRegister;
    private Button buttonLogin;

    //This is our root url
    public static final String ROOT_URL ="http://192.168.43.157:8081/Rest1182016";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing Views

        editTextName = (EditText)findViewById(R.id.registerName);
        editTextEmail = (EditText)findViewById(R.id.registerEmail);
        editTextPasword = (EditText)findViewById(R.id.registerPassword);
        editTextMobile = (EditText)findViewById(R.id.registerMobile);
        editTextReferal = (EditText)findViewById(R.id.registerReferalCode);


        buttonRegister = (Button) findViewById(R.id.btnRegister);
        buttonLogin = (Button)findViewById(R.id.btnLinkToLoginScreen);
        //Adding listener to button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUser();
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to go to login screen
                Toast.makeText(MainActivity.this,"Login page",Toast.LENGTH_LONG).show();
                Intent i  = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);

            }
        });
    }

    private void insertUser(){
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        RegisterAPI api = adapter.create(RegisterAPI.class);
        //Defining the method insertuser of our interface
        api.registerUser(

                //Passing the values by getting it from editTexts
                editTextName.getText().toString(),
                editTextEmail.getText().toString(),
                editTextPasword.getText().toString(),
                editTextMobile.getText().toString(),
                editTextReferal.getText().toString(),

                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response response, Response response2) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";

                        try{
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(response.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();

                            if(output.equals("{result:'fail'}")){
                                Toast.makeText(MainActivity.this,"User Already Exists",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(MainActivity.this,"Login Success!! Welcome",Toast.LENGTH_LONG).show();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //Displaying the output as a toast
                        Toast.makeText(MainActivity.this, output, Toast.LENGTH_LONG).show();                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
    }


}
