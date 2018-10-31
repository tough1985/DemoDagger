package me.xiba.demo.module_c.di.module;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import me.xiba.demo.module_c.activity.ModuleCActivity;
import me.xiba.demo.module_c.di.component.ModuleCActivitySubComponent;

/**
 * @Author:liukun
 * @Date: 2018-10-30 16:28
 * @Description: ModuleCActivitySubComponent的Module，提供AndroidInjector
 */
@Module(subcomponents = ModuleCActivitySubComponent.class)
public abstract class ModuleCActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(ModuleCActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindModuleCActivityInjectorFactory(ModuleCActivitySubComponent.Builder builder);
}
