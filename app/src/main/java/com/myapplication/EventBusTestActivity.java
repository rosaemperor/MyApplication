package com.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.myapplication.Interface.APIHelp;
import com.myapplication.activity.LamadaActivity;
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
        Glide.with(this).load("http://img.blog.csdn.net/20150422171814059?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYmlyZHNhY3Rpb24=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast").into(binding.imageView);
        binding.simpDraweeView .setImageURI("https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=c226cae3d933c895b2739029b07a1895/d52a2834349b033b96b741ae15ce36d3d539bd83.jpg");
        client=new OkHttpClient.Builder().
                build();
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
            case R.id.load:
                binding.simpDraweeView.setImageURI(binding.url.getText().toString());
                break;
            case R.id.retrofit_test:
                Call<LoginBean> string=apiHelp.getLoginString("15936562980","222222");
                string.enqueue(new Callback<LoginBean>() {
                    @Override
                    public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {

                            String aaa=response.body().getOperate_mode();
                        SharedPreferences sharedPreferences=getSharedPreferences(shareName,MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                    }
                    @Override
                    public void onFailure(Call<LoginBean> call, Throwable t) {
                      Log.d("onFailure",""+t.toString());
                    }
                });
                break;
            case R.id.simpDraweeView:
                Log.d("simpDraweeView","simpDraweeView");
                ActivityOptions options =ActivityOptions.makeSceneTransitionAnimation(this,
                        v,"share_iamge");
                 Intent intent1= new Intent(this, LamadaActivity.class);
                startActivity(intent1,options.toBundle());
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
