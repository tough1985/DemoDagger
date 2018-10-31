package me.xiba.demo.module_c.di.component;

import dagger.Component;
import me.xiba.demo.common.di.component.BaseModuleComponent;
import me.xiba.demo.common.di.scope.AppScope;
import me.xiba.demo.module_c.di.module.ModuleCAppComponentModule;

/**
 * @Author:liukun
 * @Date: 2018-10-30 22:08
 * @Description:
 */
@AppScope
@Component(modules = ModuleCAppComponentModule.class)
public interface ModuleCComponent extends BaseModuleComponent {
    ModuleCAppComponent.Builder appComponent();
}