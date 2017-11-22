package com.myapplication.viewModel;

import android.content.Context;

import com.myapplication.command.ImageItemCommand;

/**
 * Created by administrator on 2017/11/22.
 */

public class ImageItemViewModel {
    public ImageItemCommand command;
    private Context context;
    private int position;

    public ImageItemViewModel(Context context, int position) {
        this.context=context;
        this.position=position;
        init();
    }

    private void init() {
        command = new ImageItemCommand(this,position);
    }
}
