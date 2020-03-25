package com.example.vc_pega.Fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vc_pega.Model.ListDataPG;
import com.example.vc_pega.Retrofit.Response;
import java.util.List;

public class NewsVM extends ViewModel {
    private Response response;
    private MutableLiveData<List<ListDataPG>> data;

    public MutableLiveData<List<ListDataPG>> getDatas(){
        if (data == null) {
            data = new MutableLiveData<List<ListDataPG>>();
            response = new Response();
            response.execute("http://nspapi.aiservice.vn/api/v2/news/recommend?domain=pega&box_id=1&uid=-1&deviceid=333");
            Response.getData onLoadDataNews = new Response.getData() {
                @Override
                public void onGet(List<ListDataPG> listDataPGS) {
                    data.setValue(listDataPGS);
                }
            };
            response.setOnLoadDataNews(onLoadDataNews);
        }
        return data;
    }

}
