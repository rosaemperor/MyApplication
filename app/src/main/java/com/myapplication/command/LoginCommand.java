package com.myapplication.command;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapplication.R;
import com.myapplication.base.BaseCommand;

/**
 * Created by Adminidtrator on 2017/10/28.
 */

public class LoginCommand extends BaseCommand implements View.OnClickListener{

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Toast.makeText(v.getContext(),"AAA",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
