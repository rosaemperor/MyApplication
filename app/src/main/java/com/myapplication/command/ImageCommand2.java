package com.myapplication.command;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapplication.base.BaseCommand;

/**
 * Created by administrator on 2017/12/18.
 */

public class ImageCommand2 extends BaseCommand{
    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(),"ImageCommand2",Toast.LENGTH_LONG).show();
        Log.d("fab",""+fab(4));
    }
    private int fab(int index){
        if(index ==1 || index ==0){
            return 1;
        }else {
           return index*fab(index-1);
        }
    }
}
