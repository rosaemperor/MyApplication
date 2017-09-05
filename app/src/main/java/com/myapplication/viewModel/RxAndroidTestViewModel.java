package com.myapplication.viewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.myapplication.R;
import com.myapplication.SimpleRxAndroidActivity;
import com.myapplication.databinding.RxAndroidTestBinding;

/**
 * Created by Adminidtrator on 2017/9/3.
 */

public class RxAndroidTestViewModel implements OnClickListener{
    private Context context;
    private RxAndroidTestBinding binding;

    public RxAndroidTestViewModel(Context context, RxAndroidTestBinding binding) {
        this.context = context;
        this.binding = binding;
        onCreate();
    }

    private void onCreate() {
        binding.setEvent(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.simple:
                context.startActivity(new Intent(context, SimpleRxAndroidActivity.class));
                break;
            default:
                break;
        }
    }
}
