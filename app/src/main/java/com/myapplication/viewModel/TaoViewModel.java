package com.myapplication.viewModel;

import android.databinding.ObservableField;

/**
 * Created by administrator on 2017/12/29.
 */

public class TaoViewModel {
    ObservableField<String> content=new ObservableField<>();

    public ObservableField<String> getContent() {
        return content;
    }

    public void setContent(ObservableField<String> content) {
        this.content = content;
    }
}
