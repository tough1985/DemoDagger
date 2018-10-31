package demo.xiba.me.base.application;

import java.util.List;

/**
 * @Author:liukun
 * @Date: 2018-01-21 16:21
 * @Description:
 */
public interface IModuleConfig {

    void injectAppLifecycle(List<IAppLife> iAppLives);
}
