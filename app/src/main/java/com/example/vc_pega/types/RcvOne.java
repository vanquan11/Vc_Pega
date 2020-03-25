package com.example.vc_pega.types;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vc_pega.Adapter.AdapterRcvOne;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.Model.ItemClick;
import com.example.vc_pega.activity.MainActivity;
import com.example.vc_pega.databinding.LayoutOneBinding;

import java.util.List;

public class RcvOne extends RecyclerView.ViewHolder implements ItemClick {
    public LayoutOneBinding layoutOneBinding;
    private Context context;

    public RcvOne(Context context, @NonNull LayoutOneBinding layoutOneBinding) {
        super(layoutOneBinding.getRoot());
        this.layoutOneBinding = layoutOneBinding;
        this.context = context;
    }

    public void setType1View(Context context, List<DataPG> dataPGS) {
        AdapterRcvOne adapter = new AdapterRcvOne(context, dataPGS);
        adapter.setOnClickItemType1(this);
        layoutOneBinding.rcvlist.setLayoutManager(new LinearLayoutManager(context));
        layoutOneBinding.rcvlist.setAdapter(adapter);
        layoutOneBinding.rcvlist.setNestedScrollingEnabled(false);
    }

    @Override
    public void OnCLickItem(String url) {
        ((MainActivity) context).Detail(url);
    }
}
