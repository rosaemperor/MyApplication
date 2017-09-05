package com.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapplication.R;
import com.myapplication.databinding.DoubleChildRecycleBinding;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30.
 */

public class RecycleFatherAdapter extends RecyclerView.Adapter<RecycleFatherAdapter.MyViewHolder>{
   private Context context;
    private List<String> data;

    public RecycleFatherAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecycleFatherAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder= new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.double_child_recycle, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecycleFatherAdapter.MyViewHolder holder, int position) {
        final DoubleChildRecycleBinding binding= DataBindingUtil.bind(holder.itemView.getRootView());
        binding.text.setText(data.get(position));
        binding.text.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if(binding.child.getVisibility()== View.VISIBLE){
                           binding.child.setVisibility(View.GONE);
                       }else {
                           binding.child.setVisibility(View.VISIBLE);
                       }
                   }
               });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
            recyclerView= (RecyclerView) itemView.findViewById(R.id.child);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new RecycleChildAdapter(context,data));
        }
    }
}
