package com.myapplication.utils

/**
 * Created by administrator on 2017/11/30.
 */
object StringUtil {
    /**
     * 删除字符串中的"-"和""
     */
    fun delete(string : String) :String{
        var result :String =""
        if(string.contains("-")){
            result =string.replace("-","")
        }
        if(string.contains(" ")){
            result = string.replace(" ","")
        }
        return result
    }

    fun delete(countString : String ,deleteString: String) :String{
     return countString.replace(deleteString,"")
    }

}