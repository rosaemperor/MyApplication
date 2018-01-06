package com.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapplication.R;
import com.myapplication.databinding.ItemIamgeListBinding;
import com.myapplication.databinding.TaoLayoutBinding;
import com.myapplication.viewModel.TaoViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 2017/12/29.
 */

public class TaoAdapter extends RecyclerView.Adapter{
    List<TaoViewModel> viewModels;
    Context context;


    public TaoAdapter(Context context, List<TaoViewModel> list){
        this.context= context;
        this.viewModels= list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(LayoutInflater.from(
                context).inflate(R.layout.tao_layout, parent,
                false)) {};

        return viewHolder;
    }

    /**
     * 不要在这里初始化数据，切记切记
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         TaoLayoutBinding binding = DataBindingUtil.bind(holder.itemView.getRootView());
         binding.setViewModel(viewModels.get(position));


    }

    @Override
    public int getItemCount() {
        return 15;
    }
}
