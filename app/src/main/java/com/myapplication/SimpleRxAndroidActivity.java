package com.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.myapplication.adapter.TabLayoutPagerAdapter;
import com.myapplication.databinding.RxSimpleTestBinding;
import com.myapplication.fragment.MyFragment;
import com.myapplication.viewModel.RxAndroidSimpleViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminidtrator on 2017/9/3.
 */

public class SimpleRxAndroidActivity extends AppCompatActivity{
    private RxSimpleTestBinding binding;
    private RxAndroidSimpleViewModel viewModel;
    float Dx = 0;
    float Dy = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.rx_simple_test);
        viewModel= new RxAndroidSimpleViewModel(this,binding);
        List<Fragment> list = new ArrayList<>();
        list.add(new MyFragment());
        list.add(new MyFragment());
        list.add(new MyFragment());
        binding.viewpager.setAdapter(new TabLayoutPagerAdapter(getSupportFragmentManager(),SimpleRxAndroidActivity.this,list));
        binding.tablayout.setupWithViewPager(binding.viewpager);
        binding.tablayout.setTabMode(TabLayout.MODE_FIXED);
        TabLayout.Tab tab= binding.tablayout.getTabAt(0);
        TextView textView=new TextView(SimpleRxAndroidActivity.this);
        textView.setText("测试");
        tab.setCustomView(textView);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        float x=ev.getX();
//        float y= ev.getY();
//
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Dx= ev.getX();
//                Dy= ev.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
////                Log.d("AAA","X:"+x+"Y:"+y);
//                break;
//            case MotionEvent.ACTION_UP:
//                double s=Math.abs( Math.sqrt(Math.pow(x-Dx,2)+Math.pow(y-Dy,2)));
//                Log.d("ACTION_UP","距离："+px2dip(s)/28.346+"厘米");
//                break;
//        }
//        return super.dispatchTouchEvent(ev);
//    }
    public int px2dip(Double pxValue) {
        final float scale =getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
