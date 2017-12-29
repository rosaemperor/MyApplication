package com.myapplication.viewModel;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import com.myapplication.adapter.ImageListAdapter;
import com.myapplication.base.BaseCommand;
import com.myapplication.command.ImageCommand;
import com.myapplication.command.ImageCommand2;
import com.myapplication.command.ImageItemCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 2017/11/22.
 */

public class ImageItemViewModel {
    public ImageItemCommand command;
    private ImageListAdapter context;
    public List<BaseCommand> itemClick =new ArrayList<>();
    public ObservableField<String> test=new ObservableField<>();
    public int position;

    public ImageItemViewModel(ImageListAdapter context, int position,String text) {
        this.context=context;
        this.position=position;
        test.set(text);
        init();
    }

    private void init() {
        command = new ImageItemCommand(this,position);
        for(int i= 0 ;i<context.getItemCount();i++){
            if(i%2==0){
                itemClick.add(new ImageCommand2());
            }else {
                itemClick.add(new ImageCommand());
            }

        }


    }

    public void onItemClick(View view){
        itemClick.get(position).onClick(view);
    }
}
