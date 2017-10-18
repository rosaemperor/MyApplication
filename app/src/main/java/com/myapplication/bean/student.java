package com.myapplication.bean;

import android.util.Log;

/**
 * Created by Administrator on 2017/10/18.
 */

public class student extends person{
    String student;
    {
        Log.d("AAA","p1");
    }
    static {
        Log.d("AAA","p2");
    }
    public   student(){
        Log.d("AAA","p3");
    }
    public student(String student){
        this.student= student;
        Log.d("AAA","p4");
    }
}
