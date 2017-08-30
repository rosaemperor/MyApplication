package com.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30.
 */

public class RecycleChildAdapter extends RecyclerView.Adapter<RecycleChildAdapter.MyViewHolder>{
    private Context context;
    private List<String> data;

    public RecycleChildAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecycleChildAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder childHolder =new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.double_items_recycle, parent,
                false));
        return childHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
