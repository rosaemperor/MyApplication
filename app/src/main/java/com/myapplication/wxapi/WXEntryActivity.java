package com.myapplication.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.myapplication.application.MyApplication;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;


/**
 * Created by administrator on 2017/12/25.
 */

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().getWXApi().handleIntent(getIntent(),this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        SendAuth.Resp resp = (SendAuth.Resp) baseResp;
        if(resp.errCode == 0 && null !=resp.code){
            Log.d("TAG",""+resp.toString());
            finish();
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
