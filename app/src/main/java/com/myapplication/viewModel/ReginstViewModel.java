package com.myapplication.viewModel;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapplication.Interface.APIHelp;
import com.myapplication.R;
import com.myapplication.bean.LoginBean;
import com.myapplication.bean.ReginstMessageBean;
import com.myapplication.http.RetrofitUtils;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/8/28.
 */

public class ReginstViewModel implements View.OnClickListener{
    private Context context;
    private ReginstMessageBean message;

    public ReginstMessageBean getMessage() {
        return message;
    }

    public void setMessage(ReginstMessageBean message) {
        this.message = message;
    }

    public ReginstViewModel(Context context){
        this.context=context;
        init();

    }

    private void init() {
        message = new ReginstMessageBean();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.event_send:
                reginst();

                break;
            case R.id.event_send2:
//                Gson gson= new Gson();
//                LoginBean bean = new LoginBean();
//                bean.setAb_user("1");
//                bean.setTp_user("2");
//                bean.setUpdated_at(new ObservableField<String>("121212"));
//                LoginBean bean1 ;
//
//               String json= gson.toJson(bean);
//                bean1 =gson.fromJson(json,LoginBean.class);
//                Log.d("AA",""+json);
//                Log.d("AA",""+bean1.getUpdated_at().get());
                reginst2();
                break;
        }
    }

    private void reginst2() {
        HashMap<String,String> map=new HashMap<>();
        map.put("username","15936562980");
        map.put("password","333333");
        RetrofitUtils.getInstance().getHelp().getLoginString(map).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
    }

    private void reginst() {
//        RetrofitUtils.getInstance().getHelp().getLoginString("15936562980","333333").enqueue(new Callback<LoginBean>(){
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//                if(response.code()==200){
//                    Toast.makeText(context,"200",Toast.LENGTH_LONG).show();
//                }
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
                    Toast.makeText(context,"200",Toast.LENGTH_LONG).show();
                    Log.d("AAA",""+response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {

            }
        });
    }


}
