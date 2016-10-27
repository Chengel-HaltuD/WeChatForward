package com.fkzhang.wechatforwarder.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import java.net.URL;

class d
  extends AsyncTask

{
  @Override
  protected Object doInBackground(Object[] params) {
    return null;

  }

  private f a;
  
  public d(f paramf)
  {
    this.a = paramf;
  }
  
  protected Bitmap a(URL... paramVarArgs)
  {
    return aa.b(paramVarArgs[0]);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    if (this.a != null) {
      this.a.a(paramBitmap);
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.c.d

 * JD-Core Version:    0.7.0.1

 */