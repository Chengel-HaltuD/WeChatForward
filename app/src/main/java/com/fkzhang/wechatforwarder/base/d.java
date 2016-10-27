package com.fkzhang.wechatforwarder.base;

import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;

class d
  extends XC_MethodHook
{
  com.fkzhang.wechatforwarder.base.a a;
  d(com.fkzhang.wechatforwarder.base.a parama) {
    a = parama;
  }
  
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {

    Log.i("Chengel_HaltuD", "55555555555555555555");
    /*if (!this.a.a.a("sns_forward_enable", false)) {
      Log.i("Chengel_HaltuD", "6666666666666666666");
      return;
    }*/
    try
    {
      Log.i("Chengel_HaltuD", "7777777777777777777777777");
      this.a.d(paramMethodHookParam);
      return;
    }
    catch (Throwable ss)
    {
      a.a(ss);
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.d

 * JD-Core Version:    0.7.0.1

 */