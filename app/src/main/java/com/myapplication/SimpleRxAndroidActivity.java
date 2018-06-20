package com.myapplication;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myapplication.adapter.TabLayoutPagerAdapter;
import com.myapplication.databinding.RxSimpleTestBinding;
import com.myapplication.fragment.MyFragment;
import com.myapplication.viewModel.ChildViewModel;
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
        ChildViewModel childViewModel = ViewModelProviders.of(this).get(ChildViewModel.class);

        binding.setViewmodel(childViewModel);
        childViewModel.getText().set("test String");
//        viewModel= ViewModelProviders.of(this).get(RxAndroidSimpleViewModel.class);
//        viewModel= new RxAndroidSimpleViewModel(this,binding);
        List<Fragment> list = new ArrayList<>();
        list.add(new MyFragment());
        list.add(new MyFragment());
        list.add(new MyFragment());
        binding.viewpager.setAdapter(new TabLayoutPagerAdapter(getSupportFragmentManager(),SimpleRxAndroidActivity.this,list));
        binding.tablayout.setupWithViewPager(binding.viewpager);
        binding.tablayout.setTabMode(TabLayout.MODE_FIXED);
//        TableLayout.LayoutParams layoutParams=binding.tablayout.generateLayoutParams(getBaseContext().obt);

        LinearLayout.LayoutParams layoutParams1= new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams
                .MATCH_PARENT,1);
        TabLayout.Tab tab= binding.tablayout.getTabAt(0);
//        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.layout_tab,null);
        tab.setCustomView(R.layout.layout_tab);
        TabLayout.Tab tab1= binding.tablayout.getTabAt(1);
        TextView textView1=new TextView(SimpleRxAndroidActivity.this);
        textView1.setText("测试1");
        tab1.setCustomView(R.layout.layout_tab);
        TabLayout.Tab tab2= binding.tablayout.getTabAt(2);
        TextView textView2=new TextView(SimpleRxAndroidActivity.this);
        textView2.setText("测试2");
        tab2.setCustomView(R.layout.layout_tab);
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
