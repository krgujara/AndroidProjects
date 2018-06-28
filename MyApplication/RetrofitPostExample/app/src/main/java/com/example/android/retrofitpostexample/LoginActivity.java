package com.example.android.retrofitpostexample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.retrofitpostexample.AlertDialog.AlertDialogManager;
import com.example.android.retrofitpostexample.SessionManagement.SessionManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {
    Button login, register;
    EditText mobile, pasword;

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobile = (EditText) findViewById(R.id.loginMobile);
        pasword = (EditText) findViewById(R.id.loginPassword);
        login = (Button) findViewById(R.id.LoginLogin);
        register = (Button) findViewById(R.id.LoginRegister);


        // Session Manager
        session = new SessionManagement(getApplicationContext());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ((mobile.getText().toString().trim().length() > 0) && pasword.getText().toString().trim().length() > 0) {

                    validateAndLogin();
                } else {
                    Toast.makeText(LoginActivity.this, "Please insert both username and pasword", Toast.LENGTH_LONG).show();
                    // user didn't entered username or password
                    // Show alert asking him to enter the details
                    alert.showAlertDialog(LoginActivity.this, "Login failed..", "Please enter username and password", false);
                }
            }
        });
    }

    public void validateAndLogin() {
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(MainActivity.ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        RegisterAPI api = adapter.create(RegisterAPI.class);
        //Defining the method insertuser of our interface
        api.userLogin(
                //Passing the values by getting it from editTexts
                mobile.getText().toString(),
                pasword.getText().toString(),
                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response response, Response response2) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;
                        final String SUCCESS_RESULT = "{result:'success'}";
                        final String FAILURE_RESULT = "{result:'failure'}";


                        //An string to store output from the server
                        String output = "";

                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(response.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //Displaying the output as a toast
                        Toast.makeText(LoginActivity.this, "output:" + output, Toast.LENGTH_LONG).show();
                        Log.d("Result", output);

                        if (output.equals(SUCCESS_RESULT)) {
                            // Creating user login session
                            // For testing i am stroing name, email as follow
                            // Use user real data
                            session.createLoginSession("LaundaryLine", mobile.getText().toString());

                            Intent i = new Intent(LoginActivity.this, AfterLogin.class);
                            startActivity(i);
                        } else if (output.equals(FAILURE_RESULT)) {
                            //If any error occured displaying the error as toast
                            alert.showAlertDialog(LoginActivity.this, "Login failed..", "Mobile Number/Password is incorrect", false);

                        }
                    }


                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
    }


}
