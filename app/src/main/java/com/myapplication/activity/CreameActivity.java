package com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.myapplication.R;
import com.myapplication.databinding.ActivityCreameLayoutBinding;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by administrator on 2018/4/3.
 */

public class CreameActivity extends AutoLayoutActivity implements SurfaceHolder.Callback{
    private ActivityCreameLayoutBinding binding;
    private Camera mCamera;
    private SurfaceHolder mHodler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(CreameActivity.this, R.layout.activity_creame_layout);
        mHodler =binding.surfaceview.getHolder();
        mHodler.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
