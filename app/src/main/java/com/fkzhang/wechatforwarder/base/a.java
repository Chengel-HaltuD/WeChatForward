package com.fkzhang.wechatforwarder.base;// INTERNAL ERROR //

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Toast;

import com.fkzhang.wechatforwarder.cache.aa;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class a {
    protected Class A;
    protected Activity B;
    protected int C;
    protected Class D;
    protected boolean E = false;
    protected String F = null;
    protected Class G;
    protected Class H;
    protected final com.fkzhang.wechatforwarder.cache.g a;
    protected com.fkzhang.wechatforwarder.f b;
    protected Class c;
    protected boolean d = false;
    protected com.fkzhang.wechatforwarder.cache.h e;
    protected Activity f;
    protected Class g;
    protected Class h;
    protected Class i;
    protected Class j;
    protected ArrayList k;
    protected Class l;
    protected Class m;
    protected Class n;
    protected Class o;
    protected Class p;
    protected Class q;
    protected Class r;
    protected Class s;
    protected Class t;
    protected Class u;
    protected Class v;
    protected boolean w;
    protected Class x;
    protected Class y;
    protected Class z;

   /* protected final com.fkzhang.wechatforwarder.cache.g a;
    protected com.fkzhang.wechatforwarder.f b;
    protected ArrayList k;
    public a(com.fkzhang.wechatforwarder.f paramf)
    {
        this.b = paramf;
        this.a = new com.fkzhang.wechatforwarder.cache.g("com.fkzhang.wechatforwarder");
        this.k = new ArrayList();
    }*/

    public void a(ClassLoader classLoader) {
        //为了加载读取朋友圈数据库
        try {
            e(classLoader);
        } catch (Throwable ss) {
            a(ss);
        }


        try {
            q(classLoader);
        } catch (Throwable ss) {
            a(ss);
        }


        try {
            f(classLoader);
        } catch (Throwable ss) {
            a(ss);
        }
    }

    public void f(ClassLoader classLoader) {

//        String aE = "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI";
//        String aF = "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.15";
//        String aG = "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.3";
//        String aH = "d";
//
//         XposedHelpers.findClass("com.tencent.mm.storage.ag", null).getClasses(), XposedHelpers.findClass("com.tencent.mm.ab.d", null).getClasses()
//       findAndHookMethod(aG, classLoader, aH,new Object[]{MenuItem.class,Integer.class,new al()});

//        findAndHookMethod("com.tencent.mm.ui.chatting.ChattingUI.a.a", classLoader, "onTextChanged",CharSequence.class,Integer.class,Integer.class,Integer.class,new j());


//        findAndHookMethod("com.tencent.mm.plugin.favorite.ui.FavoriteIndexUI",classLoader,"onCreateContextMenu",new Object[]{ContextMenu.class, View.class,ContextMenu.ContextMenuInfo.class,new k(new a(this.b))});

//        findAndHookMethod("com.tencent.mm.plugin.record.ui.RecordMsgFileUI.11.2",classLoader,"d",MenuItem.class,Integer.class,new s(new a(b),classLoader));

        findAndHookMethod("com.tencent.mm.plugin.sns.ui.c.c", classLoader, "onCreateContextMenu", ContextMenu.class, View.class, ContextMenu.ContextMenuInfo.class, new d(this));

//        findAndHookMethod("com.tencent.mm.plugin.sns.ui.SnsTimeLineUI",classLoader,"onResume",new Object[]{new g(new a(b))});
    }

    protected void a(String str1, String str2) {

        b(XposedHelpers.newInstance(this.x, new Object[]{str1, str2}));

    }

    protected void b(Object object) {

        try {
            Object o = XposedHelpers.callStaticMethod(this.m, this.b.J, new Object[]{});
            XposedHelpers.callMethod(o, this.b.K, new Object[]{object});
        } catch (Throwable ss) {
            a(ss);
        }

    }

    protected void d(XC_MethodHook.MethodHookParam paramMethodHookParam) {

        ContextMenu localContextMenu = (ContextMenu) paramMethodHookParam.args[0];
        View view = (View) paramMethodHookParam.args[1];


        if (view.getTag() != null) {
            Log.i("Chengel_HaltuD", "11111111111111122222222222");
            if (localContextMenu.findItem(1000) == null) {
                Log.i("Chengel_HaltuD", "33333333333333333333333");
//                Object localObject2 = (ListView)XposedHelpers.getObjectField(paramMethodHookParam.thisObject, "dPX");
                Object tag = view.getTag();
                localContextMenu.add(0, 1000, 0, "转发到朋友圈").setOnMenuItemClickListener(new ae(this, tag));
                Log.i("Chengel_HaltuD", "444444444444444444444444");
            } else {

            }
        } else {

        }
    }

    protected void a(Object object, String str2) {

        String s1 = (String) XposedHelpers.getObjectField(object, this.b.aa);//iXW
        Log.i("Chengel_HaltuD", "s1==" + s1);//v0
        String s2 = (String) XposedHelpers.callStaticMethod(this.q, this.b.ab, new Object[]{});//ayV
        Log.i("Chengel_HaltuD", "s2==" + s2);//v1
        String s3 = (String) XposedHelpers.callStaticMethod(this.r, this.b.ac, new Object[]{s2, s1});//bp
        Log.i("Chengel_HaltuD", "s3==" + s3);//v1
        String s4 = null;
        try {
            Log.i("Chengel_HaltuD", "sssssss1111111111111");
            StringBuilder append = new StringBuilder().append(s3);
            Log.i("Chengel_HaltuD", "sssssss222222222222");
            Object o1 = XposedHelpers.callStaticMethod(this.p, this.b.ad, new Object[]{object});//c
            Log.i("Chengel_HaltuD", "sssssss33333333333333333");
            StringBuilder append1 = append.append(o1);
            Log.i("Chengel_HaltuD", "sssssss444444444444444444");
            s4 = append1.toString();
            Log.i("Chengel_HaltuD", "sssssss55555555555555555" + s4);
        } catch (Throwable ss) {
            a(ss);
            Log.i("Chengel_HaltuD", "Throwable111111111111111111");
            StringBuilder append = new StringBuilder().append(s3);//s==v2 s3==v1
            Log.i("Chengel_HaltuD", "Throwable222222222222222222222");
            Object o = XposedHelpers.callStaticMethod(this.p, this.b.ad, new Object[]{s1});
            Log.i("Chengel_HaltuD", "Throwable3333333333333333333");
            s4 = append.append(o).toString();//v2
            Log.i("Chengel_HaltuD", "Throwable444444444444444444" + s4);
        }


        String s5;
        try {
            Log.i("Chengel_HaltuD", "sssssss66666666666666666666");
            StringBuilder append1 = new StringBuilder().append(s3);// o==v3
            Log.i("Chengel_HaltuD", "sssssss7777777777777777777777");
            Object o1 = XposedHelpers.callStaticMethod(this.p, this.b.ae, new Object[]{object});
            Log.i("Chengel_HaltuD", "sssssss88888888888888888888");
            s5 = append1.append(o1).toString();
            Log.i("Chengel_HaltuD", "sssssss999999999999999999" + s5);

        } catch (Throwable ss) {
            a(ss);
            Log.i("Chengel_HaltuD", "Throwable5555555555555555555");
            StringBuilder append1 = new StringBuilder().append(s3);
            Log.i("Chengel_HaltuD", "Throwable66666666666666666");
            Object o1 = XposedHelpers.callStaticMethod(this.p, this.b.ae, new Object[]{s1});
            Log.i("Chengel_HaltuD", "Throwable7777777777777777");
            s5 = append1.append(s1).toString();// v0
            Log.i("Chengel_HaltuD", "Throwable7777777777777777" + s5);
        }


        a(s5, s4, str2);

    }

    public void p(String str) {

        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();

    }

    public Object a(Class classs, boolean[] bo) {
        if (classs == null) {//cond_0
            return null;
        } else {
            if (bo == null) {
                return null;
            } else {//cond_1
                try {
                    Object o = XposedHelpers.newInstance(classs, new Object[]{});

                    Object o1 = XposedHelpers.callMethod(o, this.b.C, new Class[]{}, new Object[]{bo});//Byte.class


                } catch (Throwable ss) {
                    a(ss);
                }

            }

        }


        return null;
    }

    public String c(Object object) {
        if (object == null) {
            return null;
        } else {
            return (String) XposedHelpers.getObjectField(object, this.b.E);
        }
    }


    protected void a(List list, String str) {
        Log.i("Chengel_HaltuD", "其他==开始往下执行11111==" + list.size());
        Log.i("Chengel_HaltuD", "其他==开始往下执行11111==" + str);
        if (list == null) {//cond_0
            return;
        } else {

            if (list.isEmpty()) {
                return;
            } else {//cond_1
                for (int i = 0; i < list.size(); i++) {
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==0" + list.get(i).getClass());
                }
                Log.i("Chengel_HaltuD", "其他==开始往下执行11111==0");
                ArrayList list1 = new ArrayList<>();//v5 // 图片网址
                ArrayList list2 = new ArrayList<>();//v6 //图片缓存路径
                ArrayList list3 = new ArrayList<>();//v7 //保存file?
                Log.i("Chengel_HaltuD", "其他==开始往下执行11111==0.1");
//                File file = this.f.getExternalCacheDir();
                File file = getActivity().getExternalCacheDir();
//                File cacheDir;
                if (file == null) {
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==1");
//                    file = this.f.getCacheDir();//v1
                    file = getActivity().getCacheDir();

                }
                //cond_8
                Log.i("Chengel_HaltuD", "其他==开始往下执行11111==2");
                // move-object v1, v0
                Iterator iterator = list.iterator();//v8
                //move v2, v3

//                if (iterator.hasNext()) {/** Modify By Gele **/
                for (int i =0; i<list.size();i++){
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==2");
//                    Object next = iterator.next();//V0
                    Object next = list.get(i);
                    Object objectField = XposedHelpers.getObjectField(next, this.b.T);//V9 com.tencent.mm.plugin.sns.f.b add

                    String s = (String) XposedHelpers.callStaticMethod(this.t, this.b.S, new Object[]{objectField});//v0
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==2" + s);// /storage/sdcard0/tencent/MicroMsg/44fac83d8c0d5907ff3121d396af9a46/sns/6/7/snsb_12259925267626135894
                    boolean b = this.q(s);

                    if (b) {//cond_4 //判断缓存中有没有?
                        Log.i("Chengel_HaltuD", "其他==开始往下执行11111==2.1" + s);
                        list1.add(s);
                        // move v0, v2
                    } else {
                        Log.i("Chengel_HaltuD", "其他==开始往下执行11111==3");
//                            boolean b1 = this.a.a("img_autodownload_enable", false);//v4 v3? b?/** Modify By Gele **/
                        boolean b1 = true;
                        if (b1) {
                            Log.i("Chengel_HaltuD", "其他==开始往下执行11111==3");

                            StringBuilder builder = new StringBuilder().append("WechatForwarder_");//s?
                            String append = builder.append(1).toString();// v0 v2?
                            File file1 = new File(file, append);//v10

                            Log.i("Chengel_HaltuD", "其他==开始往下执行11111==3+append" + append);
                            try {
                                if (file1.exists()) {//cond_2

                                    list3.add(file1);//v7+
                                    String s1 = (String) XposedHelpers.getObjectField(objectField, this.b.ax);//v0 //图片网址
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==3+s1" + s1);
                                    list2.add(s1);//v6+
                                    String absolutePath = file1.getAbsolutePath();//v0
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==3+absolutePath" + absolutePath);
                                    list1.add(absolutePath);
                                } else {
                                    file1.createNewFile();//2118

                                    list3.add(file1);//v7+
                                    String s1 = (String) XposedHelpers.getObjectField(objectField, this.b.ax);//v0

                                    list2.add(s1);//v6+
                                    String absolutePath = file1.getAbsolutePath();//v0

                                    list1.add(absolutePath);
                                }

                            } catch (Throwable ss) {
                                a(ss);
                            }


                        } else {//cond_3
                            list1.add(s);
                            // move v0, v2
                        }

                    }

                }
                //cond_5

                if (list2.isEmpty()) {//cond_7
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==4");
                    this.a(list1, str);
                } else {
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==5");
//                        boolean show_img_progress = this.a.a("show_img_progress", true);// v1v11 /** Modify By Gele **/
                    boolean show_img_progress = true;
                    ProgressDialog dialog = null;
                    if (show_img_progress) {

                        dialog = new ProgressDialog(getActivity());//v0 //this.B

                        String loading_img = this.a.a("loading_img", "图片加载中,请稍等...");//v1

                        dialog.setMessage(loading_img);
                        dialog.setCancelable(true);
                        dialog.setProgressStyle(1);
                        dialog.setProgress(0);
                        dialog.setMax(100);

                    } //cond_6
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==5");
                    String loading_img = this.a.a("loading_img", "图片加载中,请稍等...");//v1
                    this.p(loading_img);
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==5loading_img" + loading_img);
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==list2.size()==" + list2.size());
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==list3.size()==" + list3.size());
                    aa.a(list2, list3, dialog, new ak(this, list1, str));//new a(b)/** Modify By Gele **/
                    Log.i("Chengel_HaltuD", "其他==开始往下执行11111==5loading_img==over");
                    return;
                }

            }

        }

    }

    protected void a(ArrayList paramArrayList, String str) {

        Intent intent = new Intent();
        intent.setClassName(getActivity(), this.b.g);

        intent.putExtra("Kdescription", str);


        if (paramArrayList != null) {
            intent.putExtra("sns_kemdia_path_list", paramArrayList);
        }

        getActivity().startActivity(intent);
    }

    /**
     * 纯文字跳转
     *
     * @param str2
     */
    protected void b(String str2) {
        Intent intent = new Intent();
        Context applicationContext = getActivity().getApplicationContext();
        intent.setClassName(applicationContext, this.b.g);//.plugin.sns.ui.SnsUploadUI 图片页面,链接页面

        intent.putExtra("Kdescription", str2);
        intent.putExtra("Ksnsupload_type", 9);
        intent.putExtra("WechatForwarderText", 1);
        getActivity().startActivity(intent);
    }

    /**
     * 小视频跳转
     *
     * @param str1
     * @param str2
     * @param str3
     */
    protected void a(String str1, String str2, String str3) {

        Log.i("Chengel_HaltuD", "str1==" + str1 + "str2==" + str2 + "str3==" + str3);
        Intent intent = new Intent();
        Context applicationContext = getActivity().getApplicationContext();
        intent.setClassName(applicationContext, this.b.h);//.plugin.sns.ui.SightUploadUI 小视频页面


        String s = (String) k(str1);
//        String ss = (String)k(str2);
//        String sss = (String)k("122567760371050866224");
//        String ssss = (String)k("12256776037105086622");
//        String sssss = (String)k("sight_12256776037105086622");
//        String ssssss = (String)k("snst_12256776037105086622");
//        String s1 = (String)k("1da39c6ff6dc2987");//12258185362637205658
//        String s2 = (String)k("d6ef69ff1da39c6ff6dc29878b08bc11");//12258185362637205658
//        String s3 = (String)k("44fac83d8c0d5907ff3121d396af9a46");//44fac83d8c0d5907ff3121d396af9a46

        Log.i("Chengel_HaltuD", "cccccccccccccccc0000000000000000" + s);
        if (this.e != null) {
            String e3 = this.e.e(str1);
            Log.i("Chengel_HaltuD", "cccccccccccccccc0000000000000000" + e3);
        }

        intent.putExtra("sight_md5", s);
        intent.putExtra("KSightDraftEntrance", false);
        intent.putExtra("KSightPath", str1);

        intent.putExtra("Kdescription", str3);

        if (TextUtils.isEmpty(str2)) {//cond_0
            if (TextUtils.isEmpty(str3)) {//cond_1

            } else {
                String r = r(str3);
                Log.i("Chengel_HaltuD", "cccccccccccccccc111111111111" + r);
                intent.putExtra("Kdescription", r);
            }
        } else {
            intent.putExtra("KSightThumbPath", str2);
        }
        getActivity().startActivity(intent);
    }


    public String k(String str) {
        String s = null;
        Log.i("Chengel_HaltuD", "ddddddddd111111111111");
        try {
            Log.i("Chengel_HaltuD", "ddddddddd22222222222222");
            s = (String) XposedHelpers.callStaticMethod(this.h, this.b.j, new Object[]{str});//.a.g//aC
            Log.i("Chengel_HaltuD", "ddddddddd333333333333333" + s);
        } catch (Throwable ss) {
            a(ss);
        }
        Log.i("Chengel_HaltuD", "ddddddddd44444444444444");
        return s;
    }


    protected boolean q(String str) {

        boolean b = false;
        try {
            Boolean b1 = (Boolean) XposedHelpers.callStaticMethod(this.A, this.b.bm, new Object[]{str});

            b = b1.booleanValue();
        } catch (Throwable ss) {
            a(ss);
        }

        return b;
    }

    public static Activity getActivity() {
        Class activityThreadClass = null;
        try {
            activityThreadClass = Class.forName("android.app.ActivityThread");
            Object activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null);
            Field activitiesField = activityThreadClass.getDeclaredField("mActivities");
            activitiesField.setAccessible(true);
            Map activities = (Map) activitiesField.get(activityThread);
            for (Object activityRecord : activities.values()) {
                Class activityRecordClass = activityRecord.getClass();
                Field pausedField = activityRecordClass.getDeclaredField("paused");
                pausedField.setAccessible(true);
                if (!pausedField.getBoolean(activityRecord)) {
                    Field activityField = activityRecordClass.getDeclaredField("activity");
                    activityField.setAccessible(true);
                    Activity activity = (Activity) activityField.get(activityRecord);
                    return activity;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void e(ClassLoader classLoader) {
        //(CursorFactory paramCursorFactory, String paramString1, String[] paramArrayOfString, String paramString2, CancellationSignal paramCancellationSignal, boolean paramBoolean)

        StringBuilder append = new StringBuilder().append(this.b.bX).append(".CursorFactory");//v4
        String toString = append.toString();
        Log.i("Chengel_HaltuD", "FFFFFFFFFFFFF111111111111111" + toString);
        StringBuilder append1 = new StringBuilder().append(this.b.a).append(".kingkong.support.CancellationSignal");
        String toString1 = append1.toString();
        Log.i("Chengel_HaltuD", "FFFFFFFFFFFF222222222222222222" + toString1);

        XposedHelpers.findAndHookMethod(this.b.bX, classLoader, "rawQueryWithFactory", new Object[]{
                toString,
                String.class,
                String[].class,
                String.class,
                toString1,
                Boolean.TYPE,
                new ad(this, classLoader)});

    }

    protected void q(ClassLoader classLoader) {

        /** Modify By Gele **///上面缺少部分代码
        if (this.q == null) {//cond_c
            Class a = a(this.b.ak, classLoader);
            this.q = a;
        } else {
        }


        if (this.r == null) {//cond_d
            Class r = a(this.b.al, classLoader);
            this.r = r;
        } else {
        }

        if (this.p == null) {
            Class p = a(this.b.aj, classLoader);
            this.p = p;
        } else {
        }

        if (this.h == null) {
            Class h = a(this.b.o, classLoader);
            this.h = h;
        } else {
        }

        if (this.o == null) {
            Class o = a(this.b.ah, classLoader);//com.tencent.mm.plugin.sns.h.f
            this.o = o;
        } else {
        }

        if (this.n == null) {
            Class n = a(this.b.D, classLoader);//com.tencent.mm.protocal.b.atp
            this.n = n;
        } else {
        }

        if (this.s == null) {
            Class s = a(this.b.am, classLoader);//com.tencent.mm.plugin.sns.d.ai
            this.s = s;
        } else {
        }

        if (this.t == null) {
            Class t = a(this.b.an, classLoader);//com.tencent.mm.plugin.sns.
            this.t = t;
        } else {
        }
        if (this.A == null) {
            Class A = a(this.b.bl, classLoader);//com.tencent.mm.modelsfs.FileOp
            this.A = A;
        } else {
        }

    }


    public a(com.fkzhang.wechatforwarder.f paramf) {
        this.b = paramf;
        this.a = new com.fkzhang.wechatforwarder.cache.g("com.fkzhang.wechatforwarder");
        this.k = new ArrayList();
    }

    protected static Class a(String paramString, ClassLoader paramClassLoader)/** Modify By Gele **///方法名,类加载器
    {
        try {
            return XposedHelpers.findClass(paramString, paramClassLoader);/** Modify By Gele **/
        } catch (Throwable ss) {
            a(ss);
        }
        return null;
    }

    public static Object a(Object paramObject, String paramString, Class[] paramArrayOfClass, Object... paramVarArgs) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        return paramObject.getClass().getSuperclass().getDeclaredMethod(paramString, paramArrayOfClass).invoke(paramObject, paramVarArgs);

    }

    public static void a(String paramString, ClassLoader paramClassLoader, Object... paramVarArgs) {
        Class<?> aClass = XposedHelpers.findClass(paramString, paramClassLoader);//paramString =
        Class[] arrayOfClass = new Class[paramVarArgs.length - 1];
        int i1 = 0;
        if (i1 < paramVarArgs.length - 1) {
            if ((paramVarArgs[i1] instanceof String)) {
                arrayOfClass[i1] = XposedHelpers.findClass((String) paramVarArgs[i1], paramClassLoader);
            }
            for (; ; ) {
                i1 += 1;

                if ((paramVarArgs[i1] instanceof Class)) {
                    arrayOfClass[i1] = ((Class) paramVarArgs[i1]);
                }
                break;
            }
        }
        try {
            Constructor declaredConstructor = aClass.getDeclaredConstructor(arrayOfClass);//paramString
            declaredConstructor.setAccessible(true);
            XposedBridge.hookMethod(declaredConstructor, (XC_MethodHook) paramVarArgs[(paramVarArgs.length - 1)]);
            return;
        } catch (Throwable ss) {
            XposedBridge.log(ss);
        }
    }

    /*protected static void a(Throwable paramThrowable)
    {
        XposedBridge.log(paramThrowable);
    }*/

    protected static void a(Throwable paramThrowable) {
        XposedBridge.log(paramThrowable);
    }

    public static boolean a(File paramFile1, File paramFile2) {
        try {
            if (!paramFile1.exists()) {
                return false;
            }
            BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile1));
            int available = localBufferedInputStream.available();
            byte[] paramFile1byte = new byte[available];
            localBufferedInputStream.read(paramFile1byte);
            localBufferedInputStream.close();
            if (!paramFile2.exists()) {
                paramFile2.createNewFile();
            }
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(paramFile2));//paramFile2 =
            stream.write(paramFile1byte);
            stream.flush();
            stream.close();
            return true;
        } catch (Throwable ss) {
            a(ss);
        }
        return false;
    }

   /* public static byte[] a(Bitmap paramBitmap)
    {
        if (paramBitmap == null) {
            return null;
        }
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
        return localByteArrayOutputStream.toByteArray();
    }*/

    public static byte[] a(Bitmap paramBitmap) {
        if (paramBitmap == null) {
            return null;
        }
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
        return localByteArrayOutputStream.toByteArray();
    }

    public static String b(String paramString1, String paramString2) {
        String str = paramString1;
        if (paramString2.endsWith("@chatroom")) {
            str = paramString1.substring(paramString1.indexOf(":") + 1, paramString1.length()).trim();
        }
        return str;
    }


    /*public static String r(String str)
    {

        return null;
    }*/
    public static String r(String paramString) {
        Log.i("Chengel_HaltuD", "ddddddddd111111111111");
        if (TextUtils.isEmpty(paramString)) {
            return paramString;/** Modify By Gele **/
        }

        do {
            if (paramString.contains("[已删除]")) {
                return paramString.replaceAll("\\[已删除\\]", "");
            }
            if (paramString.contains("[Deleted]")) {
                return paramString.replaceAll("\\[Deleted\\]", "").trim();
            }
            if (paramString.contains("[私密]")) {
                return paramString.replaceAll("\\[私密\\]", "").trim();
            }

        } while (!paramString.contains("[Private]"));
        return paramString.replaceAll("\\[Private\\]", "").trim();
    }

    /* Error */
    public static HashMap s(String paramString) {
        return null;
        // Byte code:
        //   0: new 255	java/util/HashMap
        //   3: dup
        //   4: invokespecial 256	java/util/HashMap:<init>	()V
        //   7: astore 4
        //   9: invokestatic 262	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
        //   12: invokevirtual 266	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
        //   15: astore 5
        //   17: aload 5
        //   19: new 268	java/io/StringReader
        //   22: dup
        //   23: aload_0
        //   24: invokespecial 269	java/io/StringReader:<init>	(Ljava/lang/String;)V
        //   27: invokeinterface 275 2 0
        //   32: aload 5
        //   34: invokeinterface 278 1 0
        //   39: istore_1
        //   40: aload_0
        //   41: ldc_w 280
        //   44: invokevirtual 210	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   47: istore_3
        //   48: iload_1
        //   49: istore_2
        //   50: iload_3
        //   51: iconst_m1
        //   52: if_icmpeq +57 -> 109
        //   55: aload_0
        //   56: iload_3
        //   57: aload_0
        //   58: invokevirtual 213	java/lang/String:length	()I
        //   61: invokevirtual 217	java/lang/String:substring	(II)Ljava/lang/String;
        //   64: astore_0
        //   65: aload_0
        //   66: aload_0
        //   67: ldc_w 282
        //   70: invokevirtual 210	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   73: iconst_1
        //   74: iadd
        //   75: aload_0
        //   76: ldc_w 284
        //   79: invokevirtual 210	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   82: invokevirtual 217	java/lang/String:substring	(II)Ljava/lang/String;
        //   85: astore_0
        //   86: aload 4
        //   88: ldc_w 280
        //   91: aload_0
        //   92: iconst_0
        //   93: aload_0
        //   94: ldc_w 282
        //   97: invokevirtual 210	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   100: invokevirtual 217	java/lang/String:substring	(II)Ljava/lang/String;
        //   103: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   106: pop
        //   107: iload_1
        //   108: istore_2
        //   109: iload_2
        //   110: iconst_1
        //   111: if_icmpeq +104 -> 215
        //   114: iload_2
        //   115: tableswitch	default:+29 -> 144, 0:+29->144, 1:+29->144, 2:+40->155, 3:+29->144
        //   145: iconst_2
        //   146: invokeinterface 291 1 0
        //   151: istore_2
        //   152: goto -43 -> 109
        //   155: aload 5
        //   157: invokeinterface 294 1 0
        //   162: astore_0
        //   163: aload_0
        //   164: ldc_w 296
        //   167: invokevirtual 299	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   170: ifeq +23 -> 193
        //   173: aload 4
        //   175: ldc_w 280
        //   178: aload 5
        //   180: iconst_0
        //   181: invokeinterface 303 2 0
        //   186: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   189: pop
        //   190: goto -46 -> 144
        //   193: aload 4
        //   195: aload_0
        //   196: aload 5
        //   198: invokeinterface 306 1 0
        //   203: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   206: pop
        //   207: goto -63 -> 144
        //   210: astore_0
        //   211: aload_0
        //   212: invokestatic 86	com/fkzhang/wechatforwarder/b/a:a	(Ljava/lang/Throwable;)V
        //   215: aload 4
        //   217: areturn
        //   218: astore_0
        //   219: iload_1
        //   220: istore_2
        //   221: goto -112 -> 109
        //   224: astore_0
        //   225: goto -81 -> 144
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	228	0	paramString	String
        //   39	181	1	i1	int
        //   49	172	2	i2	int
        //   47	10	3	i3	int
        //   7	209	4	localHashMap	HashMap
        //   15	182	5	localXmlPullParser	org.xmlpull.v1.XmlPullParser
        // Exception table:
        //   from	to	target	type
        //   9	40	210	java/lang/Throwable
        //   144	152	210	java/lang/Throwable
        //   40	48	218	java/lang/Throwable
        //   55	107	218	java/lang/Throwable
        //   155	190	224	java/lang/Throwable
        //   193	207	224	java/lang/Throwable
    }

    public Object a(Class paramClass, byte[] paramArrayOfByte) {
        if ((paramClass == null) || (paramArrayOfByte == null)) {
            return null;
        }
        try {
            Object o = XposedHelpers.newInstance(paramClass, new Object[0]);
            Log.i("Chengel_HaltuD", "其他==开始往下执行00000==" + o.getClass());
            Object o1 = XposedHelpers.callMethod(o, this.b.C, new Object[]{paramArrayOfByte});// Byte.class//paramClass = //com.tencent.mm.protocal.b.atp.am
            Log.i("Chengel_HaltuD", "其他==开始往下执行00000==" + o1.getClass());
            return o1;
        } catch (Throwable ss) {
            a(ss);
        }
        return null;
    }

    protected String a(Object paramObject) {
        String str1 = (String) XposedHelpers.getObjectField(paramObject, this.b.aa);
        String str2 = (String) XposedHelpers.callStaticMethod(this.q, this.b.ab, new Object[0]);
        str2 = (String) XposedHelpers.callStaticMethod(this.r, this.b.ac, new Object[]{str2, str1});
        try {
            paramObject = str2 + XposedHelpers.callStaticMethod(this.p, this.b.ae, new Object[]{paramObject});
            return paramObject + "";
        } catch (Throwable ss) {
        }
        return str2 + XposedHelpers.callStaticMethod(this.p, this.b.ae, 0);// INTERNAL ERROR //
    }

}
/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.a

 * JD-Core Version:    0.7.0.1

 */