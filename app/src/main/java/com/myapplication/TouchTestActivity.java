package com.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.myapplication.databinding.ActivityOntouchLayoutBinding;
import com.myapplication.view.LoadingDialog;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by Administrator on 2017/8/21.
 */

public class TouchTestActivity extends AutoLayoutActivity implements View.OnClickListener{
    private ActivityOntouchLayoutBinding binding;
    private long firstTime;
    private long secondTime;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(TouchTestActivity.this,R.layout.activity_ontouch_layout);
        binding.setEvent(this);
        LoadingDialog dialog= new LoadingDialog(TouchTestActivity.this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.onTouchTest:
                Log.d("AAA","测试");
                break;
            default:
                break;
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction()==MotionEvent.ACTION_UP){

                if(System.currentTimeMillis()-firstTime>1000){
                    firstTime=System.currentTimeMillis();
                    return super.dispatchTouchEvent(ev);
                }else{
                    Log.d("AAA","太快了"+ev.getAction());
                    return true;
                }

        }
        return super.dispatchTouchEvent(ev);

    }



}
