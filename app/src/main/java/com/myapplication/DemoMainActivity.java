package com.myapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.myapplication.activity.ContentTransitionActivity;
import com.myapplication.databinding.AutoLayoutTestBinding;
import com.myapplication.databinding.DemoPopLayoutBinding;
import com.myapplication.testweidget.TestPopWindow;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by Administrator on 2017/8/1.
 */

public class DemoMainActivity extends AutoLayoutActivity implements View.OnClickListener{
    private AutoLayoutTestBinding binding;
    private PopupWindow popupWindow;
    private DemoPopLayoutBinding popLayoutBinding;
    private View PopView;
    TestPopWindow popWindow;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        popLayoutBinding=DataBindingUtil.inflate(DemoMainActivity.this.getLayoutInflater(),R.layout.demo_pop_layout,
//                null,false);
        PopView= LayoutInflater.from(DemoMainActivity.this).inflate(R.layout.demo_pop_layout,null);
        popupWindow=new PopupWindow(PopView, RelativeLayout.LayoutParams.MATCH_PARENT,384,true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.popanim);
        binding= DataBindingUtil.setContentView(DemoMainActivity.this,R.layout.auto_layout_test);
        binding.setEvent(this);
        popWindow=new TestPopWindow(DemoMainActivity.this);
        popLayoutBinding= DataBindingUtil.inflate(LayoutInflater.from(DemoMainActivity.this),R.layout.demo_pop_layout,
                null,false);
        popLayoutBinding.setEvent(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView:
//                popupWindow.showAtLocation(v, Gravity.BOTTOM,0,0);
//                popWindow.showAtLocation(binding.getRoot(), Gravity.BOTTOM,0,0);
                Intent intent = new Intent();
                intent.putExtra("AAA","AAA");
                intent.setClass(DemoMainActivity.this, ContentTransitionActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation
                        (DemoMainActivity.this,v,"image");
                ActivityCompat.startActivity(DemoMainActivity.this,intent,optionsCompat.toBundle());
                Snackbar.make(v,"snackbar.test",Snackbar.LENGTH_LONG).setAction("Action",null).show();

                break;
            case R.id.set22222:
                Snackbar.make(v,"this is from the pop",Snackbar.LENGTH_LONG).setAction("Action",null)
                        .show();
//                popWindow.dismiss();
//                onClick(binding.set11111);
                break;
            case R.id.set11111:

                break;
        }
    }
}
