package com.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.myapplication.application.*;
import com.myapplication.databinding.ActivityLoginLayoutBinding;
import com.myapplication.viewModel.LoginViewModel;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Adminidtrator on 2017/10/23.
 */

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginLayoutBinding binding;
    public static final String EXTRA_KEY_NEWS_ID = "key_news_id";
    private RefWatcher refWatcher;
    private LoginViewModel viewModel;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long id = getIntent().getLongExtra(EXTRA_KEY_NEWS_ID, -1);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login_layout);
        viewModel = new LoginViewModel(this,id);
        binding.setViewModel(viewModel);

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            Log.d("LoginActivity","CREAM");
        }else {
            requestPermissions(new String[]{Manifest.permission.CAMERA},202);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.d("TAG",""+Build.VERSION.SDK_INT);
            checkSelfPermission(Manifest.permission.READ_PHONE_STATE);
        }
    }

    @Override
    protected void onDestroy() {
        binding=null;
        viewModel.onDestory();

        super.onDestroy();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
