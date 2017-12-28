package com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.myapplication.R;
import com.myapplication.databinding.ActivityLamadaLayoutBinding;
import com.myapplication.viewModel.LamadaViewModel;

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
    }
}
