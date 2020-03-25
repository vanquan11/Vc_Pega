package com.example.vc_pega.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.vc_pega.Adapter.AdapterHotNews;
import com.example.vc_pega.Model.DL;
import com.example.vc_pega.Model.ListDataPG;
import com.example.vc_pega.Model.SplitRcv;
import com.example.vc_pega.R;
import com.example.vc_pega.Retrofit.Response1;
import com.example.vc_pega.databinding.FragmentHotnewsBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentHotNews extends Fragment {
    private FragmentHotnewsBinding fragmentHotnewsBinding;
    private AdapterHotNews adapterHotNews;
    private List<ListDataPG> listDataPGS;
    private NewsVM newsVM;
    private Response1 response1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentHotnewsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_hotnews, container, false);
        listDataPGS = new ArrayList<>();
//        response1 = new Response1();
//        listDataPGS =  response1.getList();
        adapterHotNews = new AdapterHotNews(getContext(), listDataPGS);
        newsVM = ViewModelProviders.of(this).get(NewsVM.class);
        newsVM.getDatas().observe(this, dataPGS -> {
            if (dataPGS != null && dataPGS.size() != 0) {
                adapterHotNews.setData(dataPGS);
            }
        });
        fragmentHotnewsBinding.rcvHotnews.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentHotnewsBinding.rcvHotnews.setAdapter(adapterHotNews);
        fragmentHotnewsBinding.txtDate.setText(DL.getDate());

        return fragmentHotnewsBinding.getRoot();
    }

    //        newsVM = ViewModelProviders.of(this).get(NewsVM.class);
//        newsVM.getDatas().observe(this, dataPGS -> {
//            if (dataPGS != null && dataPGS.size() != 0){
//                adapterHotNews.setData(dataPGS);
//            }
//        });
}
