package me.xiba.demo.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.multidex.MultiDex;
import android.util.Log;



import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import demo.xiba.me.base.application.ApplicationDelegate;
import me.xiba.demo.common.di.component.BaseAppComponent;
import me.xiba.demo.common.di.kit.ModuleCKit;

/**
 * @Author:liukun
 * @Date: 2018-03-01 14:37
 * @Description:
 */
public class CommonApplication extends DaggerApplication {

    public static final String TAG = CommonApplication.class.getSimpleName();
    private ApplicationDelegate delegate;

    protected static CommonApplication instance;

    public static CommonApplication getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        delegate = new ApplicationDelegate();
        delegate.attachBaseContext(this);

    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        MultiDex.install(this);
        delegate.onCreate(this);

    }

    @Override
    public void onTerminate() {
        Log.e(TAG, "onTerminate");
        delegate.onTerminate();
        super.onTerminate();
    }



    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        Log.e(TAG, "applicationInjector");
        BaseAppComponent.Builder appComponentBuild = ModuleCKit.getInstance().getBaseModuleComponent().appComponent();
        appComponentBuild.seedInstance(this);
        return appComponentBuild.build();
    }
}
