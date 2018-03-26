package com.kmitl.phatipan.trustvegetable;

import android.app.Application;

import com.kmitl.phatipan.trustvegetable.manager.Contextor;

/**
 * Created by phatipan on 25/10/2017 AD.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
