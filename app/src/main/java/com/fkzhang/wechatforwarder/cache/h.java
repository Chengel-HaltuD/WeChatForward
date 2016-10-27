package com.fkzhang.wechatforwarder.cache;

import android.database.Cursor;
import android.text.TextUtils;

import de.robv.android.xposed.XposedHelpers;

public class h
{
  private Object a;
  
  public h(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public Cursor a(String paramString)
  {
    return a(paramString, null);
  }
  
  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    return (Cursor) XposedHelpers.callMethod(this.a, "rawQuery", new Object[]{paramString, paramArrayOfString});
  }
  
  public String a(long paramLong)
  {
    Cursor localCursor = a("SELECT * FROM ImgInfo2 WHERE msgSvrId = " + paramLong);
    if ((localCursor == null) || (!localCursor.moveToFirst())) {
      return null;
    }
    String str = localCursor.getString(localCursor.getColumnIndex("bigImgPath"));
    localCursor.close();
    return str;
  }
  
  public String b(String paramString)
  {
    Cursor localCursor = d(paramString);
    if ((localCursor == null) || (!localCursor.moveToFirst())) {
      return paramString;
    }
    String str = localCursor.getString(localCursor.getColumnIndex("conRemark"));
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = localCursor.getString(localCursor.getColumnIndex("nickname"));
    }
    paramString = paramString.trim();
    localCursor.close();
    return paramString;
  }
  
  public String c(String paramString)
  {
    String str = b(paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
//    paramString = a("SELECT * FROM chatroom WHERE chatroomname = ?", new String[] { paramString });/** Modify By Gele **/
    Cursor paramcursor = a("SELECT * FROM chatroom WHERE chatroomname = ?", new String[]{paramString});
    if ((paramcursor == null) || (!paramcursor.moveToFirst())) {
      return null;
    }
    int displayname = paramcursor.getColumnIndex("displayname");
    str = paramcursor.getString(displayname);
    paramcursor.close();
    return str;
  }
  
  public Cursor d(String paramString)
  {
    return a("SELECT * FROM rcontact WHERE username = ?", new String[] { paramString });
  }
  
  public String e(String paramString)
  {
//    paramString = a("SELECT groupId FROM EmojiInfo WHERE md5 = ?", new String[] { paramString });/** Modify By Gele **/
    Cursor cursor = a("SELECT groupId FROM EmojiInfo WHERE md5 = ?", new String[]{paramString});
    if ((cursor == null) || (!cursor.moveToFirst())) {
      return null;
    }
    String str = cursor.getString(cursor.getColumnIndex("groupId"));
    cursor.close();
    return str;
  }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.c.h

 * JD-Core Version:    0.7.0.1

 */