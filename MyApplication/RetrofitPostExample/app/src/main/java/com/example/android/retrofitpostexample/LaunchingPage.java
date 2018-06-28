package com.example.android.retrofitpostexample;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.retrofitpostexample.SessionManagement.SessionManagement;

import java.util.HashMap;

public class LaunchingPage extends AppCompatActivity {
    SessionManagement session;
    String name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching_page);
        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */

        // Session class instance
        session = new SessionManagement(getApplicationContext());
        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
         name = user.get(SessionManagement.KEY_NAME);

        // email
        email = user.get(SessionManagement.KEY_MOBILE);

        Toast.makeText(LaunchingPage.this, "Session information" + name + email, Toast.LENGTH_LONG).show();
    }

    

    //changePage is the method called on onClick event on Layout of the launching page
    //The launching page is empty. Has no textView, imageView,Nothing
    public void changePage(View view){
        if(session.isLoggedIn()){
            Toast.makeText(LaunchingPage.this, "Session information" + name + email, Toast.LENGTH_LONG).show();
            Intent i = new Intent(LaunchingPage.this, AfterLogin.class);
            startActivity(i);
            finish();

        }else {
            Toast.makeText(LaunchingPage.this, "Not logged in", Toast.LENGTH_LONG).show();
            Intent i = new Intent(LaunchingPage.this, LoginActivity.class);
            startActivity(i);

        }

    }
}
