package com.myapplication.bean

import android.databinding.BaseObservable
import android.databinding.ObservableField
import io.reactivex.Observable

/**
 * Created by administrator on 2018/5/28.
 */
class UserBean  {
    var usersex = ObservableField<String> ()
    var userName: String = String()
    var userAge : Int =0


}