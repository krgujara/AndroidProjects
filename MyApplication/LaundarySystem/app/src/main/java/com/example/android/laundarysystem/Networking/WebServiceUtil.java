package com.example.android.laundarysystem.Networking;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Gujarathi on 13/08/2016.
 */
public class WebServiceUtil {
    public static JSONObject reqWebService(String serviceURL)
    {

        int CONNECTION_TIME_OUT=30000;
        int DATA_RETRIEVAL_TIME_OUT=30000;
        HttpURLConnection urlConnection = null;
        try
        {
            URL urlToRequest = new URL(serviceURL);
            urlConnection = (HttpURLConnection)urlToRequest.openConnection();
            urlConnection.setConnectTimeout(CONNECTION_TIME_OUT);
            urlConnection.setReadTimeout(DATA_RETRIEVAL_TIME_OUT);
            //Handle issues
            int statusCode = urlConnection.getResponseCode();

            if(statusCode==HttpURLConnection.HTTP_UNAUTHORIZED)
            {
                Log.d("Message","UNAUTHORISED USER!! NEEDS AUTHENTICATION THUS LOGIN AGAIN");
            }
            else if(statusCode!=HttpURLConnection.HTTP_OK)
            {
                Log.d("Message","404,500 TYPE ERRORS");
            }

            //Create JSON Object from content
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return new JSONObject(getResonseText(in));


        }catch(MalformedURLException e)
        {
            Log.d("Message","MalformedURLException");

        }catch (IOException e)
        {
            Log.d("Message","IOException");

        }catch (JSONException e){
            Log.d("Message","JSONException");
        }finally {
            if(urlConnection!=null){
                urlConnection.disconnect();
            }
        }

        return null;
    }

    private static String getResonseText(InputStream in)
    {
        return new Scanner(in).useDelimiter("\\A").next();
    }
}
