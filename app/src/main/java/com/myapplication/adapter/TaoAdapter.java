package com.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.myapplication.R;
import com.myapplication.databinding.ItemIamgeListBinding;
import com.myapplication.databinding.TaoLayoutBinding;

import java.util.List;

/**
 * Created by administrator on 2017/12/29.
 */

public class TaoAdapter extends RecyclerView.Adapter{
    ObservableField<List<String>> list;
    Context context;

    public TaoAdapter(Context context, ObservableField<List<String>> list){
        this.context= context;
        this.list= list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(LayoutInflater.from(
                context).inflate(R.layout.tao_layout, parent,
                false)) {};

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         TaoLayoutBinding binding = DataBindingUtil.bind(holder.itemView.getRootView());

    }

    @Override
    public int getItemCount() {
        return 15;
    }
}
