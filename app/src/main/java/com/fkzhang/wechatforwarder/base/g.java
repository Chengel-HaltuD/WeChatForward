package com.fkzhang.wechatforwarder.base;

import android.app.Activity;

import de.robv.android.xposed.XC_MethodHook;

class g
  extends XC_MethodHook
{

  a sds;
  g(a parama) {
    this.sds = parama;
  }

  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    this.sds.B = ((Activity)paramMethodHookParam.thisObject);
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.g

 * JD-Core Version:    0.7.0.1

 */