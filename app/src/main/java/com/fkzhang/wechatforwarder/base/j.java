package com.fkzhang.wechatforwarder.base;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

class j
  extends XC_MethodHook
{
//  j(a parama) {}

  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    try
    {
      Object localObject = XposedHelpers.getObjectField(paramMethodHookParam.thisObject, "laF");//this.a.b.aT
      String str1 = (String) XposedHelpers.callMethod(localObject, "getTalkerUserName", new Object[0]);
      if (!str1.endsWith("@chatroom")) {
        return;
      }
      String str2 = ((CharSequence)paramMethodHookParam.args[0]).toString();
      if (str2.contains("#@"))
      {
        paramMethodHookParam.setResult(null);
        int i = str2.indexOf("#@");
//        this.a.a(str1, str2.substring(0, i).trim());
        paramMethodHookParam = (XC_MethodHook.MethodHookParam)XposedHelpers.getObjectField(localObject, "faQ");//this.a.b.aU//faQ
        XposedHelpers.callMethod(paramMethodHookParam, "setLastContent", new Object[]{""});
        XposedHelpers.callMethod(paramMethodHookParam, "i" , new Object[]{"", Integer.valueOf(0), Boolean.valueOf(false)});//this.a.b.aV
        return;
      }
    }
    catch (Throwable ss)
    {
      a.a(ss);
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.j

 * JD-Core Version:    0.7.0.1

 */