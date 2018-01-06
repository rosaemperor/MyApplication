package com.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapplication.R;
import com.myapplication.databinding.TaoLayout2Binding;
import com.myapplication.viewModel.TaoChildViewModel;
import com.myapplication.viewModel.TaoViewModel;

import java.util.List;

/**
 * Created by administrator on 2018/1/4.
 */

public class TaoChildAdapter extends RecyclerView.Adapter {
    List<TaoChildViewModel> viewModels;
    Context context;


    public TaoChildAdapter(Context context, List<TaoChildViewModel> list){
        this.context= context;
        this.viewModels= list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(LayoutInflater.from(
                context).inflate(R.layout.tao_layout2, parent,
                false)) {};

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TaoLayout2Binding binding=DataBindingUtil.bind(holder.itemView.getRootView());
        binding.setViewmodel(viewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
