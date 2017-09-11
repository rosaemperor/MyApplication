package com.myapplication.bean;

import android.databinding.BaseObservable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Adminidtrator on 2017/9/11.
 */

public class TestBean extends BaseObservable{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(com.myapplication.BR._all);
    }
}
