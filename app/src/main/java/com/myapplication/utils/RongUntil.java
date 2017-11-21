package com.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.myapplication.BuildConfig;
import com.rong360.app.crawler.CrawlerCallBack;
import com.rong360.app.crawler.CrawlerManager;
import com.rong360.app.crawler.CrawlerStatus;

import java.util.HashMap;

/**
 * Created by administrator on 2017/11/21.
 */

public class RongUntil {
    CrawlerStatus crawlerStatus;
    private Context context;

    public RongUntil(Context context) {
        this.context = context;
        init();


    }

    private void init() {
        crawlerStatus = new CrawlerStatus();
        crawlerStatus.taskid = String.valueOf(System.currentTimeMillis());
        crawlerStatus.appname= "r360loan";
        crawlerStatus.privatekey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBALYMr7C+/WH+LUMver/Be1OSvcdtnTaUsyNb/wSOgojGKZ/hkhktAHUyQPzkMLgTEY3+IAk7dSYYI6XsOv1QAE8WcyRp9MeOvlnDxFT03pNivK64Ig874BDdLtY2mC0Gyisx7ZSGgo5jtJeyiP7DPu/TI9B1fKOpALIuqqRengIrAgMBAAECgYEAqp23JvHIbUeXSgk8hGyj1Y6IeFh96AJy5We52J5rLh5yMlpo31lyvWOszpZaJpoQcMBDbAOiZmJnPoDoRDHvJpr9nNRiqbyLpt9Dl4sN6DHFqNvYXiyshmiZuyjoDm8D9cM1OtgWs6nRF0WUA50Hm99H1GxbhDMEbtgVqQFPgbECQQDhfB/fzXVvLShhYad4gKTOvT8BYQEH6Aw98bzBTO64pQ/TECDnDedvTd3Q+YalE1HEidq0/+fVS8dTDikw1js5AkEAzq/BORfYPBhe1yP1hrbN4cBqDTvtPh1oj4zGa+gi5X+aPP8Lj2kzHM+FSGqByY5IGx1m36SZDkBYLVBHLwdUgwJBAMFqT40SGGG9Qp4FvjnHX5dXDeyI4PF/QsD/0wGclEkejWxmsVKAwrze9h6Da9O9tq338frAaIS188xyoTKbEUECQBiLqM/F9CkW39R+8b6g4QxpVG7j6gXRakR5/Gp+M/67S67ovw+195r5TiPOekFcg1WtBTWUD5UwsQgYm4uLPE8CQQDaMH5m9NDAzEO1jt7n1CvXl9TZfK0fyAno0749SqVXuYtEqJITED2j9D1Vb8+LPXYMXPEorKLGk/iEiOuJaaHq";//必要参数 需要申请传入;
        crawlerStatus.merchant_id = String.valueOf(1000072);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("user_id", "1234566");
        crawlerStatus.hashMap = params;
        Log.d("AAA","init");
        CrawlerManager.getInstance(((Activity)context).getApplication()).setDebug(BuildConfig.DEBUG);
        CrawlerManager.getInstance(((Activity)context).getApplication()).setHost("http://openapi.rong360.com/");

    }
    public void startZhifuBaoBySdk(CrawlerCallBack crawlerCallBack){
        crawlerStatus.appname="alipay";
        CrawlerManager.getInstance(((Activity)context).getApplication()).startCrawlerByType(crawlerCallBack, crawlerStatus);
    }
    public void startTaoBao(CrawlerCallBack crawlerCallBack){
        crawlerStatus.appname="taobao";
        CrawlerManager.getInstance(((Activity)context).getApplication()).startCrawlerByType(crawlerCallBack, crawlerStatus);
    }

    public void startMoible(CrawlerCallBack crawlerCallBack){
        crawlerStatus.appname="mobile";
        CrawlerManager.getInstance(((Activity)context).getApplication()).startCrawlerByType(crawlerCallBack, crawlerStatus);
    }
    public void startEc(CrawlerCallBack crawlerCallBack){
        crawlerStatus.appname="ec";
        CrawlerManager.getInstance(((Activity)context).getApplication()).startCrawlerByType(crawlerCallBack, crawlerStatus);
    }

}
