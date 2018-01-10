package com.myapplication.client;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

import com.google.gson.Gson;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by administrator on 2018/1/10.
 */

public class BrowserClient extends WVJBWebViewClient{
    private Gson gson;
    private WVJBResponseCallback codeCallback;
    public BrowserClient(final WebView webView) {
        //需要支持JS send 方法时
        super(webView, new WVJBWebViewClient.WVJBHandler() {
            @Override
            public void request(Object data, WVJBResponseCallback callback) {
                //处理代码
                callback.callback("Response for message from ObjC!");
            }
        });
        gson = new Gson();

    }
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                //执行超时
            }
        };
        timer.schedule(tt, 1000 * 10);

    }


    @Override
    public void onPageFinished(WebView view, String url) {
        //加载完成处理代码
        view.loadUrl("javascript:(function() { " +
                "var videos = document.getElementsByTagName('audio');" +
                " for(var i=0;i<videos.length;i++){videos[i].play();}})()");
        super.onPageFinished(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);
    }
    //API大于19
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        networkError(view);
    }
    //API小于19会返回到这里
    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        networkError(view);
    }
    /**
     * 隐藏主页，显示错误页面
     * @param webView
     */
    private void networkError(WebView webView) {
//        ActivityBrowserLayoutBinding binding = DataBindingUtil.findBinding(webView);//可以用findBinding方法获取一个view所在的那个binding
//        binding.mainWebview.setVisibility(View.GONE);
//        binding.llNetworkError.setVisibility(View.VISIBLE);
    }




}
