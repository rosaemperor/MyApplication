package com.myapplication.bean;

import android.databinding.BaseObservable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Administrator on 2017/8/28.
 */

public class user extends BaseObservable{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR._all);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR._all);
    }
}
