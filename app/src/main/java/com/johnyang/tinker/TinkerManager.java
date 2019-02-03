package com.johnyang.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * 对tinker的所有api做一层封装
 */
public class TinkerManager {

    private static boolean isInstalled = false;//是否已经安装tinker
    private static ApplicationLike mApplike;

    /**
     * 完成tinker初始化
     * @param applicationLike
     */
    public static void installTinker(ApplicationLike applicationLike){
        mApplike = applicationLike;

        if(isInstalled){
            return;
        }

        TinkerInstaller.install(mApplike);//完成tinker初始化
        isInstalled=true;
    }

    /**
     * 完成patch文件的加载
     * @param path
     */
    public static void loadPatch(String path){
        TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),path);
    }


    /**
     * 通过ApplicationLike获取context
     * @return
     */
    public static Context getApplicationContext(){
        if(mApplike != null){
            return mApplike.getApplication().getApplicationContext();
        }
        return null;
    }

}
