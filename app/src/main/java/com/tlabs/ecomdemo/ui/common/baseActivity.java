package com.tlabs.ecomdemo.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tlabs.ecomdemo.helpers.DataManager;
import com.tlabs.ecomdemo.helpers.PreferenceManager;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class BaseActivity extends AppCompatActivity{

    protected PreferenceManager mPreferenceManager;
    protected DataManager mDataManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPreferenceManager = new PreferenceManager(this);
        mDataManager = new DataManager();

    }
}
