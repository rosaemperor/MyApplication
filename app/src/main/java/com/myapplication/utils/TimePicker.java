package com.myapplication.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.bigkoo.pickerview.TimePickerView;
import com.myapplication.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/13.
 */

public class TimePicker {
    private Context context;
    private TimePickerView timePickerView;

    private static final TimePicker timePicker = new TimePicker();
    private static TimePicker getTimePickerInstance(Context context){
        return timePicker;
    }
    public void show(){
        timePickerView.show();
    }
    private TimePicker (){
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2013,1,1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2100,12,31);
        timePickerView=new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(date);


            }
        }).setType(new boolean[]{true, true, true, true, true, false})
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确认")//确认按钮文字
                .setContentSize(18)//滚轮文字大小
                .setTitleSize(20)//标题文字大小
                .setTitleText("")//标题文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                .setCancelColor(Color.BLACK)//取消按钮文字颜色
                .setTitleBgColor(Color.WHITE)//标题背景颜色 Night mode
                .setBgColor(ContextCompat.getColor(context, R.color.c_ffffff))//滚轮背景颜色 Night mode
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate,endDate)//起始终止年月日设定
                .setLabel("年","月","日","时","分","秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(false)//是否显示为对话框样式
                .build();
    }
}
