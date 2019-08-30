package com.yyz.xposedtest;

import android.util.Log;
import android.view.View;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author yyz (杨云召)
 * @date 2019/8/30
 * time   15:17
 * description
 */
public class Main implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if ("cn.bcbook.kaixuetest".equals(lpparam.packageName)) {
            XposedBridge.log("开始hook");
            XposedHelpers.findAndHookMethod("cn.bcbook.kaixuetest.MainActivity",
                    lpparam.classLoader, "printViewId", View.class, new XC_MethodReplacement() {
                        @Override
                        protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                            Log.i("yyz", "hook success!");
                            return null;
                        }
                    });
        }
    }
}
