package com.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.myapplication.application.*;
import com.myapplication.databinding.ActivityLoginLayoutBinding;
import com.myapplication.viewModel.LoginViewModel;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Adminidtrator on 2017/10/23.
 */

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginLayoutBinding binding;
    public static final String EXTRA_KEY_NEWS_ID = "key_news_id";
    private RefWatcher refWatcher;
    private LoginViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long id = getIntent().getLongExtra(EXTRA_KEY_NEWS_ID, -1);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login_layout);
        viewModel = new LoginViewModel(this,id);
        binding.setViewModel(viewModel);
//        binding.setVariable(com.myapplication.BR.viewModel,new LoginViewModel(this,id));
        refWatcher = com.myapplication.application.MyApplication.getRefWatcher(this);
        refWatcher.watch(this);
    }

    @Override
    protected void onDestroy() {
//        viewModel.destoryAdapter();
        binding=null;
        viewModel.onDestory();

        super.onDestroy();

    }
}
