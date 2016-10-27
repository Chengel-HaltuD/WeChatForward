package com.fkzhang.wechatforwarder.base;

import java.util.List;

import de.robv.android.xposed.XC_MethodHook;

class al
  extends XC_MethodHook
{
//  al(a parama) {}

  protected void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    try
    {
      List localList = (List)paramMethodHookParam.args[1];
//      paramMethodHookParam = (List)paramMethodHookParam.args[2];
      if (!localList.contains(Integer.valueOf(1000)))
      {
        localList.add(Integer.valueOf(1000));
        ((List)paramMethodHookParam.args[2]).add("转发到朋友圈");//this.a.a.a("forward_chat_to_sns", "转发到朋友圈")
      }
      if (!localList.contains(Integer.valueOf(1001)))
      {
        localList.add(Integer.valueOf(1001));
        ((List)paramMethodHookParam.args[2]).add("分享");//this.a.a.a("share", "分享")
      }
      return;
    }
    catch (Throwable ss)
    {
      a.a(ss);
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.al

 * JD-Core Version:    0.7.0.1

 */