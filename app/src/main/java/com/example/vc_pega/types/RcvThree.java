package com.example.vc_pega.types;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vc_pega.Adapter.AdapterLableTop;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.Model.ItemClick;
import com.example.vc_pega.activity.MainActivity;
import com.example.vc_pega.databinding.LayoutItemThreeBinding;

import java.util.List;

public class RcvThree  extends RecyclerView.ViewHolder implements ItemClick {
    public LayoutItemThreeBinding layoutItemThreeBinding;
    private Context context;

    public RcvThree(Context context, @NonNull LayoutItemThreeBinding layoutItemThreeBinding) {
        super(layoutItemThreeBinding.getRoot());
        this.layoutItemThreeBinding = layoutItemThreeBinding;
        this.context = context;
    }

    public void setType3View(Context context, List<DataPG> dataPGS) {
        AdapterLableTop adapter = new AdapterLableTop(context, dataPGS);
        adapter.setOnClickItemTypeListener(this);
        layoutItemThreeBinding.rcvTopnews.setLayoutManager(new LinearLayoutManager(context));
        layoutItemThreeBinding.rcvTopnews.setAdapter(adapter);
        layoutItemThreeBinding.rcvTopnews.setNestedScrollingEnabled(false);
    }

    @Override
    public void OnCLickItem(String url) {
        ((MainActivity) context).Detail(url);
    }
}
