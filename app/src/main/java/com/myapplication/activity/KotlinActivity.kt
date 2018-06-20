package com.myapplication.activity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.google.gson.Gson
import com.myapplication.MainActivity
import com.myapplication.R
import com.myapplication.RXAndroidTestActivity
import com.myapplication.bean.LoginBean
import com.myapplication.bean.User
import com.myapplication.bean.UserBean
import com.myapplication.databinding.AcitivityKotlinLayoutBinding
import com.myapplication.databinding.RxAndroidTestBinding
import com.myapplication.utils.GsonUtils
import com.myapplication.viewModel.KotlinViewModel
import com.zhy.autolayout.AutoLayoutActivity
import com.zhy.autolayout.utils.ScreenUtils

/**
 * Created by administrator on 2017/11/20.
 */
class KotlinActivity : AutoLayoutActivity(){
    lateinit var binding : AcitivityKotlinLayoutBinding
    lateinit var list : ArrayList<LoginBean>
    var number : Int ?= null
    lateinit var number1 :ArrayList<LoginBean>
    lateinit var viewModel : KotlinViewModel
    lateinit var userData :MutableLiveData<UserBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.acitivity_kotlin_layout)
        binding.titleName.setText("Kotlin的textView")
//        binding.background.layoutParams = FrameLayout.LayoutParams(binding.background.width,binding.background.height+ScreenUtils.getStatusBarHeight(this@KotlinActivity))
//        binding.background.isDrawingCacheEnabled = true
        viewModel = ViewModelProviders.of(this).get(KotlinViewModel::class.java)
       var user = UserBean()
        user.userName = "name"
        user.usersex.set("male")
        var user2 =null
        userData= MutableLiveData()
        userData.value = user
        viewModel.liveUser= userData
        binding.viewModel = viewModel
        Log.d("TAG",""+viewModel.liveUser.value!!.userName)
        user.userName = "username"
//       var  bitmap  : Bitmap = binding.background.drawingCache
//        bitmap = bitmap.copy(bitmap.config,true)

//        binding.background.isDrawingCacheEnabled = false
//        Log.d("","${bitmap.height}")
//        Log.d("TAG","www.baidu.com")
//        Log.d("TAG",""+number1.hashCode())

        list= ArrayList()
        var loginBean  = LoginBean()
        list.add(loginBean)
        loginBean.area="我"
        Log.d("AAA",""+loginBean.area)

    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG","ActivityOnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG","ActivityOnStop")
    }

}