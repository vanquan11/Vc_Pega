package com.example.vc_pega.Retrofit;

import android.util.Log;

import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitData {

    private static volatile RetrofitData mInstance = null;
    private Retrofit retrofit;

    private RetrofitData() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://nspapi.aiservice.vn/api/v2/news/")
                .client(new OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
    }
    public static RetrofitData self() {
        if (mInstance == null)
            mInstance = new RetrofitData();
        return mInstance;
    }

    private <T> T getService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }

    public void getTodo(int boxID, int uID, int deviceid, final CoreCallBack.With<String> coreCallBack) {
        getService(APIService.class).getJson(boxID, uID, deviceid).enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (coreCallBack != null) {
                    coreCallBack.run(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }


//    public static APIService lockImage;
//    public static APIService getInstance(){
//        if (lockImage == null){
//            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://nspapi.aiservice.vn/api/v2/news/recommend?domain=pega&box_id=1&uid=-1&deviceid=333").build();
//            lockImage = retrofit.create(APIService.class);
//        }
//        return lockImage;
//    }
}
