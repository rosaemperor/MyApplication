package com.myapplication.bean;

import android.databinding.ObservableField;

/**
 * Created by Administrator on 2017/8/24.
 */

public class LoginBean {
    private String operate_mode;
    private String token;
    private String ab_user;
    private ObservableField<String> updated_at;

    public ObservableField<String> getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(ObservableField<String> updated_at) {
        this.updated_at = updated_at;
    }

    public String getTp_user() {
        return tp_user;
    }

    public void setTp_user(String tp_user) {
        this.tp_user = tp_user;
    }

    private String tp_user;

    public String getAb_user() {
        return ab_user;
    }

    public void setAb_user(String ab_user) {
        this.ab_user = ab_user;
    }

    public String getOperate_mode() {
        return operate_mode;
    }

    public void setOperate_mode(String operate_mode) {
        this.operate_mode = operate_mode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
