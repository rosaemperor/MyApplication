package com.myapplication.command;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.myapplication.R;
import com.myapplication.activity.KotlinActivity;
import com.myapplication.base.BaseCommand;
import com.myapplication.viewModel.LoginViewModel;

/**
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
                viewModel.changeString("这里是设置来的");
                break;
        }
    }
    public void login(View view){
        switch (view.getId()){
            case R.id.login:
//            Toast.makeText(view.getContext(),"login",Toast.LENGTH_LONG).show();
//                viewModel.viewStyle.showListView.set(View.GONE);
                viewModel.viewStyle.backgroundClolr.set(view.getContext().getColor(R.color.colorAccent));
//                Intent intent = new Intent();
//                intent.setClass(view.getContext(), KotlinActivity.class);
//                view.getContext().startActivity(intent);
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
