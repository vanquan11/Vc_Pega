package com.example.vc_pega.types;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vc_pega.Model.DL;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.databinding.ItemTypeTwoHBinding;

public class ItemThree extends RecyclerView.ViewHolder {
    private ItemTypeTwoHBinding itemTypeTwoHBinding;
    public ObservableField<String> title;
    public ObservableField<String> domain_name;

    public ItemThree(@NonNull ItemTypeTwoHBinding binding) {
        super(binding.getRoot());
        this.itemTypeTwoHBinding = binding;
        title = new ObservableField<>();
        domain_name = new ObservableField<>();
    }

    public void setItemtype2View(DataPG dataPG){
        if (itemTypeTwoHBinding.getItemThree() == null){
            itemTypeTwoHBinding.setItemThree(this);
        }
        title.set(dataPG.getTitle());
        domain_name.set(dataPG.getDomain().getName() + DL.pastDate(dataPG.getPublishdate()));
//        domain_name.set(dataPG.getDomain().name + DL.pastDate(dataPG.publishdate));
//        Glide.with(itemTypeTwoHBinding.imgTitle.getContext()).load(dataPG.image).into(itemTypeTwoHBinding.imgTitle);
//        Glide.with(itemTypeTwoHBinding.imgDomain.getContext()).load(dataPG.getDomain().image).into(itemTypeTwoHBinding.imgDomain);
        Glide.with(itemTypeTwoHBinding.imgTitle.getContext()).load(dataPG.getImage()).into(itemTypeTwoHBinding.imgTitle);
        Glide.with(itemTypeTwoHBinding.imgDomain.getContext()).load(dataPG.getDomain().getImage()).into(itemTypeTwoHBinding.imgDomain);

    }
}
