package com.myapplication.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.ImageFormat;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by administrator on 2018/1/6.
 */

public class PhotoView extends SurfaceView implements SurfaceHolder.Callback{
    private CameraManager manager;
    private SurfaceHolder holder;
    private Handler mainHandler;
    private ImageReader imageReader;
    private Handler childHandler;
    private String cameraID ;
    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PhotoView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public PhotoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        manager=(CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        holder=getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        initCamera();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initCamera() {
        HandlerThread handlerThread = new HandlerThread("Camera2");
        handlerThread.start();
        childHandler =new Handler(handlerThread.getLooper());
        mainHandler = new Handler(Looper.getMainLooper());
        cameraID = CameraCharacteristics.LENS_FACING_FRONT+"";
        imageReader =ImageReader.newInstance(1080,1920, ImageFormat.JPEG,1);
        imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
            @Override
            public void onImageAvailable(ImageReader reader) {

            }
        },mainHandler);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
