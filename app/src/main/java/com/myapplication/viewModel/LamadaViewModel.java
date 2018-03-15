package com.myapplication.viewModel;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapplication.R;
import com.myapplication.client.MyClient;

import java.io.IOException;

/**
 * Created by administrator on 2017/12/27.
 */

public class LamadaViewModel {
    private ObservableField<RecyclerView.LayoutManager> layoutManager = new ObservableField<>();
    public void click(int number){
        Log.d("TAG",""+number);
    }
    public void click() {
//
        new Thread(new Runnable() {
            @Override
            public void run() {
                String serverIp="127.0.0.1";
                int port =12345;
                MyClient client= new MyClient(serverIp,port);
                try {
                    client.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public boolean longClick(){
        Log.d("TAG","长安");
//        NotificationManager notiManager = (NotificationManager) view.getContext().getSystemService(Context.NOTIFICATION_SERVICE);
//        Notification notification= new Notification(R.mipmap.logo_cat,"adfasd",System.currentTimeMillis());
//        PendingIntent pendingIntent = PendingIntent.getActivity(view.getContext(),0,((Activity)view.getContext()).getIntent(),0);
//        notiManager.notify(R.mipmap.logo_cat,notification);
        return true;
    }
    public LamadaViewModel(){

    }
}
