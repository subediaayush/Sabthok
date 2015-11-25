package com.sabthok.aapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Aayush on 11/17/2015.
 */
public class DetailFragment extends Fragment {
    public DetailFragment() {
    }

    public static DetailFragment newInstance(){
        return new DetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_product_detail, container, false);
        return rootView;
    }
}
