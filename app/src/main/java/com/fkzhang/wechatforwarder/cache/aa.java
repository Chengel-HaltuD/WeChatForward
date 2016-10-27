package com.fkzhang.wechatforwarder.cache;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;

public class aa
{
  public static Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
//      paramString = b(new URL(paramString));/** Modify By Gele **/
      Bitmap bitmap = b(new URL(paramString));
      return bitmap;
    }
    catch (Exception ss)
    {
      ss.printStackTrace();
    }
    return null;
  }
  
  public static void a(String paramString, f paramf)
  {
    try
    {
      a(new URL(paramString), paramf);
      return;
    }
    catch (Exception ss)
    {
      ss.printStackTrace();
    }
  }
  
  public static void a(String paramString, File paramFile, int paramInt, e parame)
  {
    Log.i("Chengel_HaltuD", "其他==开始往下执行22222==2");
    new Thread(new c(paramString, paramFile, parame, paramInt)).start();
  }
  
  public static void a(URL paramURL, f paramf)
  {
    new d(paramf).execute(paramURL);//paramURL
  }

  public static void a(ArrayList paramArrayList1, ArrayList paramArrayList2, ProgressDialog paramProgressDialog, f paramf)
  {
    if (paramProgressDialog != null) {
      Log.i("Chengel_HaltuD", "其他==开始往下执行22222==0");
      paramProgressDialog.show();
    }
    Log.i("Chengel_HaltuD", "其他==开始往下执行22222==1");
    int j = paramArrayList1.size();
    int i = 0;
    Log.i("Chengel_HaltuD", "其他==开始往下执行22222==j=="+j);
    Log.i("Chengel_HaltuD", "其他==开始往下执行22222==i=="+i);
//    while (i < j){/** Modify By Gele **/
    for (int m = 0;m<paramArrayList1.size();m++){
      Log.i("Chengel_HaltuD", "其他==开始往下执行22222==ArrayList1==" + (String) paramArrayList1.get(m));
      Log.i("Chengel_HaltuD", "其他==开始往下执行22222==ArrayList2==" + ((File) paramArrayList2.get(m)).getAbsolutePath());
      a((String) paramArrayList1.get(m), (File) paramArrayList2.get(m), m, new b(paramProgressDialog, j, paramf));
//      i += 1;
    }
  }
  
  public static Bitmap b(URL paramURL)
  {
    if (paramURL == null) {
      return null;
    }
    try
    {
      Bitmap bitmap = BitmapFactory.decodeStream(paramURL.openConnection().getInputStream());
      return bitmap;
    }
    catch (Exception ss)
    {
      ss.printStackTrace();
    }
    return null;
  }
  
  public  static void b(File paramFile, Bitmap paramBitmap)
  {
    try
    {
      if (paramFile.exists())
      {
//        paramFile = new FileOutputStream(paramFile);/** Modify By Gele **/
        FileOutputStream outputStream = new FileOutputStream(paramFile);
        paramBitmap.compress(CompressFormat.PNG, 100, outputStream);
        outputStream.flush();
        outputStream.close();
      }
      return;
    }
    catch (Exception ss)
    {
      ss.printStackTrace();
    }
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.c.a

 * JD-Core Version:    0.7.0.1

 */