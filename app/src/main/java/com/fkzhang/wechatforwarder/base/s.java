package com.fkzhang.wechatforwarder.base;

import android.view.MenuItem;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

class s
  extends XC_MethodHook
{
  a b;
  s(a parama, ClassLoader paramClassLoader) {
    b = parama;
  }
  
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    try
    {
      if (!this.b.a.a("record_forward_enable", false)) {
        return;
      }
      if (((MenuItem)paramMethodHookParam.args[0]).getItemId() == 1000)/** Modify By Gele **///转发到朋友圈
      {
        paramMethodHookParam.setResult(null);
        Object localObject1 = this.b;
//        int i = ((a)localObject1).C;
//        ((a)localObject1).C = (i + 1);
//        if (i == 0)
//        {
//          if (this.b.G == null) {/** Modify By Gele **///关键方法名?为空?
////            this.b.G = a.a(this.b.b.bJ, this.a);/** Modify By Gele **///如果为空,(this.bJ += "a.i",类加载器)
//          }
          localObject1 = XposedHelpers.getObjectField(XposedHelpers.getObjectField(paramMethodHookParam.thisObject, this.b.b.bO), this.b.b.bP);/** Modify By Gele **///转发到朋友圈
//          paramMethodHookParam = XposedHelpers.getObjectField(localObject1, this.b.b.bQ);/** Modify By Gele **///字段(对象)
          Object localObject2 = XposedHelpers.getObjectField(localObject1, this.b.b.bR);/** Modify By Gele **///List
//          localObject1 = (String) XposedHelpers.callStaticMethod(this.b.G, this.b.b.bN, new Object[]{paramMethodHookParam, localObject2});
//          paramMethodHookParam = (String) XposedHelpers.callStaticMethod(this.b.G, this.b.b.bS, new Object[]{paramMethodHookParam, localObject2});
//          this.b.a((String)localObject1, paramMethodHookParam, null);
          return;
//        }
      }
    }
    catch (Throwable ss)
    {
      a.a(ss);
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.s

 * JD-Core Version:    0.7.0.1

 */