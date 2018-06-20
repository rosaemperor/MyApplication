package com.myapplication.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.myapplication.application.MyApplication
import com.myapplication.bean.UserBean
import com.tencent.mm.opensdk.modelmsg.SendAuth

/**
 * Created by administrator on 2018/5/28.
 */
class KotlinViewModel : ViewModel() {
    lateinit var liveUser : LiveData<UserBean>

    fun usernameOnclick(){
        Log.d("TAG",""+liveUser.value!!.userName)
    }


    fun requestWX(){
        var request = SendAuth.Req()
        request.scope = "snsapi_userinfo"
        request.state = "diandi_wx_login"
        MyApplication.getInstance().wxApi.sendReq(request)
    }
}