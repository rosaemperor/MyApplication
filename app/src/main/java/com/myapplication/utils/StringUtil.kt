package com.myapplication.utils

/**
 * Created by administrator on 2017/11/30.
 */
object StringUtil {
    /**
     * 删除字符串中的"-"和""
     */
    fun delete(string : String){
        var result :String
        if(string.contains("-")){
            result =string.replace("-","")
        }
        if(string.contains(" ")){
            result = string.replace(" ","")
        }
    }
}