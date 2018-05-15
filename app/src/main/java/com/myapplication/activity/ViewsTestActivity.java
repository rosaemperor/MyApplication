package com.myapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.myapplication.R;
import com.myapplication.TouchTestActivity;
import com.myapplication.databinding.ActivityViewsTestBinding;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by Administrator on 2017/10/10.
 */

public class ViewsTestActivity  extends AutoLayoutActivity implements View.OnClickListener{
    private ActivityViewsTestBinding binding;
    Intent intent;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.RemoteControlView:
                intent = new Intent();
                intent.setClass(this, TouchTestActivity.class);
                startActivity(intent);
                break;
            case R.id.images_list:
                intent = new Intent();
                intent.setClass(this, ImageListActivity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_views_test);
        binding.setEvent(this);
        binding.RemoteControlView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(ViewsTestActivity.this, ImageListActivity.class);
                startActivity(intent);
            }
        });
    }
}
