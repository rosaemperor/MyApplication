package com.myapplication.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by administrator on 2017/12/13.
 */

public class MylayoutManager extends RecyclerView.LayoutManager{
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        int offesety =0;
        for (int i=0;i<getItemCount();i++){
            View view = recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view,0,0);
            int width =getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);
            layoutDecorated(view,0,offesety,width,offesety+height);
            offesety+=height;
        }
    }

    @Override
    public boolean canScrollVertically() {
        return super.canScrollVertically();
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollVerticallyBy(dy, recycler, state);
    }
}
