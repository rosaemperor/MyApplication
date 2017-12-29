package com.myapplication.viewModel;

import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by administrator on 2017/12/27.
 */

public class LamadaViewModel {
    private ObservableField<RecyclerView.LayoutManager> layoutManager = new ObservableField<>();
    public void click(int number){
        Log.d("TAG",""+number);
    }
    public void click(){
        Log.d("TAG","无参数");
    }
    public boolean longClick(){
        Log.d("TAG","长安");
        return true;
    }
    public LamadaViewModel(){

    }
}
