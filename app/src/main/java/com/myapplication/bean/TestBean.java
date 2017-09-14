package com.myapplication.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.myapplication.BR;

/**
 * Created by Adminidtrator on 2017/9/11.
 */

public class TestBean extends BaseObservable{
    private String text;
    private ObservableField<String> obString;
@Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    public ObservableField<String> getObString() {
        return obString;
    }

    public void setObString(ObservableField<String> obString) {
        this.obString = obString;
    }
}
