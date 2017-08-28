package com.myapplication.bean;

import android.databinding.BaseObservable;

import com.android.databinding.library.baseAdapters.BR;


/**
 * Created by Administrator on 2017/8/25.
 */

public class ReginstMessageBean extends BaseObservable{
    private String username;
    private String password;
    private String phone;
    private String code;
    private String referral="";
    private String terminal="ANDROID";
    private String url_from="xiaoshuidi";

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR._all);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        notifyPropertyChanged(BR._all);
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
        notifyPropertyChanged(BR._all);
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
        notifyPropertyChanged(BR._all);
    }

    public String getUrl_from() {
        return url_from;
    }

    public void setUrl_from(String url_from) {
        this.url_from = url_from;
        notifyPropertyChanged(BR._all);
    }
}
