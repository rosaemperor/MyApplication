package com.myapplication.activity

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.myapplication.MainActivity
import com.myapplication.R
import com.myapplication.RXAndroidTestActivity
import com.myapplication.bean.LoginBean
import com.myapplication.databinding.AcitivityKotlinLayoutBinding
import com.myapplication.databinding.RxAndroidTestBinding
import com.zhy.autolayout.AutoLayoutActivity
import com.zhy.autolayout.utils.ScreenUtils

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
        binding.background.layoutParams = FrameLayout.LayoutParams(binding.background.width,binding.background.height+ScreenUtils.getStatusBarHeight(this@KotlinActivity))
        binding.background.isDrawingCacheEnabled = true
//       var  bitmap  : Bitmap = binding.background.drawingCache
//        bitmap = bitmap.copy(bitmap.config,true)
//        binding.background.isDrawingCacheEnabled = false
//        Log.d("","${bitmap.height}")
        Log.d("TAG","www.baidu.com")
        list= ArrayList()
        var loginBean  = LoginBean()
        list.add(loginBean)
        loginBean.area="我"
        Log.d("AAA",""+loginBean.area)
    }
}