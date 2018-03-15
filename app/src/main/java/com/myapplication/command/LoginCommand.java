package com.myapplication.command;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.common.logging.LoggingDelegate;
import com.myapplication.BuildConfig;
import com.myapplication.R;
import com.myapplication.activity.KotlinActivity;
import com.myapplication.activity.LamadaActivity;
import com.myapplication.base.BaseCommand;
import com.myapplication.bean.Contact;
import com.myapplication.http.RetrofitUtils;
import com.myapplication.utils.GetContactsUtil;
import com.myapplication.utils.GetContactsUtils;
import com.myapplication.view.LoadingDialog;
import com.myapplication.viewModel.LoginViewModel;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 在command中你只能去写View的路由事件，Context的上下文对象可以通过当前的View的去获得
 * 添加第三方sdk的时候还是要去网址上找到最新的文档进行配置和使用
 * Created by Adminidtrator on 2017/10/28.
 */

public class LoginCommand extends BaseCommand implements View.OnClickListener{
    private LoginViewModel viewModel;
    public LoginCommand(LoginViewModel viewModel) {
        this.viewModel=viewModel;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title:
                Toast.makeText(v.getContext(),"title",Toast.LENGTH_LONG).show();
//                LoadingDialog dialog = new LoadingDialog(v.getContext());
//                dialog.show();
                Intent intent= new Intent();
                intent.setClass(v.getContext(), LamadaActivity.class);
                v.getContext().startActivity(intent);
//                Call call=RetrofitUtils.getInstance().getHelp().getMessage();
//               call.enqueue(new Callback<Object>() {
//                   @Override
//                   public void onResponse(Call<Object> call, Response<Object> response) {
//
//                   }
//
//                   @Override
//                   public void onFailure(Call<Object> call, Throwable t) {
//
//                   }
//               });
                break;
        }
    }
    public void login(View view){
        switch (view.getId()){
            case R.id.login:
//            Toast.makeText(view.getContext(),"login",Toast.LENGTH_LONG).show();
//                viewModel.viewStyle.showListView.set(View.GONE);
//                viewModel.viewStyle.backgroundClolr.set(view.getContext().getColor(R.color.colorAccent)
//             viewModel.updateUserMeddage();
//                Log.d("AAA",""+Build.VERSION.SDK_INT);
//                if(Build.VERSION.SDK_INT)
//                GetContactsUtils utils= new GetContactsUtils();
//                  utils.init(view.getContext());
//                  utils.getSIMContacts();
//                  Log.d("login",""+utils.getSIMContacts().get(2).getMobile());
//                GetContactsUtil contactsUtil = new GetContactsUtil(view.getContext()) ;
//                List<Contact> contactList = contactsUtil.getContacts();
//                Log.d("TAG",""+contactList.size());
//                Log.d("TAG",""+contactList.get(22).getName()+contactList.get(22).getMobile());
                ApplicationInfo info= null;
                try {
                    info = view.getContext().getPackageManager().getApplicationInfo(view.getContext().getPackageName(), PackageManager.GET_META_DATA);
                    Log.d("channel",""+info.metaData.getString("UMENG_CHANNEL_VALUE"));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

                break;
        }
    }

    /**
     * ListView的item点击事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    public void listItemClick(AdapterView<?> parent, View view, int position, long id){
           Toast.makeText(view.getContext(),"position"+position,Toast.LENGTH_LONG).show();
    }

}
