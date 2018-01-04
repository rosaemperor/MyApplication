package com.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.myapplication.adapter.RecycleFatherAdapter;
import com.myapplication.databinding.LayoutDoubleRecycleviewBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/8/30.
 */

public class DoubleRecycleViewActivity extends AppCompatActivity{
    private LayoutDoubleRecycleviewBinding binding;
    private RecycleFatherAdapter fatherAdapter;
    private List<String> data=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(DoubleRecycleViewActivity.this,R.layout.layout_double_recycleview);
        LinearLayoutManager layoutManager= new LinearLayoutManager(DoubleRecycleViewActivity.this);
        binding.recycleFarther.setLayoutManager(layoutManager);

        for(int i = 'A'; i < 'G'; i++){
            data.add(""+(char)i);
        }
        fatherAdapter=new RecycleFatherAdapter(this,data);
        binding.recycleFarther.setAdapter(fatherAdapter);
        binding.recycleFarther.setItemAnimator(new DefaultItemAnimator());
    }
}
