package me.xiba.demo.common.di.kit;


import me.xiba.demo.common.di.component.BaseModuleComponent;
import me.xiba.demo.common.di.delegate.AppModuleComponentDelegate;

/**
 * @Author:liukun
 * @Date: 2018-10-30 22:06
 * @Description:
 */
public class ModuleCKit {

    private volatile static ModuleCKit instance;
    private BaseModuleComponent baseModuleComponente;

    private ModuleCKit(){}

    public static ModuleCKit getInstance(){
        if (instance == null) {
            synchronized (ModuleCKit.class){
                if (instance == null) {
                    instance = new ModuleCKit();
                }
            }
        }
        return instance;
    }

    public ModuleCKit init(AppModuleComponentDelegate delegate){
        this.baseModuleComponente = delegate.initBaseModuleComponent();
        return this;
    }

    public BaseModuleComponent getBaseModuleComponent() {
        return baseModuleComponente;
    }
}
