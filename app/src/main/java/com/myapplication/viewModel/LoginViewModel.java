package com.myapplication.viewModel;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.myapplication.BuildConfig;
import com.myapplication.LoginActivity;
import com.myapplication.R;
import com.myapplication.adapter.ImageListAdapter;
import com.myapplication.adapter.ListAdapter;
import com.myapplication.bean.LoginBean;
import com.myapplication.command.LoginCommand;
import com.myapplication.http.RetrofitUtils;
import com.myapplication.utils.NdkUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adminidtrator on 2017/10/23.
 */

public class LoginViewModel {
    private Context activity;

    LoginBean loginBean;
    //model
//    private LoginBean bean;

    /**
     * viewstyle
     * 用来控制view的显示样式
     */
    public final ViewStyle viewStyle = new ViewStyle();

    public void destoryAdapter() {
        adapter.set(null);
    }

    public class ViewStyle{
        public final ObservableBoolean isRefreshing = new ObservableBoolean();
        public final ObservableBoolean progressRefreshing = new ObservableBoolean();
        public final ObservableInt showListView = new ObservableInt();
        public final ObservableInt backgroundClolr= new ObservableInt();
    }
    //数据
    public final ObservableField<String> ImageUrl =new ObservableField<>();
    public final ObservableField<String> title = new ObservableField<>();

    public final ObservableField<LoginBean> bean = new ObservableField<LoginBean>() ;
    public final ObservableField<ListAdapter> adapter = new ObservableField<>();

    public final ObservableField<RecyclerView.LayoutManager> manager = new ObservableField<>();
    public final ObservableField<ImageListAdapter> iamgeAdapter= new ObservableField<>();


    //路由事件
    public final LoginCommand command = new LoginCommand(this);


    public LoginViewModel(Context activity, long id) {
        this.activity = activity;
        loadData(id);
    }

    private void loadData(long id) {
        loginBean = new LoginBean();
        loginBean.setToken(NdkUtils.daozhuanString());
        viewStyle.showListView.set(View.GONE);
        manager.set(new LinearLayoutManager(activity));
        iamgeAdapter.set(new ImageListAdapter(activity));
        viewStyle.backgroundClolr.set(activity.getColor(R.color.colorPrimary));
        if(BuildConfig.DEBUG){
            loginBean.setToken("debug");
        }else {
            loginBean.setToken("release");
        }
        List<LoginBean> list= new ArrayList<>();
        for(int i =0 ;i<5;i++){
            list.add(loginBean);
        }
        title.set("title");
        adapter.set(new ListAdapter(activity,list));
        bean.set(loginBean);
    }
    public void changeString(String tpUser){
        bean.get().setToken(tpUser);
    }
    public void updateUserMeddage(){
       Call call= RetrofitUtils.getInstance().getHelp().getLoginString("15936562980","333333");
       call.enqueue(new Callback<LoginBean>() {
           @Override
           public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
               loginBean=response.body();
               Log.d("TAG",""+loginBean.getToken());

           }

           @Override
           public void onFailure(Call<LoginBean> call, Throwable t) {

           }
       });
    }


    public void onDestory() {
        adapter.get().destory();
        activity = null;
    }

}
