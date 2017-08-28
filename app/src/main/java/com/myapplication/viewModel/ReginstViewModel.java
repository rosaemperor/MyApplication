package com.myapplication.viewModel;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapplication.R;
import com.myapplication.bean.ReginstMessageBean;

/**
 * Created by Administrator on 2017/8/28.
 */

public class ReginstViewModel implements View.OnClickListener{
    private Context context;
    private ReginstMessageBean message;

    public ReginstMessageBean getMessage() {
        return message;
    }

    public void setMessage(ReginstMessageBean message) {
        this.message = message;
    }

    public ReginstViewModel(Context context){
        this.context=context;
        init();

    }

    private void init() {
        message = new ReginstMessageBean();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.event_send:
                reginst();

                break;
        }
    }

    private void reginst() {
        Log.d("AA","reginst"+message.getPhone());
        Toast.makeText(context,"reginst"+message.getPhone(),Toast.LENGTH_LONG).show();
    }


}
