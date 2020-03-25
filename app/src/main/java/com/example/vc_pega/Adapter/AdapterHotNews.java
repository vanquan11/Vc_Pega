package com.example.vc_pega.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vc_pega.Model.ListDataPG;
import com.example.vc_pega.Model.Typess;
import com.example.vc_pega.R;
import com.example.vc_pega.databinding.LayoutFiveBinding;
import com.example.vc_pega.databinding.LayoutFourBinding;
import com.example.vc_pega.databinding.LayoutItemThreeBinding;
import com.example.vc_pega.databinding.LayoutOneBinding;
import com.example.vc_pega.databinding.LayoutTwoBinding;
import com.example.vc_pega.types.RcvFive;
import com.example.vc_pega.types.RcvFour;
import com.example.vc_pega.types.RcvOne;
import com.example.vc_pega.types.RcvThree;
import com.example.vc_pega.types.RcvTwo;

import java.util.List;

public class AdapterHotNews extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private Context context;
    private List<ListDataPG> dataList;

    public AdapterHotNews(Context context, List<ListDataPG> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public void setData(List<ListDataPG> data) {
        if (data != null) {
            dataList.clear();
            dataList.addAll(data);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(viewType == Typess.TYPE_3) {
            LayoutItemThreeBinding binding3 = DataBindingUtil.inflate(inflater, R.layout.layout_item_three, parent, false);
            return new RcvThree(context, binding3);
        }else if(viewType == Typess.TYPE_1) {
            LayoutOneBinding binding1 = DataBindingUtil.inflate(inflater, R.layout.layout_one, parent, false);
            return new RcvOne(context, binding1);
        }else if(viewType == Typess.TYPE_4){
            LayoutFourBinding binding4 = DataBindingUtil.inflate(inflater, R.layout.layout_four, parent, false);
            return new RcvFour(context, binding4);
        }else if(viewType == Typess.TYPE_5){
            LayoutFiveBinding binding5 = DataBindingUtil.inflate(inflater, R.layout.layout_five, parent, false);
            return new RcvFive(context, binding5);
        }else{
            LayoutTwoBinding binding2 = DataBindingUtil.inflate(inflater,R.layout.layout_two, parent, false);
            return new RcvTwo(context, binding2);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RcvThree) {
            ((RcvThree) holder).setType3View(context, dataList.get(position).getDataList());
        } else if (holder instanceof RcvOne) {
            ((RcvOne) holder).setType1View(context, dataList.get(position).getDataList());
        } else if (holder instanceof RcvFour){
            ((RcvFour) holder).setType4View(context, dataList.get(position).getDataList());
        }else if (holder instanceof RcvFive){
            ((RcvFive) holder).setType5View(context, dataList.get(position).getDataList());
        }else if (holder instanceof RcvTwo){
            ((RcvTwo) holder).setType2View(context, dataList.get(position).getDataList());
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position).getType() == 1) {
            return Typess.TYPE_1;
        } else if (dataList.get(position).getType() == 2) {
            return Typess.TYPE_2;
        }else if (dataList.get(position).getType() == 3){
            return Typess.TYPE_3;
        }else if (dataList.get(position).getType() == 4){
            return Typess.TYPE_4;
        } else
            return Typess.TYPE_5;
    }
}
