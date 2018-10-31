package me.xiba.demo.module_c.di.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import me.xiba.demo.common.di.component.BaseAppComponent;
import me.xiba.demo.module_c.di.module.ModuleCActivityModule;

/**
 * @Author:liukun
 * @Date: 2018-10-30 16:16
 * @Description: Application的AndroidInjector基类接口的模块实现；
 *      可以在此添加该模块的Module依赖注入
 */

@Subcomponent(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        ModuleCActivityModule.class
})
public interface ModuleCAppComponent extends BaseAppComponent {

    @Subcomponent.Builder
    abstract class Builder extends BaseAppComponent.Builder {
    }
}