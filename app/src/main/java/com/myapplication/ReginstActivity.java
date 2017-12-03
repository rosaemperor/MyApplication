package com.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapplication.Interface.APIHelp;
import com.myapplication.bean.LoginBean;
import com.myapplication.bean.ReginstMessageBean;
import com.myapplication.databinding.LayoutReginstActivityBinding;
import com.myapplication.http.RetrofitUtils;
import com.myapplication.utils.BannerImageLoader;
import com.myapplication.viewModel.ReginstViewModel;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



/**
 * Created by Administrator on 2017/8/25.
 */

public class ReginstActivity extends AppCompatActivity implements View.OnClickListener{
    private LayoutReginstActivityBinding binding;
    private ReginstMessageBean message;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(ReginstActivity.this,R.layout.layout_reginst_activity);
        binding.setEvent(new ReginstViewModel(ReginstActivity.this));
        binding.banner.setImageLoader(new BannerImageLoader());
        List<String> iamges=new ArrayList<>();
        iamges.add("https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=c226cae3d933c895b2739029b07a1895/d52a2834349b033b96b741ae15ce36d3d539bd83.jpg");
        iamges.add("https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=c226cae3d933c895b2739029b07a1895/d52a2834349b033b96b741ae15ce36d3d539bd83.jpg");
        iamges.add("https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=c226cae3d933c895b2739029b07a1895/d52a2834349b033b96b741ae15ce36d3d539bd83.jpg");
        iamges.add("https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=c226cae3d933c895b2739029b07a1895/d52a2834349b033b96b741ae15ce36d3d539bd83.jpg");
        binding.banner.setImages(iamges);
        binding.banner.start();
//        message=new ReginstMessageBean();
//        binding.setMessage(message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.event_send:
                reginst();

                break;
        }
    }

    private void reginst() {
//        RetrofitUtils.getInstance().getHelp().getLoginString("15936562980","333333").enqueue(new Callback<LoginBean>(){
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//                     if(response.code()==200){
//                         Toast.makeText(ReginstActivity.this,"200",Toast.LENGTH_LONG).show();
//                         Log.d("AAA",""+response.body().toString());
//                     }
//            }
//
//            @Override
//            public void onFailure(Call<LoginBean> call, Throwable t) {
//
//            }
//        });
        RetrofitUtils.getInstance().createService(APIHelp.class).getLoginString("15936562980","333333").enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                if(response.code()==200){
                    Toast.makeText(ReginstActivity.this,"200",Toast.LENGTH_LONG).show();
                    Log.d("AAA",""+response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {

            }
        });
    }

}
