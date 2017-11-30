package com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myapplication.R;
import com.myapplication.bean.LoginBean;

import java.util.List;

/**
 * Created by Adminidtrator on 2017/11/2.
 */

public class ListAdapter extends BaseAdapter{
    private Context context;
    private List<LoginBean> list;

    public ListAdapter(Context context, List<LoginBean> list) {
        this.context = context;
        this.list = list;
    }

    public List<LoginBean> getList() {
        return list;
    }

    public void setList(List<LoginBean> list) {
        this.list = list;
    }

    @Override

    public int getCount() {
        return list ==null ? 0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
            if(convertView == null){
                convertView = LayoutInflater.from(context).inflate(R.layout.item_iamge_list,null);
            textView= (TextView) convertView.findViewById(R.id.text2);
                convertView.setTag(textView);
            }else{
                textView = (TextView) convertView.getTag();
            }
            textView.setText(list.get(position).getToken()+position);

        return convertView;
    }

    public void destory() {
        context = null;
        list = null;
    }
}
