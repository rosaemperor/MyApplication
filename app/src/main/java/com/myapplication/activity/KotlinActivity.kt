package com.myapplication.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import com.myapplication.R
import com.myapplication.bean.LoginBean
import com.myapplication.databinding.AcitivityKotlinLayoutBinding
import com.zhy.autolayout.AutoLayoutActivity

/**
 * Created by administrator on 2017/11/20.
 */
class KotlinActivity : AutoLayoutActivity(){
    lateinit var binding : AcitivityKotlinLayoutBinding
    lateinit var list : ArrayList<LoginBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.acitivity_kotlin_layout)
        binding.titleName.setText("Kotlin的textView")
        list= ArrayList()
        var loginBean  = LoginBean()
        list.add(loginBean)
        loginBean.area="我在上海，快来救我"
        Log.d("AAA",""+loginBean.area)
    }
}