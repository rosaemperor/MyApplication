package com.myapplication.application;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.myapplication.R;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
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
    private RefWatcher refWatcher;
    List<PermissionItem> permissionItems = new ArrayList<PermissionItem>();
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        initFresco();
//        installLeakCanary();
        checkPermissionApplication();
    }
    private void installLeakCanary() {
        refWatcher = LeakCanary.install(this);
    }
    private void initFresco() {
        OkHttpClient httpClient= new OkHttpClient();
        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory
                .newBuilder(this,httpClient)
                .build();
        Fresco.initialize(this,config);

    }

    private void checkPermissionApplication() {
        permissionItems.add(new PermissionItem(Manifest.permission.READ_CONTACTS));
        permissionItems.add(new PermissionItem(Manifest.permission.READ_PHONE_STATE));
        permissionItems.add(new PermissionItem(Manifest.permission.CAMERA));
        permissionItems.add(new PermissionItem(Manifest.permission.CALL_PHONE));
        permissionItems.add(new PermissionItem(Manifest.permission.ACCESS_FINE_LOCATION));
        permissionItems.add(new PermissionItem(Manifest.permission.ACCESS_COARSE_LOCATION));
        permissionItems.add(new PermissionItem(Manifest.permission.READ_CONTACTS));
        permissionItems.add(new PermissionItem(Manifest.permission.READ_CALL_LOG));
        permissionItems.add(new PermissionItem(Manifest.permission.READ_SMS));
        HiPermission.create(this).title("权限")
                .permissions(permissionItems)
                .filterColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()))//permission icon color
                .msg("To protect the peace of the world, open these permissions! You and I together save the world!")
                .checkMutiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {
//                        Log.d("AAA","onClose");
                        System.exit(0);
                    }

                    /**
                     * 所有权限申请完成后调用onFinish
                     */
                    @Override
                    public void onFinish() {
//                        Log.d("AAA","onFinish");

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
    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }
   @Override
    public String getPackageName() {

//        return "com.rong360.app.crawler";
       return super.getPackageName();
   }
}
