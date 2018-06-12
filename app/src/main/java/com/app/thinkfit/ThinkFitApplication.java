package com.app.thinkfit;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

import android.app.Application;
import android.content.Context;

import com.app.thinkfit.data.prefs.DataStoreManager;
import com.app.thinkfit.injection.components.ApplicationComponent;
import com.app.thinkfit.injection.components.DaggerApplicationComponent;
import com.app.thinkfit.injection.modules.ApplicationModule;

public class ThinkFitApplication extends Application {

    private final Object lock = new Object();
    private ApplicationComponent mApplicationComponent;

    public static ThinkFitApplication get(Context context) {
        return (ThinkFitApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DataStoreManager.init(getApplicationContext());
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            synchronized (lock) {
                if (mApplicationComponent == null) {
                    mApplicationComponent = DaggerApplicationComponent.builder()
                            .applicationModule(new ApplicationModule(this))
                            .build();
                }
            }
        }
        return mApplicationComponent;
    }
}
