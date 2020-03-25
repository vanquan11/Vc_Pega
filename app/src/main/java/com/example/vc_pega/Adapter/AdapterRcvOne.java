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
import com.example.vc_pega.databinding.LayoutItemOneBinding;
import com.example.vc_pega.types.ItemOne;

import java.util.List;

public class AdapterRcvOne extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DataPG> list;
    private ItemClick onItemClick;

    public void setOnClickItemType1(ItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public AdapterRcvOne(Context context, List<DataPG> dataPGS) {
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
        LayoutInflater inflater = LayoutInflater.from(context);
        LayoutItemOneBinding binding = DataBindingUtil.inflate(inflater, R.layout.layout_item_one, parent, false);
        return new ItemOne(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ItemOne) holder).setOne(list.get(position));
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
        if (list == null || list.size() ==0){
            return 0;
        }
        return list.size();
    }
}
