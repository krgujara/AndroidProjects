package com.example.android.retrofit;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


public interface MInterface {
    //project Rest1182016 should be running fine on URL
    //http://192.168.1.38:8081/Rest1182016/backend/webService/getFeeds
    //http://localhost:8081/Rest1182016/backend/webService/getFeeds  - for only running web service

    @GET("/backend/webService/getFeeds/")
    void getUser(Callback<List<Pojo>> response);
}
