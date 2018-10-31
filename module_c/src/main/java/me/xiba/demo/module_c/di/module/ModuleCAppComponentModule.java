package me.xiba.demo.module_c.di.module;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.xiba.demo.common.CommonApplication;
import me.xiba.demo.module_c.di.component.ModuleCAppComponent;

/**
 * @Author:liukun
 * @Date: 2018-10-30 22:06
 * @Description: ModuleCAppComponent的Module，提供AndroidInjector
 */
@Module(subcomponents = ModuleCAppComponent.class)
public abstract class ModuleCAppComponentModule {

    @Binds
    @IntoMap
    @ClassKey(CommonApplication.class)
    abstract AndroidInjector.Factory<CommonApplication> bindApplicationInjectorFactory(ModuleCAppComponent.Builder builder);
}

