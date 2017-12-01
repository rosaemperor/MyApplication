package com.myapplication.utils

/**
 * Created by administrator on 2017/12/1.
 */
object NdkUtilsForKotlin{
    init {
        System.loadLibrary("ndktest")
    }
    external fun helloWorld()  :String

    external fun daozhuanString() :String
}