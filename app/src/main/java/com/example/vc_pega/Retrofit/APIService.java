package com.example.vc_pega.Retrofit;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("recommend?domain=pega")
    Call<String> getJson(@Query("&box_id") int box_id, @Query("&uid") int uid, @Query("&deviceid") int deviceid);
}
