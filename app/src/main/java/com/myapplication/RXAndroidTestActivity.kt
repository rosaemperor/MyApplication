package com.myapplication

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

import com.myapplication.databinding.RxAndroidTestBinding
import com.myapplication.viewModel.RxAndroidTestViewModel

/**
 * Created by Adminidtrator on 2017/9/3.
 */

class RXAndroidTestActivity : AppCompatActivity() {
    private var binding: RxAndroidTestBinding? = null
    private var viewModel: RxAndroidTestViewModel? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 说实话，我也不知道为啥要这么写才行，才能通过XXXX
        //kotlin会默认检查null的情况，如果要使用可能为空的变量 可以使用
        binding = DataBindingUtil.setContentView(this,R.layout.rx_android_test)

            viewModel =RxAndroidTestViewModel(this,binding!! )


    }
}
