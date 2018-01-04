package com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.myapplication.R;
import com.myapplication.adapter.TaoAdapter;
import com.myapplication.databinding.ActivityLamadaLayoutBinding;
import com.myapplication.viewModel.LamadaViewModel;
import com.myapplication.viewModel.TaoChildViewModel;
import com.myapplication.viewModel.TaoViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 2017/12/27.
 */

public class LamadaActivity extends AppCompatActivity{
    private ActivityLamadaLayoutBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_lamada_layout);
        binding.setViewModel(new LamadaViewModel());

        List<TaoViewModel> list = new ArrayList<>();
        for(int i=0;i<15;i++){
            List<TaoChildViewModel> childViewModels = new ArrayList<>();
            for(int j=0;j<15;j++){
                childViewModels.add(new TaoChildViewModel());
            }
            list.add(new TaoViewModel(this,childViewModels));
        }
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleView.setAdapter(new TaoAdapter(LamadaActivity.this,list));
    }
}
