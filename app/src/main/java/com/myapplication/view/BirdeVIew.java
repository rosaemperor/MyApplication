package com.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.myapplication.client.BrowserClient;

/**
 * Created by administrator on 2018/1/8.
 */

public class BirdeVIew extends BridgeWebView{
    public BirdeVIew(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }

    public BirdeVIew(Context context, AttributeSet attrs, int defStyle) {
        super(context,attrs,defStyle);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setWebChromeClient(new WebChromeClient());
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true ;
            }
        });
        WebSettings settings = getSettings() ;
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setUserAgentString(settings.getUserAgentString()+" zhuawawa");
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCachePath(getContext().getApplicationContext().getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        setWebViewClient(new BrowserClient(this));
    }

    public BirdeVIew(Context context) {
        this(context,null);
    }
    public void initialze(){


    }

}
