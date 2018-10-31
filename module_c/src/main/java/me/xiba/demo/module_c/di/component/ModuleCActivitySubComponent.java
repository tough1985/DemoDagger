package me.xiba.demo.module_c.di.component;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import me.xiba.demo.module_c.activity.ModuleCActivity;
import me.xiba.demo.module_c.entity.ModuleCDaggerEntity;

/**
 * @Author:liukun
 * @Date: 2018-10-30 16:25
 * @Description: ModuleCActivity的Component，向ModuleCActivity注入相关依赖
 */
@Subcomponent(modules = {
        AndroidInjectionModule.class,
        ModuleCActivitySubComponent.SubModule.class
})
public interface ModuleCActivitySubComponent extends AndroidInjector<ModuleCActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ModuleCActivity>{
    }

    @Module
    class SubModule{
        @Provides
        ModuleCDaggerEntity providerMainEntity(){
            return new ModuleCDaggerEntity("Create From ModuleCActivitySubComponent");
        }
    }
}
