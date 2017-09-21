package com.myapplication.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.myapplication.Interface.OnClickRemoteConterView;
import com.myapplication.R;

/**
 * Created by Administrator on 2017/9/18.
 */

public class RemoteControlView extends View{
    private int bottomColor;
    private ColorStateList bottomColorList=ColorStateList.valueOf(Color.GRAY);
    private int topColor;
    private int leftColor;
    private int rightColor ;
    private int centerColor=Color.GREEN;
    private int centerCurrentClolr=centerColor;
    private int bottomCurrentColor;
    private int backgroundColor=Color.BLACK;
    private boolean visiableCenter;
    private String centerText="ok";
    private int  centerTextSize;
    private int attr;
    private int widthMesureMode;
    private int heightMesureMode;
    private Drawable centerBackGround;
    private String bottomText="alan";
    private Rect bottomTextBounds;
    private Paint mPaint,topPaint,rightPaint,bottomPaint;
    private Rect mBound;
    private RectF backgoundRectF;
    private Paint centerPaint;
    public OnClickRemoteConterView getmListener() {
        return mListener;
    }

    public void setmListener(OnClickRemoteConterView mListener) {
        this.mListener = mListener;
    }

    private RectF bottomRectF;
    private float x;
    private float y;
    private String downEventName,upEventName,moveName;
    private OnClickRemoteConterView mListener;
    public RemoteControlView(Context context) {
        this(context,null);
    }

