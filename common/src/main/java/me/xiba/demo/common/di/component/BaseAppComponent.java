package me.xiba.demo.common.di.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import me.xiba.demo.common.CommonApplication;

/**
 * @Author:liukun
 * @Date: 2018-10-30 21:17
 * @Description: Application的AndroidInjector基类接口；
 *     在此定义，需要子模块继承实现
 */
@Subcomponent(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class
})
public interface BaseAppComponent extends AndroidInjector<CommonApplication> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CommonApplication> {
    }
}
