package com.fkzhang.wechatforwarder.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.fkzhang.wechatforwarder.cache.f;

class ag
  implements f
{
  Intent a;
  ae d;
  String b;
  String c;
  ag(ae paramae, Intent paramIntent, String paramString1, String paramString2) {
    a = paramIntent;
    d = paramae;
    b = paramString1;
    c = paramString2;
  }

  public void a(Bitmap paramBitmap)
  {
    Bundle localBundle = new Bundle();
    if (paramBitmap != null)
    {
      byte[] bytes = com.fkzhang.wechatforwarder.base.a.a(paramBitmap);
      this.a.putExtra("Ksnsupload_imgbuf", bytes);
      localBundle.putByteArray("_wxobject_thumbdata", bytes);
    }
    localBundle.putString("_wxmusicobject_musicUrl", this.b);
    localBundle.putString("_wxobject_title", this.c);
    localBundle.putInt("_wxapi_command_type", 2);
    localBundle.putString("_wxobject_identifier_", "com.tencent.mm.sdk.openapi.WXMusicObject");
    this.a.putExtra("Ksnsupload_timeline", localBundle);
    this.a.putExtra("ksnsis_music", true);
    this.d.b.f.startActivity(this.a);
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.ag

 * JD-Core Version:    0.7.0.1

 */