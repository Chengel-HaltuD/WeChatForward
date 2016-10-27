package com.fkzhang.wechatforwarder;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/**
 * ClassName:
 * Description：
 * Author：Chengel_HaltuD
 * Date：2016/3/29 9:06
 * version：V1.0
 */

public class HelloXposedWorld implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("Hello SystemUI, 哈哈 ,Loaded app: " + lpparam.packageName);

        /*XposedHelpers.findAndHookMethod(
                "android.content.Intent",
                lpparam.classLoader,
                "getIntExtra",
                String.class,
                int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param)
                            throws Throwable {
                        Intent intent = (Intent) param.thisObject;
                        final String action = intent.getAction();
                        if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                            if (BatteryManager.EXTRA_LEVEL.equals(param.args[0] + "")) {
                                param.setResult(1);
                            } else if ("status".equals(param.args[0] + "")) {
                                XposedBridge.log("status");
                                param.setResult(BatteryManager.BATTERY_STATUS_NOT_CHARGING);
                            }z
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param)
                            throws Throwable {
                    }
                }
        );*/
    }
}