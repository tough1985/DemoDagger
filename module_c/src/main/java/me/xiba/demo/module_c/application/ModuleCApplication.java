package me.xiba.demo.module_c.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.List;

import demo.xiba.me.base.application.ApplicationDelegate;
import demo.xiba.me.base.application.IAppLife;
import demo.xiba.me.base.application.IModuleConfig;
import me.xiba.demo.common.di.component.BaseModuleComponent;
import me.xiba.demo.common.di.delegate.AppModuleComponentDelegate;
import me.xiba.demo.common.di.kit.ModuleCKit;
import me.xiba.demo.module_c.di.component.DaggerModuleCComponent;


/**
 * @Author:liukun
 * @Date: 2018-03-05 16:06
 * @Description:
 */
public class ModuleCApplication implements IAppLife, IModuleConfig {

    public static final String TAG = ModuleCApplication.class.getSimpleName();

    /**
     * 初始化模块Component的代理
     */
    private AppModuleComponentDelegate componentDelegate = new AppModuleComponentDelegate() {

        @Override
        public BaseModuleComponent initBaseModuleComponent() {
            BaseModuleComponent component = DaggerModuleCComponent.builder().build();
            return component;
        }
    };

    @Override
    public void injectAppLifecycle(List<IAppLife> iAppLives) {
        //必须将当前实例添加到AppLive列表中，才能接收到相关的生命周期方法
        if (iAppLives != null) {
            iAppLives.add(this);
        }
    }

    @Override
    public void attachBaseContext(Context base, ApplicationDelegate applicationDelegate) {
        // 在此 build ModuleCComponent
        ModuleCKit.getInstance().init(componentDelegate);
    }

    @Override
    public void onApplicationCreate(Application application) {
        Log.e(TAG, "onCreate");

    }

    @Override
    public void onTerminate() {
        Log.e(TAG, "onTerminate");
    }


}