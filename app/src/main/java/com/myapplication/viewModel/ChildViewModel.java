package com.myapplication.viewModel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

/**
 * Created by administrator on 2017/12/22.
 */

public class ChildViewModel extends ViewModel{
    private ObservableField<String> text =new ObservableField<>();

    public ObservableField<String> getText() {
        return text;
    }

    public void setText(ObservableField<String> text) {
        this.text = text;
    }
}
