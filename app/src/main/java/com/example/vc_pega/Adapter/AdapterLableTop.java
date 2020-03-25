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
import com.example.vc_pega.databinding.LayoutItemLableBinding;
import com.example.vc_pega.types.LableTop;

import java.util.List;

public class AdapterLableTop  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<DataPG> listDataPG;
    private LayoutItemLableBinding lableBinding;
    private ItemClick onItemClick;

    public void setOnClickItemTypeListener(ItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public AdapterLableTop(Context context, List<DataPG> dataPGS) {
        this.context = context;
        this.listDataPG = dataPGS;
    }

    public void setData(List<DataPG> data) {
        if (data != null) {
            listDataPG.clear();
            listDataPG.addAll(data);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        lableBinding = DataBindingUtil.inflate(inflater, R.layout.layout_item_lable, parent, false);
        return new LableTop(context, lableBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof LableTop) {
            ((LableTop) holder).setBinding(listDataPG.get(position));
            int pos = position + 1;
            ((LableTop) holder).layoutItemLableBinding.txtStt.setText(pos + ".");
            ((LableTop) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClick != null) {
                        onItemClick.OnCLickItem(listDataPG.get(position).getUrl());
//                        onItemClick.OnCLickItem(listDataPG.get(position).url);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listDataPG.size();
    }
}
