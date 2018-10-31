package demo.xiba.me.base.application;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:liukun
 * @Date: 2018-01-21 16:19
 * @Description:
 */
public class ManifestParser {

    private static final String MODULE_VALUE = "IModuleConfig";

    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    /**
     * 解析Manifest文件中带有IModuleConfig的Meta标签
     * @return
     */
    public List<IModuleConfig> parse() {
        List<IModuleConfig> modules = new ArrayList<>();
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
            if (appInfo.metaData != null) {
                for (String key : appInfo.metaData.keySet()) {
                    if (MODULE_VALUE.equals(appInfo.metaData.get(key))) {
                        modules.add(parseModule(key));
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse IModuleConfig", e);
        }
        return modules;
    }

    /**
     * 通过反射来创建模块的Applicatioin代理
     * @param className
     * @return
     */
    private static IModuleConfig parseModule(String className){
        Class<?> clazz;

        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unable to find IModuleConfig implementation", e);
        }

        Object module = null;
        try {
            module = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Unable to instantiate IModuleConfig implementation for " + clazz, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to instantiate IModuleConfig implementation for " + clazz, e);
        }

        if (!(module instanceof IModuleConfig)) {
            throw new RuntimeException("Expected instanceof IModuleConfig, but found: " + module);
        }
        return (IModuleConfig) module;
    }
}
