package com.myapplication;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.FitWindowsLinearLayout;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.myapplication.adapter.TabLayoutPagerAdapter;
import com.myapplication.databinding.RxSimpleTestBinding;
import com.myapplication.fragment.MyFragment;
import com.myapplication.viewModel.RxAndroidSimpleViewModel;

import java.util.ArrayList;
import java.util.List;

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
        List<Fragment> list = new ArrayList<>();
        list.add(new MyFragment());
        list.add(new MyFragment());
        list.add(new MyFragment());
        binding.viewpager.setAdapter(new TabLayoutPagerAdapter(getSupportFragmentManager(),SimpleRxAndroidActivity.this,list));
        binding.tablayout.setupWithViewPager(binding.viewpager);
        binding.tablayout.setTabMode(TabLayout.MODE_FIXED);
        LinearLayout layout= (LinearLayout) ((ViewGroup)binding.tablayout.getRootView()).getChildAt(0);
        FrameLayout frameLayout= (FrameLayout) layout.getChildAt(1);
        FitWindowsLinearLayout layout1= (FitWindowsLinearLayout) frameLayout.getChildAt(0);
        Log.d("AA",""+layout1.getChildAt(1)+layout1.getChildAt(0));
    }

}
