package com.example.android.laundarysystem.Networking.dao;

import android.util.Log;

import com.example.android.laundarysystem.Networking.WebServiceUtil;
import com.example.android.laundarysystem.Networking.dto.UserDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gujarathi on 13/08/2016.
 */
public class JsonToList {

    public List<UserDetails>findAllUsers(){
        JSONObject serviceResult = WebServiceUtil.reqWebService("http://192.168.242.1:8081/Rest1182016/backend/webService/getFeeds");
        List<UserDetails>foundUsers = new ArrayList<UserDetails>(20);

        try{
            JSONArray items = serviceResult.getJSONArray("feeds");
            for(int i=0;i<items.length();i++){
                JSONObject object = items.getJSONObject(i);
                foundUsers.add(new UserDetails(object.getString("name"),object.getString("pasword")));
            }
        }catch (JSONException e){
            Log.d("Message","JSONException");
        }
        return foundUsers;
    }
    public JsonToList getCurrentInstance(){
        return this;
    }
}
