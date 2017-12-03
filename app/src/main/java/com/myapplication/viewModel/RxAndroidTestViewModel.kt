package com.myapplication.viewModel

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.View.OnClickListener

import com.myapplication.LoginActivity
import com.myapplication.R
import com.myapplication.SimpleRxAndroidActivity
import com.myapplication.databinding.RxAndroidTestBinding

/**
 * Created by Adminidtrator on 2017/9/3.
 */

class RxAndroidTestViewModel(private val context: Context, private val binding: RxAndroidTestBinding) : OnClickListener {

    init {
        onCreate()
    }

    private fun onCreate() {
        binding.event = this
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.simple -> context.startActivity(Intent(context, SimpleRxAndroidActivity::class.java))
            R.id.call -> {
                val intent = Intent()
                intent.setClass(context, LoginActivity::class.java)
                context.startActivity(intent)
            }
            else -> {
            }
        }
    }
}
