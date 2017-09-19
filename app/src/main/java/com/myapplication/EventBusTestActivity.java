package com.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.myapplication.Interface.APIHelp;
import com.myapplication.bean.LoginBean;
import com.myapplication.bean.MessageEvent;
import com.myapplication.databinding.LayoutEventbusActivityBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/8/24.
 */

public class EventBusTestActivity extends AppCompatActivity implements View.OnClickListener{
    private LayoutEventbusActivityBinding binding;
    private APIHelp apiHelp;
    private OkHttpClient client;
    private static String shareName="shareName";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(EventBusTestActivity.this,R.layout.layout_eventbus_activity);
        binding.setEvent(this);
        EventBus.getDefault().register(this);
        Glide.with(this).load("http://img.blog.csdn.net/20151014174714655").into(binding.imageView);
        binding.simpDraweeView .setImageURI("http://img.blog.csdn.net/20151014174714655");
        client=new OkHttpClient.Builder().
//                addInterceptor(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//                okhttp3.Response response=chain.proceed(chain.request());
//                Log.e("AAB",""+response.code()+response.body().string());
//                return response;
//            }
//        }).
                build();
//        client=new OkHttpClient();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl( "http://api.ih2ome.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiHelp=retrofit.create(APIHelp.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.event_test:
                Intent intent=new Intent();
                intent.setClass(EventBusTestActivity.this,EventBusSendActivity.class);
                startActivity(intent);
                break;
            case R.id.retrofit_test:
                Call<LoginBean> string=apiHelp.getLoginString("15936562980","222222");
                string.enqueue(new Callback<LoginBean>() {
                    @Override
                    public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                        Log.d("AAA",""+response.code()+response.body().getOperate_mode());
                            String aaa=response.body().getOperate_mode();
                        SharedPreferences sharedPreferences=getSharedPreferences(shareName,MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Token",""+response.body().getToken());
                    }
                    @Override
                    public void onFailure(Call<LoginBean> call, Throwable t) {
                      Log.d("onFailure",""+t.toString());
                    }
                });
                break;
            default:break;

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getMessage(MessageEvent message){
        binding.getEvent.setText(message.getMessage());
    }
}
