package com.example.vc_pega.types;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vc_pega.Model.DL;
import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.databinding.ItemTypeTwoBinding;

public class ItemTwo extends RecyclerView.ViewHolder{
    private ItemTypeTwoBinding itemType2Binding;
    public ObservableField<String> title;
    public ObservableField<String> domain_name;

    public ItemTwo(@NonNull ItemTypeTwoBinding binding) {
        super(binding.getRoot());
        this.itemType2Binding = binding;
        title = new ObservableField<>();
        domain_name = new ObservableField<>();
    }

    public void setItemtype2View(DataPG dataPG){
        if (itemType2Binding.getItemTwo() == null){
            itemType2Binding.setItemTwo(this);
        }
        title.set(dataPG.getTitle());
        domain_name.set(dataPG.getDomain().getName() + DL.pastDate(dataPG.getPublishdate()));
//        domain_name.set(dataPG.getDomain().name + DL.pastDate(dataPG.publishdate));
//        Glide.with(itemType2Binding.imgTitle2.getContext()).load(dataPG.image).into(itemType2Binding.imgTitle2);
//        Glide.with(itemType2Binding.imgDomain.getContext()).load(dataPG.getDomain().image).into(itemType2Binding.imgDomain);
        Glide.with(itemType2Binding.imgTitle2.getContext()).load(dataPG.getImage()).into(itemType2Binding.imgTitle2);
        Glide.with(itemType2Binding.imgDomain.getContext()).load(dataPG.getDomain().getImage()).into(itemType2Binding.imgDomain);

    }
}
