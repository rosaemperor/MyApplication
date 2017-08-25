package com.myapplication.testweidget;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.myapplication.R;
import com.myapplication.databinding.DemoPopLayoutBinding;

/**
 * Created by Administrator on 2017/8/3.
 */

public class TestPopWindow extends PopupWindow{
    private Context context;
    private View baseView;


    public DemoPopLayoutBinding getBinding() {
        return binding;
    }

    private DemoPopLayoutBinding binding;
    public TestPopWindow(Context context){
        this.context=context;
        binding= DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.demo_pop_layout,
               null,false);
        baseView= LayoutInflater.from(context).inflate(R.layout.demo_pop_layout,null);
        this.setContentView(baseView);
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.popanim);
        this.setOutsideTouchable(false);
    }

}
