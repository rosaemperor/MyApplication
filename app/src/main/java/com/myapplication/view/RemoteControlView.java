package com.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
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
    private int backgroundColor;
    private boolean visiableCenter;
    private String centerText;
    private int  centerTextSize;
    private int attr;
    private int widthMesureMode;
    private int heightMesureMode;
    private Paint mPaint;
    private Rect mBound;
    private RectF backgoundRectF;
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
                    leftColor = array.getColor(attr,Color.GREEN);
                    break;
                case R.styleable.RemoteControlViewStyle_rightColor:
                    rightColor = array.getColor(attr,Color.GRAY);
                    break;
                case R.styleable.RemoteControlViewStyle_centerColor:
                    centerColor = array.getColor(attr,Color.RED);
                    break;
                case R.styleable.RemoteControlViewStyle_backgroundColor:
                    backgroundColor = array.getColor(attr,Color.GRAY);
                    break;
                case R.styleable.RemoteControlViewStyle_visiCenter:
                    visiableCenter =array.getBoolean(attr,true);
                    break;
                case R.styleable.RemoteControlViewStyle_centerText:
                    centerText = array.getString(attr);
                    break;
                case R.styleable.RemoteControlViewStyle_centerTextSize:
                    centerTextSize = array.getDimensionPixelSize(attr, (int)TypedValue.applyDimension(TypedValue
                            .COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                    break;
            }

        }
        array.recycle();
        mPaint = new Paint();
        mPaint.setTextSize(centerTextSize);
        mBound =new Rect();
        mPaint.getTextBounds(centerText,0,centerText.length(),mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMesureMode = MeasureSpec.getMode(widthMeasureSpec);
        heightMesureMode = MeasureSpec.getMode(heightMeasureSpec);
        if(widthMesureMode == MeasureSpec.EXACTLY){

        }else {
            widthMeasureSpec = mBound.width()*3;
        }
        if(heightMesureMode == MeasureSpec.EXACTLY){

        }else {
            heightMeasureSpec = mBound.height()*3;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(backgroundColor);
        backgoundRectF = new RectF();
        backgoundRectF.left=0;
        backgoundRectF.top=0;
        backgoundRectF.right=getMeasuredWidth();
        backgoundRectF.bottom =getMeasuredHeight();
        canvas.drawRect(backgoundRectF,mPaint);
        mPaint.setColor(leftColor);
        canvas.drawArc(backgoundRectF,0,90,true,mPaint);

    }
}
