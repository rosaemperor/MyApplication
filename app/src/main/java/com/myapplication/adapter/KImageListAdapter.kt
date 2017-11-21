package com.myapplication.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myapplication.R
import com.myapplication.databinding.ItemIamgeListBinding

/**
 * Created by administrator on 2017/11/20.
 */
//class KImageListAdapter(private var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    override fun onCreateViewHolder (parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
//        val viewHodler = object : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_iamge_list, null))
//                return viewHodler
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
//       var  itemBinding  = DataBindingUtil.bind<>(holder!!.itemView)
//    }
//
//    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}