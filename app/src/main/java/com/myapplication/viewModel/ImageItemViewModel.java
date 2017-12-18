package com.myapplication.viewModel;

import android.content.Context;
import android.view.View;

import com.myapplication.base.BaseCommand;
import com.myapplication.command.ImageCommand;
import com.myapplication.command.ImageItemCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 2017/11/22.
 */

public class ImageItemViewModel {
    public ImageItemCommand command;
    private Context context;
    public List<BaseCommand> itemClick =new ArrayList<>();
    public int position;

    public ImageItemViewModel(Context context, int position) {
        this.context=context;
        this.position=position;
        init();
    }

    private void init() {
        command = new ImageItemCommand(this,position);
        itemClick.add(new ImageCommand());
    }

    public void onItemClick(View view){
        itemClick.get(position).onClick(view);
    }
}
