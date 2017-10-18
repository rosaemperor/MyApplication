package com.myapplication.bean;

import android.util.Log;

/**
 * Created by Administrator on 2017/10/18.
 */

public class person {
    String name;
    {
        Log.d("AAA","p1");
    }
    static {
        Log.d("AAA","p2");
    }
    public   person(){
        Log.d("AAA","p3");
    }
    public person(String name){
        this.name= name;
        Log.d("AAA","p4");
    }

}
