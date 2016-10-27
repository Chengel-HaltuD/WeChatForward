package com.fkzhang.wechatforwarder.base;

import android.content.Intent;
import android.graphics.Bitmap;

import com.fkzhang.wechatforwarder.cache.f;

class af
  implements f
{
  Intent a;
  ae b;
  af(ae paramae, Intent paramIntent) {

    b = paramae;
    a = paramIntent;
  }

  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      byte[] a = com.fkzhang.wechatforwarder.base.a.a(paramBitmap);
      this.a.putExtra("Ksnsupload_imgbuf", a);
    }
    this.b.b.f.startActivity(this.a);
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.af

 * JD-Core Version:    0.7.0.1

 */