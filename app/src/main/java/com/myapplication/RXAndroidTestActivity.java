package com.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myapplication.databinding.RxAndroidTestBinding;
import com.myapplication.viewModel.RxAndroidTestViewModel;

/**
 * Created by Adminidtrator on 2017/9/3.
 */

public class RXAndroidTestActivity extends AppCompatActivity{
    private RxAndroidTestBinding binding;
    private RxAndroidTestViewModel viewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.rx_android_test);
        viewModel=new RxAndroidTestViewModel(this,binding);
    }
}
