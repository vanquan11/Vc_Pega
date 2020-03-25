package com.example.vc_pega.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vc_pega.Model.DataPG;
import com.example.vc_pega.Model.ItemClick;
import com.example.vc_pega.R;
import com.example.vc_pega.databinding.ItemTypeFiveBinding;
import com.example.vc_pega.types.ItemFive;

import java.util.List;

public class AdapterRcvFive extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DataPG> list;
    private ItemClick onItemClick;

    public void setOnClickItemType5(ItemClick onClickItemType5) {
        this.onItemClick = onClickItemType5;
    }

    public AdapterRcvFive(Context context, List<DataPG> data) {
        this.context = context;
        list = data;
    }

    public void setData(List<DataPG> data){
        if (data != null){
            list.clear();
            list.addAll(data);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTypeFiveBinding itemType5Binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_type_five, parent, false);
        return new ItemFive(itemType5Binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ItemFive) holder).setFive(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null){
                    onItemClick.OnCLickItem(list.get(position).getUrl());
//                    onItemClick.OnCLickItem(list.get(position).url);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list == null){
            return  0;
        }
        return list.size();
    }
}
