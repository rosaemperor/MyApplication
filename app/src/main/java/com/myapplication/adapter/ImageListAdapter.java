package com.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.myapplication.R;
import com.myapplication.base.BaseCommand;
import com.myapplication.databinding.ItemIamgeListBinding;
import com.myapplication.viewModel.ImageItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */

public class ImageListAdapter  extends RecyclerView.Adapter{
    private Context context;
    private int itemWidth=100;
    private ObservableInt width= new ObservableInt(itemWidth);

    private ItemIamgeListBinding binding;
    public ImageListAdapter(Context context) {
        this.context = context;
    }

    public int getItemWidth() {
        return itemWidth;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_iamge_list, parent,
                false)) {};
        itemWidth=viewHolder.itemView.getWidth();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        binding = DataBindingUtil.bind(holder.itemView.getRootView());
        binding.setViewModel(new ImageItemViewModel(this,position));
//        Log.d("AAA",""+width);
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
