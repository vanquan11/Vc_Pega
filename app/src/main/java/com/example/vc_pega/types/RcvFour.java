package com.example.vc_pega.types;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vc_pega.Adapter.AdapterRcvFour;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.Model.ItemClick;
import com.example.vc_pega.activity.MainActivity;
import com.example.vc_pega.databinding.LayoutFourBinding;

import java.util.List;

public class RcvFour extends RecyclerView.ViewHolder implements ItemClick {
    private Context context;
    public LayoutFourBinding layoutFourBinding;

    public RcvFour(Context context, @NonNull LayoutFourBinding layoutFourBinding) {
        super(layoutFourBinding.getRoot());
        this.layoutFourBinding = layoutFourBinding;
        this.context = context;
    }

    public void setType4View(Context context, List<DataPG> data) {
        AdapterRcvFour adapter = new AdapterRcvFour(context, data);
        adapter.setOnClickItemType4(this);
        layoutFourBinding.rcvEvent.setLayoutManager(new LinearLayoutManager(context));
        layoutFourBinding.rcvEvent.setAdapter(adapter);
        layoutFourBinding.rcvEvent.setNestedScrollingEnabled(false);
    }

    @Override
    public void OnCLickItem(String url) {
        ((MainActivity) context).Detail(url);
    }
}
