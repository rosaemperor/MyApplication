package com.myapplication

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast

import com.myapplication.bean.MessageEvent
import com.myapplication.databinding.LayoutEventbusSendBinding
import com.myapplication.utils.StringUtil

import org.greenrobot.eventbus.EventBus

/**
 * Created by Administrator on 2017/8/24.
 */

class EventBusSendActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: LayoutEventbusSendBinding
    lateinit var list:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@EventBusSendActivity, R.layout.layout_eventbus_send)
        binding.event = this
        binding.event
        for (i in 0..9) {
            when (i) {
                1 -> {
                }
                2 ->{
                    Toast.makeText(this@EventBusSendActivity,"AAAAA",Toast.LENGTH_LONG)
                }
                else -> {
                }
            }
        }
        for(i in 9 downTo 0){

        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.event_send -> {
                list.forEach {i->
                    Log.d("TAG",i)
                }
                Toast.makeText(this@EventBusSendActivity,"",Toast.LENGTH_SHORT).show()
                EventBus.getDefault().post(MessageEvent(binding.eventEditText.text.toString()))
                finish()
            }
            else -> {
            }
        }
    }
}
