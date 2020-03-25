package com.example.vc_pega.Retrofit;

import android.util.Log;

import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.Model.DomainPG;
import com.example.vc_pega.Model.ListDataPG;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Response1 {
    private List<ListDataPG> list = new ArrayList<>();
    private ListDataPG listDataPG;
    private Retrofit retrofit;
    private List<DataPG> dataList;
    private String strAPi = "http://nspapi.aiservice.vn/api/v2/news/recommend?domain=pega&box_id=1&uid=-1&deviceid=333";

    public Response1() {
//        makeServiceCall(strAPi);

        RetrofitData.self().getTodo(1, -1, 333, new CoreCallBack.With<String>() {
            @Override
            public void run(String str) {
                if (str != null){
                    try {
                        JSONObject ob = new JSONObject(str);
                        JSONObject data1 = ob.getJSONObject("data");
                        JSONArray news = data1.getJSONArray("news");
                        for (int i = 0; i <= news.length(); i++) {
                            dataList = new ArrayList<>();
                            JSONObject h = news.getJSONObject(i);
                            JSONArray data = h.getJSONArray("data");
                            for (int k = 0; k < data.length(); k++) {
                                JSONObject object = data.getJSONObject(k);
                                JSONObject domain = object.getJSONObject("domain");
                                String imageIcon = domain.getString("image");
                                String name = domain.getString("name");
                                DomainPG domainPG = new DomainPG(imageIcon, name);
                                String image = object.getString("image");
                                int date = object.getInt("publishDate");
                                String sapo = object.getString("sapo");
                                String title = object.getString("title");
                                String source = object.getString("url");
                                String topicName = object.getString("topicName");
                                DataPG dataPG = new DataPG(domainPG, image, date, sapo, title, source, topicName);
                                dataList.add(dataPG);
                            }
                            listDataPG = new ListDataPG(dataList, h.optInt("boxId"), h.getInt("type"));
                            list.add(listDataPG);
                            setList(list);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

//        APIService apiService = retrofit.create(APIService.class);
//        apiService.getJson().enqueue(new Callback<JSONObject>() {
//            @Override
//            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
//                try {
//                    JSONObject ob = response.body();
//                    JSONObject data1 = ob.getJSONObject("data");
//                    JSONArray news = data1.getJSONArray("news");
//                    for (int i = 0; i <= news.length(); i++) {
//                        dataList = new ArrayList<>();
//                        JSONObject h = news.getJSONObject(i);
//                        JSONArray data = h.getJSONArray("data");
//                        for (int k = 0; k < data.length(); k++) {
//                            JSONObject object = data.getJSONObject(k);
//                            JSONObject domain = object.getJSONObject("domain");
//                            String imageIcon = domain.getString("image");
//                            String name = domain.getString("name");
//                            DomainPG domainPG = new DomainPG(imageIcon, name);
//                            String image = object.getString("image");
//                            int date = object.getInt("publishDate");
//                            String sapo = object.getString("sapo");
//                            String title = object.getString("title");
//                            String source = object.getString("url");
//                            String topicName = object.getString("topicName");
//                            DataPG dataPG = new DataPG(domainPG, image, date, sapo, title, source, topicName);
//                            dataList.add(dataPG);
//                        }
//                        listDataPG = new ListDataPG(dataList, h.optInt("boxId"), h.getInt("type"));
//                        list.add(listDataPG);
//                        setList(list);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JSONObject> call, Throwable t) {
//
//            }
//        });

//        RetrofitData.getInstance().getJson().enqueue(new Callback<JSONObject>() {
//
//            @Override
//            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
//                try {
//                    JSONObject ob = response.body();
//                    JSONObject data1 = ob.getJSONObject("data");
//                    JSONArray news = data1.getJSONArray("news");
//                    for (int i = 0; i <= news.length(); i++) {
//                        dataList = new ArrayList<>();
//                        JSONObject h = news.getJSONObject(i);
//                        JSONArray data = h.getJSONArray("data");
//                        for (int k = 0; k < data.length(); k++) {
//                            JSONObject object = data.getJSONObject(k);
//                            JSONObject domain = object.getJSONObject("domain");
//                            String imageIcon = domain.getString("image");
//                            String name = domain.getString("name");
//                            DomainPG domainPG = new DomainPG(imageIcon, name);
//                            String image = object.getString("image");
//                            int date = object.getInt("publishDate");
//                            String sapo = object.getString("sapo");
//                            String title = object.getString("title");
//                            String source = object.getString("url");
//                            String topicName = object.getString("topicName");
//                            DataPG dataPG = new DataPG(domainPG, image, date, sapo, title, source, topicName);
//                            dataList.add(dataPG);
//                        }
//                        listDataPG = new ListDataPG(dataList, h.optInt("boxId"), h.getInt("type"));
//                        list.add(listDataPG);
//                        setList(list);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JSONObject> call, Throwable t) {
//
//            }
//        });

    }

    public List<ListDataPG> getList() {
        return list;
    }

    public void setList(List<ListDataPG> list) {
        this.list = list;
    }

    public void makeServiceCall(String reqUrl) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(reqUrl);
                    HttpURLConnection conn = (HttpURLConnection)
                            url.openConnection();
                    conn.setReadTimeout(30000);
                    conn.setConnectTimeout(30000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);

                    conn.connect();
                    InputStream stream = conn.getInputStream();
                    String data = convertStreamToString(stream);
                    readAndParseJSON(data);
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public void readAndParseJSON(String in) {
        try {
            JSONObject ob = new JSONObject(in);
            JSONObject data1 = ob.getJSONObject("data");
            JSONArray news = data1.getJSONArray("news");
            for (int i = 0; i <= news.length(); i++) {
                dataList = new ArrayList<>();
                JSONObject h = news.getJSONObject(i);
                JSONArray data = h.getJSONArray("data");
                for (int k = 0; k < data.length(); k++) {
                    JSONObject object = data.getJSONObject(k);
                    JSONObject domain = object.getJSONObject("domain");
                    String imageIcon = domain.getString("image");
                    String name = domain.getString("name");
                    DomainPG domainPG = new DomainPG(imageIcon, name);
                    String image = object.getString("image");
                    int date = object.getInt("publishDate");
                    String sapo = object.getString("sapo");
                    String title = object.getString("title");
                    String source = object.getString("url");
                    String topicName = object.getString("topicName");
                    DataPG dataPG = new DataPG(domainPG, image, date, sapo, title, source, topicName);
                    dataList.add(dataPG);
                }
                listDataPG = new ListDataPG(dataList, h.optInt("boxId"), h.getInt("type"));
                list.add(listDataPG);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setList(list);
    }
}
