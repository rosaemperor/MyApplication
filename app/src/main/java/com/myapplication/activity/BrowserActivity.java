package com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.myapplication.R;
import com.myapplication.databinding.BrowserLayoutBinding;
import com.myapplication.viewModel.BrowserViewModel;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by administrator on 2017/12/25.
 */

public class BrowserActivity extends AutoLayoutActivity{
    private BrowserLayoutBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.browser_layout);
        binding.setViewModel(new BrowserViewModel(this));
        Uri link = Uri.parse("http://dolldev.lanlingdai.com");
        binding.content.loadUrl(link.toString());
    }
}
