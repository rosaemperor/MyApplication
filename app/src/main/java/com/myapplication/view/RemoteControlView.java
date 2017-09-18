package com.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.myapplication.R;

/**
 * Created by Administrator on 2017/9/18.
 */

public class RemoteControlView extends View{
    private int bottomColor;
    private int topColor;
    private int leftColor;
    private int rightColor;
    private int centerColor;
    private int attr;
    public RemoteControlView(Context context) {
        super(context);
    }

    public RemoteControlView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RemoteControlView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获取自定义的样式属性
         */
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.RemoteControlViewStyle,defStyleAttr,0);
        int count= array.getIndexCount();
        for(int i=0;i< count;i++){
            attr = array.getIndex(i);
            switch (attr){
                case R.styleable.RemoteControlViewStyle_bottomColor:
                    bottomColor=array.getColor(attr,Color.GRAY);
                    break;
                case R.styleable.RemoteControlViewStyle_topColor:
                    topColor = array.getColor(attr,Color.GRAY);
                    break;
                case R.styleable.RemoteControlViewStyle_leftColor:
                    leftColor = array.getColor(attr,Color.GRAY);
                    break;

            }

        }
    }


}
