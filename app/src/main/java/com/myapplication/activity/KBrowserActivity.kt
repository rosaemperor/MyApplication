package com.myapplication.activity

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.myapplication.R
import com.myapplication.databinding.BrowserLayoutBinding

/**
 * Created by administrator on 2018/1/4.
 */
class KBrowserActivity:AppCompatActivity() {
    lateinit var binding :BrowserLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this@KBrowserActivity,R.layout.browser_layout)
    }
}