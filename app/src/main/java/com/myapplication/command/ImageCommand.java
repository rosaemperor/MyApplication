package com.myapplication.command;

import android.view.View;
import android.widget.Toast;

import com.myapplication.base.BaseCommand;

/**
 * Created by administrator on 2017/12/18.
 */

public class ImageCommand extends BaseCommand{
    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(),"ImageCommand",Toast.LENGTH_LONG).show();
    }
}
