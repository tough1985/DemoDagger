package demo.xiba.me.base.application;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:liukun
 * @Date: 2018-01-21 15:57
 * @Description: Application初始化的委托代理
 */
public class ApplicationDelegate {

    private static Context sApplicationContext;

    private List<IModuleConfig> mModuleList;
    private List<IAppLife> mAppLifeList;


    public ApplicationDelegate() {
        mAppLifeList = new ArrayList<>();
    }

    public void attachBaseContext(Context baseContext) {

        ManifestParser parser = new ManifestParser(baseContext);
        mModuleList = parser.parse();

        //通过解析Manifest文件中的Meta
        if (mModuleList != null) {
            for (IModuleConfig moduleConfig : mModuleList) {
                moduleConfig.injectAppLifecycle(mAppLifeList);
            }
        }

        //调用所有子模块的attachBaseContext
        if (mAppLifeList != null && mAppLifeList.size() >0) {
            for (IAppLife appLife : mAppLifeList) {
                appLife.attachBaseContext(baseContext, this);
            }
        }
    }

    public void onCreate(Application application) {

        this.sApplicationContext = application;

        //调用所有子模块的onCreate
        if (mAppLifeList != null && mAppLifeList.size() >0) {
            for (IAppLife appLife : mAppLifeList) {
                appLife.onApplicationCreate(application);
            }
        }
    }

    public void onTerminate() {

        //调用所有子模块的onTerminate
        if (mAppLifeList != null && mAppLifeList.size() >0) {
            for (IAppLife appLife : mAppLifeList) {
                appLife.onTerminate();
            }
        }
    }


    public static Context getApplicationContext(){
        return sApplicationContext;
    }


}
