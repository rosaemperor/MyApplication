package com.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.myapplication.bean.MessageEvent;
import com.myapplication.databinding.LayoutEventbusSendBinding;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/8/24.
 */

public class EventBusSendActivity extends AppCompatActivity implements View.OnClickListener{
    private LayoutEventbusSendBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(EventBusSendActivity.this,R.layout.layout_eventbus_send);
        binding.setEvent(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.event_send:
                EventBus.getDefault().post(new MessageEvent(binding.eventEditText.getText().toString()));
                finish();
                break;
            default:
                break;
        }
    }
}
