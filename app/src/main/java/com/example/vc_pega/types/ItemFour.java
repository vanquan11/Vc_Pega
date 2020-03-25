package com.example.vc_pega.types;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vc_pega.Model.DL;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.databinding.ItemTypeFourBinding;

public class ItemFour extends RecyclerView.ViewHolder {
    public ItemTypeFourBinding itemTypeFourBinding;
    public ObservableField<String> toppicName;
    public ObservableField<String> title;
    public ObservableField<String> domain_name;

    public ItemFour(@NonNull ItemTypeFourBinding binding) {
        super(binding.getRoot());
        this.itemTypeFourBinding = binding;
        toppicName = new ObservableField<>();
        title = new ObservableField<>();
        domain_name = new ObservableField<>();
    }

    public void setFour(DataPG dataPG){
        if (itemTypeFourBinding.getItemFour() == null){
            itemTypeFourBinding.setItemFour(this);
        }
        toppicName.set(dataPG.getToppicname());
        title.set(dataPG.getTitle());
        domain_name.set(dataPG.getDomain().getName() + DL.pastDate(dataPG.getPublishdate()));
//        domain_name.set(dataPG.getDomain().name + DL.pastDate(dataPG.publishdate));
        Glide.with(itemTypeFourBinding.imgTitle.getContext()).load(dataPG.getImage()).into(itemTypeFourBinding.imgTitle);
        Glide.with(itemTypeFourBinding.imgDomain.getContext()).load(dataPG.getDomain().getImage()).into(itemTypeFourBinding.imgDomain);
    }
}
