package com.example.vc_pega.types;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vc_pega.Model.DL;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.databinding.ItemTypeFiveBinding;

public class ItemFive extends RecyclerView.ViewHolder{
    private ItemTypeFiveBinding itemTypeFiveBinding;
    public ObservableField<String> title;
    public ObservableField<String> toppicname;
    public ObservableField<String> domain_name;

    public ItemFive(@NonNull ItemTypeFiveBinding binding) {
        super(binding.getRoot());
        this.itemTypeFiveBinding = binding;
        title = new ObservableField<>();
        toppicname = new ObservableField<>();
        domain_name = new ObservableField<>();
    }

    public void setFive(DataPG dataPG) {
        if (itemTypeFiveBinding.getItemFive() == null) {
            itemTypeFiveBinding.setItemFive(this);
        }
        title.set(dataPG.getTitle());
        toppicname.set(dataPG.getToppicname());
        domain_name.set(dataPG.getDomain().getName() + DL.pastDate(dataPG.getPublishdate()));
        Glide.with(itemTypeFiveBinding.imgDomain.getContext()).load(dataPG.getDomain().getImage()).into(itemTypeFiveBinding.imgDomain);
//        domain_name.set(dataPG.getDomain().name + DL.pastDate(dataPG.publishdate));
//        Glide.with(itemTypeFiveBinding.imgDomain.getContext()).load(dataPG.getDomain().image).into(itemTypeFiveBinding.imgDomain);
    }
}
