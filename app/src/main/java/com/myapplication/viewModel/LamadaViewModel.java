package com.myapplication.viewModel;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by administrator on 2017/12/27.
 */

public class LamadaViewModel {
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
}
