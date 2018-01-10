package com.myapplication.viewModel;
import android.content.Context;
import android.databinding.ObservableField;
import android.webkit.WebChromeClient;

/**
 * Created by administrator on 2018/1/8.
 */

public class BrowserViewModel {
    private Context mContext;
    public BrowserViewModel(Context context){
        this.mContext= context;
        chromeClient.set(new WebChromeClient());
    }
    public ObservableField<WebChromeClient> chromeClient= new ObservableField<>();
}
