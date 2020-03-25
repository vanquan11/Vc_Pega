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
import com.example.vc_pega.databinding.ItemTypeFourBinding;
import com.example.vc_pega.types.ItemFour;

import java.util.List;

public class AdapterRcvFour extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<DataPG> list;
    private ItemClick onItemClick;

    public void setOnClickItemType4(ItemClick onClickItemType4) {
        this.onItemClick = onClickItemType4;
    }

    public AdapterRcvFour(Context context, List<DataPG> dataPGS) {
        this.context = context;
        this.list = dataPGS;
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
        ItemTypeFourBinding itemType4Binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_type_four, parent, false);
        return new ItemFour(itemType4Binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ItemFour) holder).setFour(list.get(position));
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
        return list.size();
    }
}
