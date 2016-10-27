package com.fkzhang.wechatforwarder.base;

import android.util.Log;

import com.fkzhang.wechatforwarder.cache.h;

import de.robv.android.xposed.XC_MethodHook;

class ad
  extends XC_MethodHook
{
  a b;
  ClassLoader a;
  ad(a parama, ClassLoader paramClassLoader) {
    b = parama;
    a = paramClassLoader;
  }
  
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    Log.i("Chengel_HaltuD","ad11111111111111");
    if (this.b.e != null) { Log.i("Chengel_HaltuD","ad222222222222222");}
    Log.i("Chengel_HaltuD","ad3333333333333333333333");
    while (!((String)paramMethodHookParam.args[1]).contains("rcontact")) {
      Log.i("Chengel_HaltuD","ad4444444444444444444");
      return;
    }
    Log.i("Chengel_HaltuD","ad5555555555555555555");
    this.b.q(this.a);
    Log.i("Chengel_HaltuD", "ad666666666666666666666666");
    try
    {
      Log.i("Chengel_HaltuD", "ad777777777777777777777");
      this.b.e = new h(paramMethodHookParam.thisObject);
      return;
    }
    catch (Throwable ss)
    {
      this.b.a(ss);
    }
    Log.i("Chengel_HaltuD", "ad888888888888888888888888");
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.ad

 * JD-Core Version:    0.7.0.1

 */