package com.myapplication.viewModel;

import android.databinding.ObservableField;

/**
 * Created by administrator on 2018/1/4.
 */

public class TaoChildViewModel {
    ObservableField<String> content=new ObservableField<>();

    public ObservableField<String> getContent() {
        return content;
    }

    public void setContent(ObservableField<String> content) {
        this.content = content;
    }
}
