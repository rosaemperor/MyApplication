package com.myapplication.viewModel;

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

public class TaoViewModel {
    ObservableField<String> content=new ObservableField<>();
    ObservableField<TaoChildAdapter> adapter= new ObservableField<>();
    ObservableField<RecyclerView.LayoutManager> manager = new ObservableField<>();

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
    public TaoViewModel(Context context,List<TaoChildViewModel> childViewModels){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        manager.set(layoutManager);
        TaoChildAdapter childAdapter = new TaoChildAdapter(context,childViewModels);
        adapter.set(childAdapter);

    }
}
