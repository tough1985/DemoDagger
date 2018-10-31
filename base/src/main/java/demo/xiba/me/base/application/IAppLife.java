package demo.xiba.me.base.application;

import android.app.Application;
import android.content.Context;

/**
 * @Author:liukun
 * @Date: 2018-01-21 15:53
 * @Description:
 */
public interface IAppLife {

    void attachBaseContext(Context base, ApplicationDelegate applicationDelegate);

    void onApplicationCreate(Application application);

    void onTerminate();
}
