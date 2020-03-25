package com.example.vc_pega.types;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vc_pega.Model.DL;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.databinding.LayoutItemLableBinding;

public class LableTop extends RecyclerView.ViewHolder {
    public LayoutItemLableBinding layoutItemLableBinding;
    public ObservableField<String> title;
    public ObservableField<String> domain;
    private Context context;

    public LableTop(Context context, @NonNull LayoutItemLableBinding layoutItemLableBinding) {
        super(layoutItemLableBinding.getRoot());
        this.layoutItemLableBinding = layoutItemLableBinding;
        this.context = context;
        title = new ObservableField<>();
        domain = new ObservableField<>();
    }

    public void setBinding(DataPG dataPG) {
        if (layoutItemLableBinding.getLableTop() == null) {
            layoutItemLableBinding.setLableTop(this);
        }
        title.set(dataPG.getTitle());
        domain.set(dataPG.getDomain().getName() + DL.pastDate(dataPG.getPublishdate()));
//        domain.set(datum.getDomain().getName() + DL.pastDate(datum.publishdate));
    }
}
