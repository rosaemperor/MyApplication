package com.myapplication;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myapplication.databinding.RxSimpleTestBinding;
import com.myapplication.viewModel.RxAndroidSimpleViewModel;

/**
 * Created by Adminidtrator on 2017/9/3.
 */

public class SimpleRxAndroidActivity extends AppCompatActivity{
    private RxSimpleTestBinding binding;
    private RxAndroidSimpleViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.rx_simple_test);
        viewModel= new RxAndroidSimpleViewModel(this,binding);
    }

}
