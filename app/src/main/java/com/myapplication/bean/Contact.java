package com.myapplication.bean;

/**
 * Created by pc on 2017/6/19.
 */

public class Contact {
    String name ;
    String mobile ;
    public Contact(){}
    public Contact(String name , String mobile){
        this.name = name ;
        this.mobile = mobile ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString(){
        return name+":"+mobile ;
    }
}
