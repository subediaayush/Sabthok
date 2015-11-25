package com.sabthok.aapp;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Aayush on 11/20/2015.
 */
public class DescriptionContainer extends LinearLayout {
    private TextView mContainerTitle;
    private ImageButton mLayoutToggle;
    private View mViewLayout;

    public DescriptionContainer(Context context)
    {
        super(context, null);
    }
    public DescriptionContainer(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_description_container, this);

//        String title = this.get

       mContainerTitle = (TextView) findViewById(R.id.container_title);
        mLayoutToggle = (ImageButton) findViewById(R.id.toggle_layout);
        mViewLayout = (View) findViewById(R.id.container_content);
    }
}