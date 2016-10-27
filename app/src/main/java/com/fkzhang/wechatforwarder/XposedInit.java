package com.fkzhang.wechatforwarder;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;

import com.fkzhang.wechatforwarder.base.a;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedInit
        implements IXposedHookLoadPackage {
    public static String[] a = {"6.3.15", "6.3.13", "6.3.11", "6.3.9", "6.3.8", "6.3.7", "6.3.5", "6.3.0", "6.2.5", "6.2.4", "6.0.0"};
    private SparseArray b;

    private com.fkzhang.wechatforwarder.base.a a(String paramString1, String paramString2, int paramInt) {
        if (this.b == null) {
            this.b = new SparseArray();
        }
        if (this.b.indexOfKey(paramInt) != -1) {
            return (a) this.b.get(paramInt);
        }
        if (TextUtils.isEmpty(paramString2)) {
            if (paramString1.equals("com.tencent.mm4")) {
                this.b.put(paramInt, new a(new f("com.tencent.mm", "6.3.5")));
            }
        }
        for (; ; ) {

            if (paramString2.equals("9.0")) {
                this.b.put(paramInt, new a(new f(paramString1, "6.3.9")));
            } else {
                if (!a(paramString2)) {
                    break;
                }
                this.b.put(paramInt, new a(new f(paramString1, paramString2)));/** Modify By Gele **///包名,版本号
            }
            return (a) this.b.get(paramInt);/** Modify By Gele **/
        }
        XposedBridge.log("WechatForwarder: wechat version " + paramString2 + " not supported!");
        return null;
    }

    public static boolean a(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
        }
        for (; ; ) {

            String[] arrayOfString = a;
            int j = arrayOfString.length;
            int i = 0;
            while (i < j) {
                if (paramString.contains(arrayOfString[i])) {
                    return true;
                }
                i += 1;
            }
            return false;/** Modify By Gele **/
        }
    }


    public boolean debugApps = true;
    public static final int DEBUG_ENABLE_DEBUGGER = 0x1;
    public String tag = "IDG";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam paramLoadPackageParam) {

        XposedBridge.log("handleLoadPackage");

        if (paramLoadPackageParam.appInfo == null ||
                (paramLoadPackageParam.appInfo.flags & (ApplicationInfo.FLAG_SYSTEM | ApplicationInfo.FLAG_UPDATED_SYSTEM_APP)) != 0) {
            return;
        }

        tag = tag + paramLoadPackageParam.packageName;

        XposedBridge.hookAllMethods(Process.class, "start", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                int id = 5;
                int flags = (Integer) param.args[id];
                Log.d(tag, "flags is : " + flags);
                if (debugApps) {
                    if ((flags & DEBUG_ENABLE_DEBUGGER) == 0) {
                        flags |= DEBUG_ENABLE_DEBUGGER;
                    }
                }

                param.args[id] = flags;
                Log.d(tag, "flags changed : " + flags);

            }
        });

        Object localObject1 = paramLoadPackageParam.packageName;

        if ((!((String) localObject1).contains("com.tencen")) || (!((String) localObject1).contains("mm"))) {

        } else {


            for (; ; ) {

                try {
                    /** Modify By Gele **///获取上下文
                    Object localObject2 = (Context) XposedHelpers.callMethod(XposedHelpers.callStaticMethod(XposedHelpers.findClass("android.app.ActivityThread", null), "currentActivityThread", new Object[0]), "getSystemContext", new Object[0]);
                    Log.i("Chengel_HaltuD", "localObject2.getClass()=="+ localObject2.getClass());
                    try {
                        localObject2 = ((Context) localObject2).getPackageManager().getPackageInfo((String) localObject1, 0).versionName;
                        XposedBridge.log( paramLoadPackageParam.packageName + " " + (String) localObject2);//WechatForwarder Loaded app:
                        Log.i("Chengel_HaltuD", paramLoadPackageParam.packageName + " " + (String) localObject2);
                        localObject1 = a((String) localObject1, (String) localObject2, paramLoadPackageParam.appInfo.uid);
                        if (localObject1 == null) {
                            continue;
                        }
                        ((a) localObject1).a(paramLoadPackageParam.classLoader);/** Modify By Gele **/
                        return;
                    } catch (Exception ss) {
                        XposedBridge.log(ss);
                        return;
                    }
//        return;/** Modify By Gele **/
                } catch (Exception ss) {
                    XposedBridge.log(ss);
                }
                return;
            }
        }
    }

/*
  public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {


  }*/
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.XposedInit

 * JD-Core Version:    0.7.0.1

 */