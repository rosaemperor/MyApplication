package com.myapplication.command;

import android.view.View;
import android.widget.Toast;

import com.myapplication.viewModel.ImageItemViewModel;

/**
 * Created by administrator on 2017/11/22.
 */

public class ImageItemCommand {
    private ImageItemViewModel viewModel;
    private int position;
    public ImageItemCommand(ImageItemViewModel imageItemViewModel, int position) {
        this.viewModel= imageItemViewModel;
        this.position = position;
    }
    //recycleView的item点击事件
    public void itemClickListener(View view){
        Toast.makeText(view.getContext(),""+position,Toast.LENGTH_LONG).show();
    }
}
