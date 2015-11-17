package com.sabthok.aapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import me.zhanghai.android.materialprogressbar.IndeterminateHorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawable;

import static com.sabthok.aapp.Common.START_MAIN;
import static com.sabthok.aapp.Common.START_TEST;

/**
 * Created by Aayush on 11/12/2015.
 */
public class LandingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setIndeterminateDrawable(new IndeterminateProgressDrawable(this));

    }

    public void goButtonClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, START_MAIN);
    }


    public void testButtonClicked(View view) {
        Intent intent = new Intent (this, TestActivity.class);
        startActivityForResult(intent, START_TEST);
    }
}