    public RemoteControlView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RemoteControlView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获取自定义的样式属性
         */
        this.setClickable(true);
        rightColor = ContextCompat.getColor(context,R.color.c_AFAFAF);
        leftColor = ContextCompat.getColor(context,R.color.c_AFAFAF);
        topColor =  ContextCompat.getColor(context,R.color.c_AFAFAF);
        bottomColor =  ContextCompat.getColor(context,R.color.c_AFAFAF);
        bottomCurrentColor = bottomColor;
        backgroundColor = ContextCompat.getColor(context,R.color.c_ffffff);
        centerTextSize=(int)TypedValue.applyDimension(TypedValue
                        .COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics());
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.RemoteControlViewStyle,defStyleAttr,0);
        int count= array.getIndexCount();
        for(int i=0;i< count;i++){
            attr = array.getIndex(i);
            switch (attr){
                case R.styleable.RemoteControlViewStyle_bottomColor:
                    bottomColorList=array.getColorStateList(attr);
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
                case R.styleable.RemoteControlViewStyle_centerBackGround:
                    centerBackGround = array.getDrawable(attr);
                    break;

            }

        }
        array.recycle();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        centerPaint = new Paint();
        centerPaint.setAntiAlias(true);
        centerPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setTextSize(centerTextSize);
        mBound =new Rect();
        mPaint.getTextBounds(centerText,0,centerText.length(),mBound);
        bottomTextBounds = new Rect();
        mPaint.getTextBounds(bottomText,0,bottomText.length(),bottomTextBounds);
        topPaint= new Paint();
        topPaint.setStyle(Paint.Style.STROKE);
        topPaint.setColor(topColor);
        rightPaint= new Paint();
        rightPaint.setStyle(Paint.Style.STROKE);
        rightPaint.setColor(topColor);
        bottomPaint= new Paint();
        bottomPaint.setStyle(Paint.Style.FILL);

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
        backgoundRectF.bottom =getMeasuredWidth();
        canvas.drawRect(backgoundRectF,mPaint);
        bottomPaint.setColor(bottomColor);
        canvas.drawArc(backgoundRectF,45,90,true,bottomPaint);
        mPaint.setColor(Color.WHITE);
        canvas.drawText(bottomText,backgoundRectF.centerX()-bottomTextBounds.width()/2, (float) (backgoundRectF.height()
                /2+backgoundRectF.height()
                /2*0.75)+bottomTextBounds.height()/2,mPaint);
        mPaint.setColor(leftColor);
        canvas.drawArc(backgoundRectF,135,90,true,mPaint);

        canvas.drawArc(backgoundRectF,225,90,true,topPaint);

        canvas.drawArc(backgoundRectF,315,90,true,rightPaint);
        centerPaint.setColor(centerColor);
        canvas.drawCircle(backgoundRectF.centerX(),backgoundRectF.centerY(),backgoundRectF.height()/4,centerPaint);
        mPaint.setColor(leftColor);
        mPaint.setTextSize(centerTextSize);
        canvas.drawText(centerText,backgoundRectF.centerX()-mBound.width()/2,backgoundRectF.centerY()+mBound.height()
                /2,mPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=event.getX();
        y=event.getY();
        Log.d("AAA","x值："+x+"Y值："+y+"/"+event.getAction());
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
               downEventName= inCircleLocation(x,y);
                switch (inCircleLocation(x,y)){
                    case "inCenter":
                        centerColor =ContextCompat.getColor(getContext(),R.color.colorAccent);
                        invalidate();
                        break;
                    case "inBottom":
                        bottomColor = ContextCompat.getColor(getContext(),R.color.colorAccent);
                        invalidate();
                        break;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_BUTTON_PRESS:
                Log.d("AA","ACTION_BUTTON_PRESS");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("AA","ACTION_CANCEL");
                 centerColor=centerCurrentClolr;
                bottomColor =bottomCurrentColor;
                invalidate();
                break;
            case MotionEvent.ACTION_POINTER_UP:
                Log.d("AA","ACTION_POINTER_UP");
                break;
            case MotionEvent.ACTION_UP:
                upEventName = inCircleLocation(x,y);
                Log.d("AA","ACTION_UP"+upEventName);
                if(downEventName.equals(upEventName)){

                   switch (upEventName){
                       case "inCenter":
                           centerColor = centerCurrentClolr;
                           invalidate();
                           if(null !=mListener){
                               mListener.onCenterClickListener();
                           }
                           break;
                       case "inBottom":
                           centerColor = centerCurrentClolr;
                           bottomColor = bottomCurrentColor;
                           invalidate();
                           if(null !=mListener){
                               mListener.onBottomClickListener();
                           }
                           break;
                       case "inRight":
                           if(null !=mListener){
                               mListener.onRightClickListener();
                           }
                           break;
                       case "inTop":
                           if(null !=mListener){
                               mListener.onTopClickListener();
                           }
                           break;
                       case "inLeft":
                           if(null !=mListener){
                               mListener.onLeftClickListener();
                           }
                           break;
                       default:
                           break;
                   }
                }
                else {
                    centerColor=centerCurrentClolr;
                    invalidate();
                }
                break;
        }
        return true;
    }

    private String  inCircleLocation(float x, float y) {
        double s=Math.abs( Math.sqrt(Math.pow(x-backgoundRectF.centerX(),2)+Math.pow(y-backgoundRectF.centerY(),2)));
        if(s<backgoundRectF.height()/2){
            if(s<backgoundRectF.height()/4){
                return "inCenter";
            }else {
              int d=(int) (Math.atan2(y-backgoundRectF.centerY(),x-backgoundRectF.centerX())*180/Math.PI);
                if(45<d && d<135){
                    return "inBottom";
                }
                if(d<45 && d>-45){
                    return "inRight";
                }
                if(d<-45 && d>-135){
                    return "inTop";
                }
                if(d<-135 || d>135){
                    return "inLeft";
                }
            }
           return "inSide";
        }else {
            return "outSide";
        }

    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Boolean flag= false;
        int[] states = getDrawableState();
       int newBottomColor = bottomColorList.getColorForState(states,0);
        if(newBottomColor!= bottomColor){
            bottomColor =newBottomColor;
            flag=true;
        }
        if(flag){
            invalidate();
        }
    }
}
