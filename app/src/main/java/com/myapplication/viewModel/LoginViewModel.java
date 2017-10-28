package com.myapplication.viewModel;

import android.app.Activity;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.myapplication.LoginActivity;
import com.myapplication.bean.LoginBean;
import com.myapplication.command.LoginCommand;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by Adminidtrator on 2017/10/23.
 */

public class LoginViewModel {
    private Activity activity;

    //model
//    private LoginBean bean;

    /**
     * viewstyle
     * 用来控制view的显示样式
     */
    public final ViewStyle viewStyle = new ViewStyle();
    public class ViewStyle{
        public final ObservableBoolean isRefreshing = new ObservableBoolean();
        public final ObservableBoolean progressRefreshing = new ObservableBoolean();
    }
    //数据
    public final ObservableField<String> ImageUrl =new ObservableField<>();
    public final ObservableField<String> title = new ObservableField<>();

    public final ObservableField<LoginBean> bean = new ObservableField<LoginBean>() ;



    //路由事件
    public final LoginCommand command = new LoginCommand(this);


    public LoginViewModel(Activity activity, long id) {
        this.activity = activity;
        loadData(id);
    }

    private void loadData(long id) {
        LoginBean loginBean = new LoginBean();
        loginBean.setToken("AAA");
        bean.set(loginBean);
    }
    public void changeString(String tpUser){
        bean.get().setToken(tpUser);
    }
}
