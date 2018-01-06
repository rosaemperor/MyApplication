package com.myapplication.viewModel;

import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

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
        new Thread(new Runnable() {
            @Override
            public void run() {
                String serverIp="127.0.0.1";
                int port =9090;
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
        return true;
    }
    public LamadaViewModel(){

    }
}
