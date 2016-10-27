package com.fkzhang.wechatforwarder.cache;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.File;

final class c
  implements Runnable
{
  String a;
  File b;
  e c;
  int d;
  c(String paramString, File paramFile, e parame, int paramInt) {
    a = paramString;
    b = paramFile;
    c = parame;
    d = paramInt;
    Log.i("Chengel_HaltuD", "其他==开始往下执行44444==0");
  }
  
  public void run()
  {
    try
    {
      Log.i("Chengel_HaltuD", "其他==开始往下执行44444==1=="+this.a);
      Bitmap localBitmap = aa.a(this.a);
      Log.i("Chengel_HaltuD", "其他==开始往下执行44444==2==");
      aa.b(this.b, localBitmap);
      Log.i("Chengel_HaltuD", "其他==开始往下执行44444==3==");
      if (this.c != null) {
        Log.i("Chengel_HaltuD", "其他==开始往下执行44444==4==");
        this.c.a(this.d);
      }
      Log.i("Chengel_HaltuD", "其他==开始往下执行44444==5==");
      return;
    }
    catch (Throwable localThrowable)
    {
      return;
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.c.c

 * JD-Core Version:    0.7.0.1

 */