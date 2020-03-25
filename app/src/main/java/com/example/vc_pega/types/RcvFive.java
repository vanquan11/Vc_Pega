package com.example.vc_pega.types;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vc_pega.Adapter.AdapterRcvFive;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.Model.ItemClick;
import com.example.vc_pega.activity.MainActivity;
import com.example.vc_pega.databinding.LayoutFiveBinding;

import java.util.List;

public class RcvFive extends RecyclerView.ViewHolder implements ItemClick {
    private Context context;
    private LayoutFiveBinding layoutFiveBinding;

    public RcvFive(Context context, @NonNull LayoutFiveBinding binding) {
        super(binding.getRoot());
        this.layoutFiveBinding = binding;
        this.context = context;
    }

    public void setType5View(Context context, List<DataPG> dataPGS){
        AdapterRcvFive adapter = new AdapterRcvFive(context, dataPGS);
        adapter.setOnClickItemType5(this);
        layoutFiveBinding.rcvtheme.setLayoutManager(new LinearLayoutManager(context));
        layoutFiveBinding.rcvtheme.setAdapter(adapter);
        layoutFiveBinding.rcvtheme.setNestedScrollingEnabled(false);
    }

    @Override
    public void OnCLickItem(String url) {
        ((MainActivity) context).Detail(url);
    }
}
