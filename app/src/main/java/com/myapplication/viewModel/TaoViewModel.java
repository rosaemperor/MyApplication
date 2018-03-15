package com.myapplication.viewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.myapplication.adapter.TaoChildAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 2017/12/29.
 */

public class TaoViewModel extends ViewModel {
    ObservableField<String> content;
    ObservableField<TaoChildAdapter> adapter;
    ObservableField<RecyclerView.LayoutManager> manager;

    public TaoViewModel() {
        content = new ObservableField<>();
        adapter = new ObservableField<>();
        manager = new ObservableField<>();
    }

    public ObservableField<RecyclerView.LayoutManager> getManager() {
        return manager;
    }

    public void setManager(ObservableField<RecyclerView.LayoutManager> manager) {
        this.manager = manager;
    }

    public ObservableField<TaoChildAdapter> getAdapter() {
        return adapter;
    }

    public void setAdapter(ObservableField<TaoChildAdapter> adapter) {
        this.adapter = adapter;
    }

    public ObservableField<String> getContent() {
        return content;
    }

    public void setContent(ObservableField<String> content) {
        this.content = content;
    }

    public TaoViewModel(Context context, List<TaoChildViewModel> childViewModels) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        manager.set(layoutManager);


    }

    public void setManager(RecyclerView.LayoutManager layoutManager) {
        manager.set(layoutManager);
    }

    public void setRadapter(TaoChildAdapter childAdapter) {
        adapter.set(childAdapter);
    }

}
