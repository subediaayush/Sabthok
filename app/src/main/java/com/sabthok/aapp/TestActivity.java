package com.sabthok.aapp;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import me.zhanghai.android.materialprogressbar.IndeterminateHorizontalProgressDrawable;

/**
 * Created by Aayush on 11/16/2015.
 */
public class TestActivity extends AppCompatActivity implements OnClickListener {
    TextView descriptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        ViewGroup v = (ViewGroup) findViewById(R.id.test_container);
        descriptor = (TextView) findViewById(R.id.item_description_textview);

        recursiveLoopChildren(v, "");
    }

    public void recursiveLoopChildren(ViewGroup parent, String parentName) {
        for (int i = parent.getChildCount() - 1; i >= 0; i--) {
            final View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                parentName = parent.getClass().getName() + ">";
                recursiveLoopChildren((ViewGroup) child, parentName);
                // DO SOMETHING WITH VIEWGROUP, AFTER CHILDREN HAS BEEN LOOPED
            } else {
                if (child != null) {
                    String childName = parentName + ">" + child.getClass().getName();
                    child.setOnClickListener(this);
                    child.setContentDescription(childName);
                }
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() != descriptor.getId())
            descriptor.setText(view.getContentDescription());
    }
}
