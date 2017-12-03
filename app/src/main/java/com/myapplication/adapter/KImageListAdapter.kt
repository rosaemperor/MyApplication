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
 * kotlin中八种基本数据类型全部消失，代替的是类似与对应的包装类之类的类
 * Created by administrator on 2017/11/20.
 */
class KImageListAdapter(private var context: Context) : RecyclerView.Adapter<KImageListAdapter.MyViewHodler>() {
    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: MyViewHodler?, position: Int) {
       var binding = DataBindingUtil.bind<ItemIamgeListBinding>(holder!!.itemView.rootView)


    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHodler {
        var holder = MyViewHodler(LayoutInflater.from(context).inflate(R.layout.item_iamge_list,parent))
        return holder
    }


    class MyViewHodler : RecyclerView.ViewHolder {

        constructor(itemView: View?) : super(itemView)

        constructor(itemView: View?,number: Float?) :super(itemView)
    }

}