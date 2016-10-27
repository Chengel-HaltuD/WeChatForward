package com.fkzhang.wechatforwarder.cache;

import android.app.ProgressDialog;
import android.util.Log;

final class b
  implements e
{

  ProgressDialog a;
  int b;
  f c;
  b(ProgressDialog paramProgressDialog, int paramInt, f paramf) {
    a = paramProgressDialog;
    b = paramInt;
    c = paramf;
    Log.i("Chengel_HaltuD", "其他==开始往下执行33333==0");
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      Log.i("Chengel_HaltuD", "其他==开始往下执行33333==1");
      int i = (int)Math.round((paramInt + 1.0D) / this.b * 100.0D);
      this.a.setProgress(i);
    }
    if (paramInt == this.b - 1)
    {
      Log.i("Chengel_HaltuD", "其他==开始往下执行33333==2");
      if ((this.a != null) && (this.a.isShowing())) {
        Log.i("Chengel_HaltuD", "其他==开始往下执行33333==3");
        this.a.dismiss();
      }
      if (this.c != null) {
        Log.i("Chengel_HaltuD", "其他==开始往下执行33333==4");
        this.c.a(null);
      }
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.c.b

 * JD-Core Version:    0.7.0.1

 */