package com.myapplication;

import android.Manifest;
import android.app.Application;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.ArrayList;
import java.util.List;

import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;
import me.weyye.hipermission.PermissionItem;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/8/1.
 */

public class MyApplication extends Application {
    List<PermissionItem> permissionItems = new ArrayList<PermissionItem>();
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        initFresco();

        checkPermissionApplication();
    }

    private void initFresco() {
        OkHttpClient httpClient= new OkHttpClient();
        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory
                .newBuilder(this,httpClient)
                .build();
        Fresco.initialize(this,config);

    }

    private void checkPermissionApplication() {
        permissionItems.add(new PermissionItem(Manifest.permission.CAMERA,"相机",R.mipmap.ic_launcher));
        permissionItems.add(new PermissionItem(Manifest.permission.CALL_PHONE,"打电话",R.mipmap.ic_launcher));
        HiPermission.create(this).title("权限")
                .permissions(permissionItems)
                .filterColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()))//permission icon color
                .msg("To protect the peace of the world, open these permissions! You and I together save the world!")
                .checkMutiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {
                        Log.d("AAA","onClose");
                        System.exit(0);
                    }

                    /**
                     * 所有权限申请完成后调用onFinish
                     */
                    @Override
                    public void onFinish() {
                        Log.d("AAA","onFinish");

                    }

                    @Override
                    public void onDeny(String permission, int position) {
                        Log.d("AAA","onDeny");
                    }

                    @Override
                    public void onGuarantee(String permission, int position) {
                        Log.d("AAA","onGuarantee");
                    }
                });
    }
}
