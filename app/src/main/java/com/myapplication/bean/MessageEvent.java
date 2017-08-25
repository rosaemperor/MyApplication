package com.myapplication.bean;

/**
 * Created by Administrator on 2017/8/24.
 */

public class MessageEvent {
    private String message;
    public MessageEvent(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
