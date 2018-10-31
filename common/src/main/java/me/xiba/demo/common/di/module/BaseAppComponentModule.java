package me.xiba.demo.common.di.module;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.xiba.demo.common.CommonApplication;
import me.xiba.demo.common.di.component.BaseAppComponent;

/**
 * @Author:liukun
 * @Date: 2018-10-30 21:20
 * @Description:
 */
@Module(subcomponents = BaseAppComponent.class)
public abstract class BaseAppComponentModule {

    @Binds
    @IntoMap
    @ClassKey(CommonApplication.class)
    abstract AndroidInjector.Factory<CommonApplication> bindApplicationInjectorFactory(BaseAppComponent.Builder builder);
}
