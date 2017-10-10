package com.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.myapplication.R;
import com.myapplication.databinding.ItemIamgeListBinding;

/**
 * Created by Administrator on 2017/10/10.
 */

public class ImageListAdapter  extends RecyclerView.Adapter{
    private Context context;

    public ImageListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_iamge_list, parent,
                false)) {};
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemIamgeListBinding binding = DataBindingUtil.bind(holder.itemView.getRootView());
        binding.text2.setText(position+"");
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
