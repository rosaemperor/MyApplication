package com.myapplication.viewModel;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapplication.R;

/**
 * Created by Administrator on 2017/8/28.
 */

public class ReginstViewModel implements View.OnClickListener{
    private Context context;
    public ReginstViewModel(Context context){
        this.context=context;
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
        Log.d("AA","reginst");
        Toast.makeText(context,"reginst",Toast.LENGTH_LONG).show();
    }


}
