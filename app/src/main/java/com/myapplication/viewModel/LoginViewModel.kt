package com.myapplication.viewModel

import android.app.Activity
import android.content.Context
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

import com.myapplication.BuildConfig
import com.myapplication.LoginActivity
import com.myapplication.R
import com.myapplication.adapter.ImageListAdapter
import com.myapplication.adapter.ListAdapter
import com.myapplication.bean.LoginBean
import com.myapplication.command.LoginCommand
import com.myapplication.http.RetrofitUtils
import com.myapplication.utils.NdkUtils

import java.util.ArrayList

import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Adminidtrator on 2017/10/23.
 */

class LoginViewModel(private var activity: Context?, id: Long) {

    internal var loginBean: LoginBean? = null
    //model
    //    private LoginBean bean;

    /**
     * viewstyle
     * 用来控制view的显示样式
     */
    val viewStyle = ViewStyle()
    //数据
    val ImageUrl = ObservableField<String>()
    val title = ObservableField<String>()

    val bean = ObservableField<LoginBean>()
    val adapter = ObservableField<ListAdapter>()

    val manager = ObservableField<RecyclerView.LayoutManager>()
    val iamgeAdapter = ObservableField<ImageListAdapter>()


    //路由事件
    val command = LoginCommand(this)

    fun destoryAdapter() {
        adapter.set(null)
    }

    inner class ViewStyle {
        val isRefreshing = ObservableBoolean()
        val progressRefreshing = ObservableBoolean()
        val showListView = ObservableInt()
        val backgroundClolr = ObservableInt()
    }


    init {
        loadData(id)
    }

    private fun loadData(id: Long) {
        loginBean = LoginBean()
        loginBean!!.token = NdkUtils.daozhuanString()
        viewStyle.showListView.set(View.GONE)
        manager.set(LinearLayoutManager(activity))
//        iamgeAdapter.set(ImageListAdapter(activity))
        viewStyle.backgroundClolr.set(activity!!.getColor(R.color.colorPrimary))
        if (BuildConfig.DEBUG) {
            loginBean!!.token = "debug"
        } else {
            loginBean!!.token = "release"
        }
        var list = ArrayList<LoginBean>()
        for (i in 0..4) {
            list.add(loginBean!!)
        }
        for(j  in 15 downTo 10){
            Log.d("Kotlin",""+j)
        }
        title.set("title")
        adapter.set(ListAdapter(activity, list))
        bean.set(loginBean)
    }

    fun changeString(tpUser: String) {
        bean.get().token = tpUser
    }

    fun updateUserMeddage() {
        val call = RetrofitUtils.getInstance().help.getLoginString("15936562980", "333333")
        call.enqueue(object : Callback<LoginBean> {
            override fun onResponse(call: Call<LoginBean>, response: Response<LoginBean>) {
                loginBean = response.body()
                Log.d("TAG", "" + loginBean!!.token)

            }

            override fun onFailure(call: Call<LoginBean>, t: Throwable) {

            }
        })
    }


    fun onDestory() {
        adapter.get().destory()
        activity = null
    }

}
