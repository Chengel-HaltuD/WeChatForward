package com.fkzhang.wechatforwarder.base;

import android.graphics.Bitmap;
import android.util.Log;

import com.fkzhang.wechatforwarder.cache.f;

import java.util.ArrayList;

class ak
  implements f
{
  a c;
  ArrayList a;
  String b;
  ak(a parama, ArrayList paramArrayList, String paramString) {
    c = parama;
    a = paramArrayList;
    b = paramString;
    Log.i("Chengel_HaltuD", "其他==开始往下执行55555==0");
  }
  
  public void a(Bitmap paramBitmap)
  {
    try
    {
      Log.i("Chengel_HaltuD", "其他==开始往下执行55555==1");
      Log.i("Chengel_HaltuD", "其他==开始往下执行55555==1"+a.size()+"=="+b);
      this.c.a(this.a, this.b);
      return;
    }
    catch (Throwable ss)
    {
      this.c.a(ss);
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.ak

 * JD-Core Version:    0.7.0.1

 */