package com.example.gaoying20190308;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class Views extends LinearLayout {
    public Views(Context context) {
        super(context);
    }

    public Views(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view=LayoutInflater.from(context).inflate(R.layout.view,this);

    }

    public Views(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
