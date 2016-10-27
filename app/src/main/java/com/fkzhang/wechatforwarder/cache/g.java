package com.fkzhang.wechatforwarder.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import de.robv.android.xposed.XSharedPreferences;

public class g
{
  private SharedPreferences a = null;
  private XSharedPreferences b = null;

  public g(Context paramContext, String paramString)
  {
    this.a = paramContext.getSharedPreferences(paramString + "_preferences", 1);
  }

  public g(String paramString)
  {
    this.b = new XSharedPreferences(paramString);
    this.b.makeWorldReadable();
    a();
  }

  public int a(String paramString, int paramInt)
  {
    int i;
    if (this.a != null) {
      i = this.a.getInt(paramString, paramInt);
    }
    do
    {
//      return i;/** Modify By Gele **/
      i = paramInt;
    } while (this.b == null);
    return this.b.getInt(paramString, paramInt);
  }

  /** Modify By Gele **///
  public String a(String paramString1, String paramString2)
  {
    String str;
    if (this.a != null) {
      str = this.a.getString(paramString1, paramString2);
    }
    do
    {
//      return str;/** Modify By Gele **/
      str = paramString2;
    } while (this.b == null);
    return this.b.getString(paramString1, paramString2);
  }

  public void a()
  {
    if (this.b != null) {
      this.b.reload();
    }
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool;
    if (this.a != null) {
      bool = this.a.getBoolean(paramString, paramBoolean);
    }
    do
    {
//      return bool;/** Modify By Gele **/
      bool = paramBoolean;
    } while (this.b == null);
    return this.b.getBoolean(paramString, paramBoolean);
  }

  public void b(String paramString, int paramInt)
  {
    Editor localEditor = null;
    if (this.a != null) {
      localEditor = this.a.edit();
    }
    for (;;)
    {
      if (localEditor != null)
      {
        localEditor.putInt(paramString, paramInt);
        localEditor.commit();
      }

      if (this.b != null) {
        localEditor = this.b.edit();
      }
        return;
    }
  }

  public void b(String paramString1, String paramString2)
  {
    Editor localEditor = null;
    if (this.a != null) {
      localEditor = this.a.edit();
    }
    for (;;)
    {
      if (localEditor != null)
      {
        localEditor.putString(paramString1, paramString2);
        localEditor.commit();
      }
      if (this.b != null) {
        localEditor = this.b.edit();
      }
        return;

    }
  }

  public void b(String paramString, boolean paramBoolean)
  {
    Editor localEditor = null;
    if (this.a != null) {
      localEditor = this.a.edit();
    }
    for (;;)
    {
      if (localEditor != null)
      {
        localEditor.putBoolean(paramString, paramBoolean);
        localEditor.commit();
      }

      if (this.b != null) {
        localEditor = this.b.edit();
      }
        return;
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.c.g

 * JD-Core Version:    0.7.0.1

 */