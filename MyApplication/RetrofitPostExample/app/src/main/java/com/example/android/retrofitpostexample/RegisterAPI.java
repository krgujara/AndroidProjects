package com.example.android.retrofitpostexample;
import com.example.android.retrofitpostexample.DataTransactionObjects.RateCard;

import java.util.List;

import retrofit.Callback;
        import retrofit.client.Response;
        import retrofit.http.Field;
        import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/backend/webService/putFeeds")
    public void registerUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("pasword") String pasword,
            @Field("mobile") String mobile,
            @Field("referal") String referal,
            Callback<Response> callback);

    @FormUrlEncoded
    @POST("/backend/webService/login")
    public void userLogin(
            @Field("mobile") String mobile,
            @Field("pasword") String pasword,
            Callback<Response> callback);


    @GET("/backend/webService/getRateCard")
    void getRateCard(Callback<List<RateCard>> response);
}
