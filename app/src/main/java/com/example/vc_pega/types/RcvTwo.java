package com.example.vc_pega.types;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vc_pega.Adapter.AdapterRcvTwo;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.Model.ItemClick;
import com.example.vc_pega.activity.MainActivity;
import com.example.vc_pega.databinding.LayoutTwoBinding;

import java.util.List;

public class RcvTwo extends RecyclerView.ViewHolder implements ItemClick {
    private Context context;
    private LayoutTwoBinding layoutTwoBinding;
    private GridLayoutManager gridLayoutManager;

    public RcvTwo(Context context, @NonNull LayoutTwoBinding layoutTwoBinding) {
        super(layoutTwoBinding.getRoot());
        this.layoutTwoBinding = layoutTwoBinding;
        this.context = context;
    }

    public void setType2View(Context context, List<DataPG> data) {
        gridLayoutManager = new GridLayoutManager(context, 2);
        AdapterRcvTwo adapter = new AdapterRcvTwo(context, data);
        adapter.setOnClick(this);
        layoutTwoBinding.rcvList.setLayoutManager(gridLayoutManager);
        layoutTwoBinding.rcvList.setAdapter(adapter);
        layoutTwoBinding.rcvList.setNestedScrollingEnabled(false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
    }

    @Override
    public void OnCLickItem(String url) {
        ((MainActivity) context).Detail(url);
    }
}
