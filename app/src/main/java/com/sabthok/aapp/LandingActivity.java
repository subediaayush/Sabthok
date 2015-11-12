package com.sabthok.aapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.sabthok.aapp.Common.START_MAIN;

/**
 * Created by Aayush on 11/12/2015.
 */
public class LandingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    public void goButtonClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, START_MAIN);
    }


}