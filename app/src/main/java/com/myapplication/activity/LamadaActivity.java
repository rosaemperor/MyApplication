package com.myapplication.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.myapplication.R;
import com.myapplication.adapter.ForecastsAdapter;
import com.myapplication.adapter.TaoAdapter;
import com.myapplication.adapter.TaoChildAdapter;
import com.myapplication.databinding.ActivityLamadaLayoutBinding;
import com.myapplication.viewModel.LamadaViewModel;
import com.myapplication.viewModel.TaoChildViewModel;
import com.myapplication.viewModel.TaoViewModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 2017/12/27.
 */

public class LamadaActivity extends AppCompatActivity{
    private ActivityLamadaLayoutBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_lamada_layout);
        binding.setViewModel(new LamadaViewModel());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        List<TaoViewModel> list = new ArrayList<>();
        for(int i=0;i<15;i++){
            List<TaoChildViewModel> childViewModels = new ArrayList<>();
            for(int j=0;j<15;j++){
                childViewModels.add(new TaoChildViewModel());
            }
            TaoViewModel viewModel =ViewModelProviders.of(this).get(TaoViewModel.class);
            viewModel.setManager(manager);
            TaoChildAdapter childAdapter = new TaoChildAdapter(this,childViewModels);
            viewModel.setRadapter(childAdapter);
            list.add(viewModel);
//            list.add(new TaoViewModel(this,childViewModels));
        }
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleView.setAdapter(new TaoAdapter(LamadaActivity.this,list));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        TaoChildViewModel model = new TaoChildViewModel();
        model.setContent(new ObservableField<String>("王老弟测试"));
        ObservableInt age = new ObservableInt(34234);
        Gson gson= new Gson();
        JsonParser jsonParser = new JsonParser();
        String json = "";
        Log.d("TAG",""+jsonParser.parse(gson.toJson(model)));
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson myadapter=gsonBuilder.registerTypeAdapter(Object.class,new ForecastsAdapter()).create();
        myadapter.fromJson(gson.toJson(model),TaoChildViewModel.class);
        return true;
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if(isInPictureInPictureMode){
            Toast.makeText(this, "请隐藏所有不要小窗口显示的UI", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "全凭窗口恢复UI显示", Toast.LENGTH_SHORT).show();
        }
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }
}
