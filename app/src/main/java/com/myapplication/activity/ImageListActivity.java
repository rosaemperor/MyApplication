package com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapplication.R;
import com.myapplication.adapter.ImageListAdapter;
import com.myapplication.databinding.ActivityImageListBinding;
import com.myapplication.utils.RongUntil;
import com.rong360.app.crawler.CrawlerCallBack;
import com.rong360.app.crawler.CrawlerManager;
import com.rong360.app.crawler.CrawlerStatus;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by Administrator on 2017/10/10.
 */

public class ImageListActivity extends AutoLayoutActivity implements View.OnClickListener{
      private ActivityImageListBinding binding;
    private LinearLayoutManager manager;
    private ImageListAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_list);
        binding.setEvent(this);
        manager = new LinearLayoutManager(this);
        binding.imageRecycleView.setLayoutManager(manager);
        adapter = new ImageListAdapter(this);
        binding.imageRecycleView.setAdapter(adapter);
        binding.imageRecycleView.setNestedScrollingEnabled(false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_image:
                Toast.makeText(this, "添加图片" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.rongtest:
                RongUntil rongUntil= new RongUntil(ImageListActivity.this);
                rongUntil.startTaoBao(new CrawlerCallBack() {
                    @Override
                    public void onStatus(CrawlerStatus crawlerStatus) {
                        Log.d("TAG",""+crawlerStatus.status);
                        Log.d("TAG",crawlerStatus.errorcode+"msg"+crawlerStatus.errormsg);
                    }
                });
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
//        LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) binding.imageRecycleView.getLayoutParams();
//        layoutParams.width=adapter.getItemCount()*adapter
//        binding.imageRecycleView.setLayoutParams(layoutParams);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CrawlerManager.getInstance(getApplication()).unregistAllCallBack();
    }
}
