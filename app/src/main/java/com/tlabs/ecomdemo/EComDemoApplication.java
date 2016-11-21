package com.tlabs.ecomdemo;

import com.crashlytics.android.Crashlytics;
import com.orm.SugarApp;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Sureshkumar on 07/11/16.
 */

public class EComDemoApplication extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();
        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(true)
                .build();
        Fabric.with(fabric);
    }
}
