package com.myapplication.utils;

/**
 * Created by Adminidtrator on 2017/11/8.
 */

public class NdkUtils {
    static {
        System.loadLibrary("ndktest");
    }
    public static native String helloWorld();
}
