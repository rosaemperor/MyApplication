package com.myapplication.bean

import android.databinding.ObservableField
import android.util.Log

import com.google.gson.Gson
import com.myapplication.utils.GsonUtils

/**
 * Created by Administrator on 2017/10/18.
 */

open class person {
    internal var name: String=""

    init {
        Log.d("AAA", "p1")
    }

    constructor() {
        Log.d("AAA", "p3")
    }

    constructor(name: String) {
        this.name = name
        Log.d("AAA", "p4")
        val gson = Gson()
        gson.fromJson("", User::class.java)
//        ObservableField(GsonUtils.getGson().fromJson("", User::class.java))
    }

    companion object {
        init {
            Log.d("AAA", "p2")
        }
    }

}
