package com.fkzhang.wechatforwarder.base;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

class k
  extends XC_MethodHook
{
  a a;

  k(a parama) {
    a = parama;
  }
  
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    if (!this.a.a.a("favorite_forward_enable", false)) {
      return;
    }
    for (;;)
    {
      try
      {
        ContextMenu localContextMenu = (ContextMenu)paramMethodHookParam.args[0];
        if (localContextMenu.findItem(1000) != null) {
          break;
        }
        Object localObject1 = (ContextMenuInfo)paramMethodHookParam.args[2];
        Object localObject2 = (ListView) XposedHelpers.getObjectField(paramMethodHookParam.thisObject, this.a.b.aX);
//        int i = ((AdapterView.AdapterContextMenuInfo)localObject1).position;
        int i = 0 ;
        int j = ((ListView)localObject2).getHeaderViewsCount();
        int k = this.a.b.bk;
        localObject1 = XposedHelpers.callMethod(XposedHelpers.getObjectField(paramMethodHookParam.thisObject, this.a.b.aY), this.a.b.aZ, new Object[]{Integer.valueOf(i - j - 1 + k)});
        long l = XposedHelpers.getLongField(localObject1, "field_localId");
        i = XposedHelpers.getIntField(localObject1, "field_type");
        if ((i != 1) && (i != 2) && (i != 3) && (i != 5) && (i != 7) && (i != 16)) {
          break;
        }
//        paramMethodHookParam = XposedHelpers.callMethod(XposedHelpers.callStaticMethod(this.a.y, this.a.b.ba, new Object[0]), this.a.b.bb, new Object[]{Long.valueOf(l)});
//        localObject2 = XposedHelpers.callStaticMethod(this.a.z, this.a.b.bc, new Object[]{paramMethodHookParam});
        if (i == 3)
        {
//          paramMethodHookParam = this.a.a.a("forward", "转发");
//          localContextMenu.add(0, 1000, 0, paramMethodHookParam).setOnMenuItemClickListener(new l(this, i, localObject1, localObject2));
          if ((i != 16) || (localContextMenu.findItem(1001) != null)) {
            break;
          }
//          localContextMenu.add(0, 1001, 0, this.a.a.a("share", "分享")).setOnMenuItemClickListener(new m(this, localObject2));
          return;
        }
      }
      catch (Throwable ss)
      {
        a.a(ss);
        return;
      }
//      paramMethodHookParam = this.a.a.a("forward_chat_to_sns", "转发到朋友圈");
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.k

 * JD-Core Version:    0.7.0.1

 */