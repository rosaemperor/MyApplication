package com.myapplication.viewModel;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.myapplication.LoginActivity;
import com.myapplication.adapter.ListAdapter;
import com.myapplication.bean.LoginBean;
import com.myapplication.command.LoginCommand;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by Adminidtrator on 2017/10/23.
 */

public class LoginViewModel {
    private Context activity;


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
    }
    //数据
    public final ObservableField<String> ImageUrl =new ObservableField<>();
    public final ObservableField<String> title = new ObservableField<>();

    public final ObservableField<LoginBean> bean = new ObservableField<LoginBean>() ;
    public final ObservableField<ListAdapter> adapter = new ObservableField<>();



    //路由事件
    public final LoginCommand command = new LoginCommand(this);


    public LoginViewModel(Context activity, long id) {
        this.activity = activity;
        loadData(id);
    }

    private void loadData(long id) {
        LoginBean loginBean = new LoginBean();
        loginBean.setToken("AAA");
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

    public void onDestory() {
        adapter.get().destory();
        activity = null;
    }

}
