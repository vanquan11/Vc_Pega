package com.example.vc_pega.Retrofit;

import android.os.AsyncTask;

import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.Model.DomainPG;
import com.example.vc_pega.Model.ListDataPG;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Response extends AsyncTask<String, Void, List<ListDataPG>> {
    private List<ListDataPG> list;
    private ListDataPG listDataPG;
    private List<DataPG> dataList;
    private getData onGetDT;

    @Override
    protected List<ListDataPG> doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String row;
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                while ((row = bufferedReader.readLine()) != null){
                    stringBuilder.append(row);
                }
            }
            list = new ArrayList<>();
            if (stringBuilder.toString() != null){
                JSONObject ob = new JSONObject(stringBuilder.toString());
                JSONObject hn = ob.getJSONObject("data");
                JSONArray news = hn.getJSONArray("news");
                for (int i = 0; i <= news.length(); i++){
                    dataList = new ArrayList<>();
                    JSONObject h = news.getJSONObject(i);
                    JSONArray data = h.getJSONArray("data");
                    for (int k = 0; k < data.length(); k++){
                        JSONObject object = data.getJSONObject(k);
                        JSONObject domain = object.getJSONObject("domain");
                        String imageicon = domain.optString("image");
                        String name = domain.optString("name");
                        DomainPG domainPG = new DomainPG(imageicon, name);
                        String image = object.optString("image");
                        int date = object.optInt("publishDate");
                        String sapo = object.optString("sapo");
                        String title = object.optString("title");
                        String source = object.optString("url");
                        String topicname = object.optString("topicName");

                        DataPG dataPG = new DataPG(domainPG, image, date, sapo, title, source, topicname);
                        dataList.add(dataPG);

                    }
                    listDataPG = new ListDataPG(dataList, h.optInt("boxId"), h.getInt("type"));
                    list.add(listDataPG);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(List<ListDataPG> dataPGS) {
        super.onPostExecute(dataPGS);
        if (onGetDT != null){
            onGetDT.onGet(dataPGS);
        }
    }

    public void setOnLoadDataNews(getData onGetDT) {
        this.onGetDT = onGetDT;
    }

    public interface getData{
        void onGet(List<ListDataPG> dataPGS);
    }
}
