package com.example.vc_pega.types;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vc_pega.Model.DL;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.databinding.LayoutItemOneBinding;

public class ItemOne extends RecyclerView.ViewHolder{
    public LayoutItemOneBinding layoutItemOneBinding;
    public ObservableField<String> title;
    public ObservableField<String> sapo;
    public ObservableField<String> doamain_name;
    public ObservableField<String> timeago;

    public ItemOne(@NonNull LayoutItemOneBinding binding) {
        super(binding.getRoot());
        layoutItemOneBinding = binding;
        title = new ObservableField<>();
        sapo = new ObservableField<>();
        doamain_name = new ObservableField<>();
        timeago = new ObservableField<>();
    }

    public void setOne(DataPG dataPG){
        if (layoutItemOneBinding.getItemOne() == null){
            layoutItemOneBinding.setItemOne(this);
        }
        title.set(dataPG.getTitle());
        sapo.set(dataPG.getSapo());
//        doamain_name.set(dataPG.getDomain().name + DL.pastDate(dataPG.publishdate));
        doamain_name.set(dataPG.getDomain().getName() + DL.pastDate(dataPG.getPublishdate()));
        Glide.with(layoutItemOneBinding.imgHotnews.getContext()).load(dataPG.getImage()).into(layoutItemOneBinding.imgHotnews);
        Glide.with(layoutItemOneBinding.imgDomain.getContext()).load(dataPG.getDomain().getImage()).into(layoutItemOneBinding.imgDomain);
    }
}
