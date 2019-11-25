package com.example.vinod.newsapp.base.utils;

import android.graphics.Rect;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private int spaceBetweenRows;

    public SpacesItemDecoration(int space, int spaceBetweenRows) {
        this.space = space;
        this.spaceBetweenRows = spaceBetweenRows;
    }

    @Override
    public void getItemOffsets(Rect outRect, @NotNull View view, RecyclerView parent, @NotNull RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = spaceBetweenRows;

        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildAdapterPosition(view) == 0) {
            outRect.top = space;
        }
    }

}
