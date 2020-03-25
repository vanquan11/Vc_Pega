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
import com.example.vc_pega.Model.Typess;
import com.example.vc_pega.R;
import com.example.vc_pega.databinding.ItemTypeTwoBinding;
import com.example.vc_pega.databinding.ItemTypeTwoHBinding;
import com.example.vc_pega.types.ItemThree;
import com.example.vc_pega.types.ItemTwo;

import java.util.List;

public class AdapterRcvTwo extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<DataPG> list;
    private ItemClick onItemClick;

    public void setOnClick(ItemClick onClickItemType2) {
        this.onItemClick = onClickItemType2;
    }

    public AdapterRcvTwo(Context context, List<DataPG> dataPGS) {
        this.context = context;
        this.list = dataPGS;
    }

    public void setData(List<DataPG> data) {
        if (data != null) {
            list.clear();
            list.addAll(data);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == Typess.TYPE_2) {// Typess.TYPE_1
            ItemTypeTwoBinding itemType2Binding = DataBindingUtil.inflate(inflater, R.layout.item_type_two, parent, false);
            return new ItemTwo(itemType2Binding);
        } else {
            ItemTypeTwoHBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_type_two_h, parent, false);
            return new ItemThree(binding);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ItemTwo) {
            ((ItemTwo) holder).setItemtype2View(list.get(position));
        } else if (holder instanceof ItemThree) {
            ((ItemThree) holder).setItemtype2View(list.get(position));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null) {
                    onItemClick.OnCLickItem(list.get(position).getUrl());
//                    onItemClick.OnCLickItem(list.get(position).url);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list == null || list.size() == 0) {
            return 0;
        }
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
//        if (position == 0) {
//            return Typess.TYPE_1;
//        } else {
//            return Typess.TYPE_2;
//        }

        if (position == 0) {
            return Typess.TYPE_2;
        } else {
            return Typess.TYPE_3;
        }
    }
}
