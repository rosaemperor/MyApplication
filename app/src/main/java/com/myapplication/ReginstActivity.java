package com.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.myapplication.bean.LoginBean;
import com.myapplication.bean.ReginstMessageBean;
import com.myapplication.databinding.LayoutReginstActivityBinding;
import com.myapplication.http.RetrofitUtils;
import com.myapplication.viewModel.ReginstViewModel;

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
        message=new ReginstMessageBean();
        binding.setMessage(message);
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
        RetrofitUtils.getInstance().getHelp().getLoginString("15936562980","333333").enqueue(new
                                                                                                       Callback<LoginBean>(){
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                     if(response.code()==200){
                         Toast.makeText(ReginstActivity.this,"200",Toast.LENGTH_LONG).show();
                     }
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {

            }
        });
    }
}
