package com.myapplication.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myapplication.R
import com.myapplication.databinding.AcitivityKotlinLayoutBinding

/**
 * Created by administrator on 2017/11/30.
 */
class KotlinFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =DataBindingUtil.inflate<AcitivityKotlinLayoutBinding>(inflater,R.layout.acitivity_kotlin_layout,container,false).root
        return view
    }
}