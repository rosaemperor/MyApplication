package com.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private ItemIamgeListBinding binding;
    private int itemWidth=100;
    private ObservableInt width= new ObservableInt(itemWidth);
    private List<String> list= new ArrayList<>();
    private ObservableArrayList<String> listString = new ObservableArrayList<>();
    public ImageListAdapter(Context context) {
        this.context = context;
        for(int i=0;i<20;i++){
            listString.add(""+i);
        }
    }

    public int getItemWidth() {
        return itemWidth;
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
         binding = DataBindingUtil.bind(holder.itemView.getRootView());
//        binding.setViewModel(new ImageItemViewModel(this,position,listString.get(position)));
        Log.d("AAA",""+position);
    }

    @Override
    public int getItemCount() {
        return listString.size();
    }
}
