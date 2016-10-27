package com.fkzhang.wechatforwarder.base;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;

import com.fkzhang.wechatforwarder.cache.aa;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.robv.android.xposed.XposedHelpers;

class ae
        implements MenuItem.OnMenuItemClickListener {

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

    Object a;
    a b;

    ae(a parama, Object paramObject) {
        this.a = paramObject;
        this.b = parama;
    }

    /* Error */
    public boolean onMenuItemClick(android.view.MenuItem paramMenuItem) {

//        try {
//
//            Log.i("Chengel_HaltuD", getActivity() == null ? "getActivity空" : "getActivity不空" + getActivity().getClass());
//
//            String gs = this.b.b.g;
//
//            Intent intents = new Intent();
//            intents.setClassName(getActivity().getApplicationContext(), gs);//
//
////            intents.putExtra("sight_md5", "");
////            intents.putExtra("KSightDraftEntrance", 0);
////            intents.putExtra("KSightPath", "");
////            intents.putExtra("Kdescription", "");
////            intents.putExtra("KSightThumbPath", "");
//
//            intents.putExtra("Kdescription", "");
//            intents.putExtra("Ksnsupload_type", 1);
//            intents.putExtra("Ksnsupload_title", "");
//            intents.putExtra("Ksnsupload_link", "");
//
//            getActivity().startActivity(intents);
//
//        } catch (Throwable ss) {
//            b.a(ss);
//        }


        Log.i("Chengel_HaltuD", "getClass()==" + this.a.getClass().toString());
        // 文字:com.tencent.mm.plugin.sns.ui.aj
        // 图片:com.tencent.mm.plugin.sns.ui.ag
        // 小视频:com.tencent.mm.plugin.sns.ui.ad
        // 链接:com.tencent.mm.plugin.sns.ui.m
        // 评论内容:com.tencent.mm.plugin.sns.ui.j
        try {
            //小视频
            if (this.a.getClass().toString().endsWith(this.b.b.W)) {//ad 小视频  //boolean值的存储实际是1和0，1为真、0为假；boolean型的值实际是转成int型的值进行操作。

//                XposedHelpers.getObjectField(this.a, this.b.b.X);//hbh
//                XposedHelpers.getObjectField(this.a, this.b.b.Y);//jMx
//                LinkedList linkedList = (LinkedList) XposedHelpers.getObjectField(this.a, this.b.b.Z);//jhw

                LinkedList linkedList = (LinkedList) XposedHelpers.getObjectField(XposedHelpers.getObjectField(XposedHelpers.getObjectField(this.a, this.b.b.X), this.b.b.Y), this.b.b.Z);
                Object o = linkedList.get(0);
//                String str = (String) XposedHelpers.getObjectField(this.a, this.b.b.X);//hbh
//                Object o1 = XposedHelpers.getObjectField(this.a, str);
//                Object o2 = XposedHelpers.getObjectField(o1, str);
//                Object o3 = XposedHelpers.getObjectField(o2, this.b.b.E);

                Object o3 = XposedHelpers.getObjectField(XposedHelpers.getObjectField(this.a, this.b.b.X), this.b.b.E);//jMu

                String str2 = (String) o3;

                Log.i("Chengel_HaltuD", "小视频linkedList.get(0)==" + o.getClass() + o.toString());
                Log.i("Chengel_HaltuD", "小视频str2==" + str2);
                this.b.a(o, str2);

            } else {//cond_1
                Object v5 = null;
                try {
                    if (this.a.getClass().toString().endsWith(this.b.b.ap)) {//ag 图片:com.tencent.mm.plugin.sns.ui.ag
                        Class o = this.b.o;
                        String u = this.b.b.U;//vo

                        Object o1 = XposedHelpers.getObjectField(this.a, this.b.b.V);//axD

                        v5 = XposedHelpers.callStaticMethod(o, u, new Object[]{o1});

                        Log.i("Chengel_HaltuD", "图片==" + u);
                        Log.i("Chengel_HaltuD", "图片==o1==" + o1.toString());
                        Log.i("Chengel_HaltuD", "图片==o2==" + v5.toString());

//                        String g = this.b.b.g;
//                        Intent intents = new Intent();
//                        intents.setClassName(getActivity().getApplicationContext(), g);//.plugin.sns.ui.SnsUploadUI 图片页面,链接页面
//
//                        intents.putExtra("Kdescription", "图片跳转页面");
//                        intents.putExtra("Ksnsupload_type",0);// 1:跳转链接页面 0:图片跳转页面 9:纯文字跳转页面
//                        intents.putExtra("Ksnsupload_title", "标题");
//                        intents.putExtra("Ksnsupload_link", "http://p.yiqifa.com/n?k=2mLErnDlWnjSrI6H2mLErI6HWNzlWn6H6nKS1nKFrnDeWNR7WQqDCJoXgBgHkQLErnBb6nzlWEDLrIW-&t=http://list.vip.com/699590.html");
//
//                        getActivity().startActivity(intents);
                    } else {//cond_2

                        try {
                            if (this.a.getClass().toString().endsWith(this.b.b.at)) {//m 链接:com.tencent.mm.plugin.sns.ui.m
                                Class q = this.b.q;
                                String aq = this.b.b.aq;//azi

                                Object o = XposedHelpers.callStaticMethod(q, aq, new Object[]{});

                                String av = this.b.b.av;//vo

                                Object o1 = XposedHelpers.getObjectField(this.a, this.b.b.au);//gHs

                                v5 = XposedHelpers.callMethod(o, av, new Object[]{o1});//v1

                                Log.i("Chengel_HaltuD", "链接==" + aq);
                                Log.i("Chengel_HaltuD", "链接==" + av);
                                Log.i("Chengel_HaltuD", "链接==o1==" + o1.toString());
                                Log.i("Chengel_HaltuD", "链接==o2==" + v5.toString());

//                                String g = this.b.b.g;
//                                Intent intents = new Intent();
//                                intents.setClassName(getActivity().getApplicationContext(), g);//.plugin.sns.ui.SnsUploadUI 图片页面,链接页面
//
//                                intents.putExtra("Kdescription", "跳转链接页面");
//                                intents.putExtra("Ksnsupload_type", 1);// 1:链接跳转页面 0:图片跳转页面 9:纯文字跳转页面
//                                intents.putExtra("Ksnsupload_title", "标题");
//                                intents.putExtra("Ksnsupload_link", "http://p.yiqifa.com/n?k=2mLErnDlWnjSrI6H2mLErI6HWNzlWn6H6nKS1nKFrnDeWNR7WQqDCJoXgBgHkQLErnBb6nzlWEDLrIW-&t=http://list.vip.com/699590.html");
//
//                                getActivity().startActivity(intents);

//                                move v4, v0
//
//                                move-object v5, v1
                            } else {//cond_3 aj 文字(暂时除了评论文字)文字:com.tencent.mm.plugin.sns.ui.aj

                                Class q = this.b.q;
                                String aq = this.b.b.aq;//azi

                                Object o = XposedHelpers.callStaticMethod(q, aq, new Object[]{});

                                String as = this.b.b.as;//vn

                                Object o1 = XposedHelpers.getObjectField(this.a, this.b.b.ar);//gPn

                                v5 = XposedHelpers.callMethod(o, as, new Object[]{o1});

                                Log.i("Chengel_HaltuD", "文字==" + aq);
                                Log.i("Chengel_HaltuD", "文字==" + as);
                                Log.i("Chengel_HaltuD", "文字==o1==" + o1.toString());
                                Log.i("Chengel_HaltuD", "文字==v5==" + v5.toString());

                                Class n = this.b.n;
                                byte[] field_content = (byte[]) XposedHelpers.getObjectField(v5, "field_content");
                                Object a = this.b.a(n, field_content);
                                String c1 = this.b.c(a);
//                                String r2 = this.b.r(c1);/** Modify By Gele **///
                                Log.i("Chengel_HaltuD", "其他==开始往下执行2==c1==" + c1);
//                                Log.i("Chengel_HaltuD", "其他==开始往下执行2==r2==" + r2);
                                this.b.b(c1);
                                return true;

//                                this.b.b("这个是纯文字吗?");
//
//                                String g = this.b.b.g;
//                                Intent intents = new Intent();
//                                intents.setClassName(getActivity().getApplicationContext(), g);//.plugin.sns.ui.SnsUploadUI 图片页面,链接页面
//
//                                intents.putExtra("Kdescription", "图片跳转页面");
//                                intents.putExtra("Ksnsupload_type", 9);// 1:跳转链接页面 2:图片跳转页面 9:纯文字跳转页面
//                                intents.putExtra("Ksnsupload_title", "标题");
//                                intents.putExtra("Ksnsupload_link", "http://p.yiqifa.com/n?k=2mLErnDlWnjSrI6H2mLErI6HWNzlWn6H6nKS1nKFrnDeWNR7WQqDCJoXgBgHkQLErnBb6nzlWEDLrIW-&t=http://list.vip.com/699590.html");
//
//                                getActivity().startActivity(intents);

//                                move-result-object v0
//
//                                move-object v1, v0
//
//                                move v0, v3
//                                move v4, v0
//
//                                move-object v5, v1
                            }
                        } catch (Throwable ss) {
                            b.a(ss);
                        }

                    }
                } catch (Throwable ss) {

                    b.a(ss);

                }

                Log.i("Chengel_HaltuD", "其他==开始往下执行0==");
                try {//:try_start_4

                    if (v5 != null) {//cond_4
                        int i = XposedHelpers.getIntField(v5, "field_type");
                        Log.i("Chengel_HaltuD", "其他==开始往下执行0==" + i);

                        if (i == 1 || i == 2 || i == 15 || i == 3 || i == 4) {// 15:发表动态文字(视频) 1:发表动态文字(图片) 2:发表动态文字(纯文字) 3:发表动态文字(链接)

                            Class n = this.b.n;
                            byte[] field_content = (byte[]) XposedHelpers.getObjectField(v5, "field_content");
                            Object a = this.b.a(n, field_content);


                            String g = this.b.b.g;
                            Intent intent = new Intent();
                            intent.setClassName(getActivity().getApplicationContext(), g);

                            String r = this.b.c(a);
                            Log.i("Chengel_HaltuD", "其他==开始往下执行1==c==" + r);//发表内容
//                            String r = this.b.r(c);/** Modify By Gele **/
//                            Log.i("Chengel_HaltuD", "其他==开始往下执行1==r==" + r);
                            intent.putExtra("Kdescription", r);


                            if (i == 1) {
                                String q = this.b.b.Q;
                                String o = (String) XposedHelpers.callMethod(v5, q, new Object[]{});
                                Log.i("Chengel_HaltuD", "其他==开始往下执行1==q==" + q);
                                Log.i("Chengel_HaltuD", "其他==开始往下执行1==o==" + o);

                                Class s = this.b.s;
                                String r1 = this.b.b.R;
                                Log.i("Chengel_HaltuD", "其他==开始往下执行1==r1==" + r1);

                                List o1 = (List) XposedHelpers.callStaticMethod(s, r1, new Object[]{o});
                                Log.i("Chengel_HaltuD", "其他==开始往下执行1==List==" + o1.size());
                                Log.i("Chengel_HaltuD", "其他==开始往下执行1==List==" + o1.getClass());
                                this.b.a(o1, r);

                                return true;
                            } else if (i == 2) {
                                String c1 = this.b.c(a);
//                                String r2 = this.b.r(c1);/** Modify By Gele **///
                                Log.i("Chengel_HaltuD", "其他==开始往下执行2==c1==" + c1);
//                                Log.i("Chengel_HaltuD", "其他==开始往下执行2==r2==" + r2);
                                this.b.b(c1);
                                return true;
                            } else if (i == 3) {
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==str==");
                                Object objectField = XposedHelpers.getObjectField(this.a, this.b.b.aA);
                                Object objectField1 = XposedHelpers.getObjectField(objectField, this.b.b.Y);


                                String str = (String) XposedHelpers.getObjectField(objectField1, this.b.b.ay);
                                String str1 = (String) XposedHelpers.getObjectField(objectField1, this.b.b.ax);

                                /** Modify By Gele **///此处可添加其他更多字段 例如: appid appname

                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==objectField==" + objectField.getClass());
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==objectField1==" + objectField1.getClass());
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==str==" + str);//链接标题 记录美国华人生存现状：奋斗中融入 仍保持自身传统
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==str1==" + str1);//链接网址 http://view.inews.qq.com/w/WXN201604220134740A0?w_f=bzA0SUJBQUJxNXdOVmVIanNMWTV5eVh4aldtQQ%3D%3D&w_c=1&isShare=1


                                String eiB = (String) XposedHelpers.getObjectField(objectField, "eiB");
                                String iHS = (String) XposedHelpers.getObjectField(objectField, "iHS");
                                String iHT = (String) XposedHelpers.getObjectField(objectField, "iHT");
                                String iXW = (String) XposedHelpers.getObjectField(objectField, "iXW");
                                String jMB = (String) XposedHelpers.getObjectField(objectField, "jMB");
                                String jMu = (String) XposedHelpers.getObjectField(objectField, "jMu");
                                String jMy = (String) XposedHelpers.getObjectField(objectField, "jMy");
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + eiB);//wxid_j4zacce87son22
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + iHS);
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + iHT);//吉林热点
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + iXW);//12246168397337399614
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jMB);
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jMu);//做微商的朋友们好好看看吧！是不是你也走上了传销的道路，是不是也在欺骗你身边的盆友们呢？
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jMy);//gh_99910f8279a6

                                String eiq = "";
                                LinkedList jhw = (LinkedList) XposedHelpers.getObjectField(objectField1, "jhw");
                                for ( i =0; i < jhw.size(); i++) {
                                    eiq = (String) XposedHelpers.getObjectField(jhw.get(i), b.b.ax);

                                    /*String asP = (String) XposedHelpers.getObjectField(jhw.get(i), "asP");
                                    String aut = (String) XposedHelpers.getObjectField(jhw.get(i), "aut");
                                    String eia = (String) XposedHelpers.getObjectField(jhw.get(i), "eia");
                                    String gXF = (String) XposedHelpers.getObjectField(jhw.get(i), "gXF");
                                    String iXWs = (String) XposedHelpers.getObjectField(jhw.get(i), "iXW");
                                    String jzA = (String) XposedHelpers.getObjectField(jhw.get(i), "jzA");
                                    String jzB = (String) XposedHelpers.getObjectField(jhw.get(i), "jzB");
                                    String jzC = (String) XposedHelpers.getObjectField(jhw.get(i), "jzC");
                                    String jzD = (String) XposedHelpers.getObjectField(jhw.get(i), "jzD");
                                    String jzE = (String) XposedHelpers.getObjectField(jhw.get(i), "jzE");
                                    String jzG = (String) XposedHelpers.getObjectField(jhw.get(i), "jzG");
                                    String jzt = (String) XposedHelpers.getObjectField(jhw.get(i), b.b.ax);
                                    String jzx = (String) XposedHelpers.getObjectField(jhw.get(i), "jzx");
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + asP);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + aut);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + eia);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + eiq);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + gXF);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + iXWs);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jzA);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jzB);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jzC);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jzD);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jzE);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jzG);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jzt);
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==imgurl==" + jzx);*/
                                }

                                if (str.contains("http://")) {

                                    str = str.split(" ")[0];/** Modify By Gele **///s1
                                    Log.i("Chengel_HaltuD", "其他==开始往下执行3==strsplit==" + str);
                                }
                                //cond_7
                                intent.putExtra("Ksnsupload_type", 1);
                                intent.putExtra("Ksnsupload_title", str);/** Modify By Gele **///s1
                                intent.putExtra("Ksnsupload_link", str1);
                                intent.putExtra("Ksnsupload_imgurl", eiq);

                                LinkedList linkedList = (LinkedList) XposedHelpers.getObjectField(objectField1, this.b.b.Z);
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==linkedList==" + linkedList.size());
                                Log.i("Chengel_HaltuD", "其他==开始往下执行3==linkedList==" + linkedList.getClass());

                                if (linkedList == null) {

                                    if (linkedList.isEmpty()) {//cond_6
                                        Activity f = this.b.f;
                                        getActivity().startActivity(intent);
                                        return true;
                                    } else {
                                        Object o2 = linkedList.get(0);

                                        String s2 = (String) XposedHelpers.getObjectField(o2, this.b.b.az);

                                        Log.i("Chengel_HaltuD", "其他==开始往下执行3==s2==" + s2);

                                        if (TextUtils.isEmpty(s2)) {//cond_6

                                            Activity f = this.b.f;
                                            getActivity().startActivity(intent);
                                            return true;
                                        } else {
                                            Log.i("Chengel_HaltuD", "其他==开始往下执行3==s2==" + s2);
                                            aa.a("", new af(this, intent));//new ae(b, a)
                                            return true;

                                        }
                                    }
                                } else {//cond_6
                                    Activity f = this.b.f;
                                    getActivity().startActivity(intent);
                                    return true;
                                }
                            } else if (i == 3) {
                                Log.i("Chengel_HaltuD", "其他==开始往下执行4==linkedList==");

                                Object a1 = this.a;
                                Object objectField2 = XposedHelpers.getObjectField(a1, this.b.b.aA);
                                Object objectField3 = XposedHelpers.getObjectField(objectField2, this.b.b.Y);

                                intent.putExtra("Ksnsupload_type", 2);
                                LinkedList linkedList = (LinkedList) XposedHelpers.getObjectField(objectField3, this.b.b.Z);

                                Log.i("Chengel_HaltuD", "其他==开始往下执行4==linkedList==" + linkedList.size());
                                Log.i("Chengel_HaltuD", "其他==开始往下执行4==linkedList==" + linkedList.getClass());

                                if (linkedList == null) {
                                    if (linkedList.isEmpty()) {//cond_0

                                    } else {
                                        Object o2 = linkedList.get(0);

                                        String s2 = (String) XposedHelpers.getObjectField(o2, this.b.b.az);
                                        String s3 = (String) XposedHelpers.getObjectField(o2, this.b.b.ay);
                                        String s4 = (String) XposedHelpers.getObjectField(o2, this.b.b.ax);

                                        Log.i("Chengel_HaltuD", "其他==开始往下执行4==s2==" + s2);
                                        Log.i("Chengel_HaltuD", "其他==开始往下执行4==s3==" + s3);
                                        Log.i("Chengel_HaltuD", "其他==开始往下执行4==s4==" + s4);

                                        intent.putExtra("Ksnsupload_title", s3);
                                        intent.putExtra("Ksnsupload_link", s3);
                                        intent.putExtra("Ksnsupload_title", s4);

                                        aa.a(s2, new ag(this, intent, s4, s3));//new ae(this.b, this.a)
                                        return true;
                                    }


                                } else {//cond_0

                                }
                            } else if (i == 15) {
                                this.b.b(r);
                            }


                            return true;

                                /*if (0 == 0)
                                    switch (1) {
                                    case 2://图片?

                                        String q = this.b.b.Q;
                                        String o = (String) XposedHelpers.callMethod(v5, q, new Object[]{});
                                        Log.i("Chengel_HaltuD", "其他==开始往下执行2==q=="+q);
                                        Log.i("Chengel_HaltuD", "其他==开始往下执行2==o=="+o);

                                        Class s = this.b.s;
                                        String r1 = this.b.b.R;
                                        Log.i("Chengel_HaltuD", "其他==开始往下执行2==o=="+o);

                                        List o1 = (List) XposedHelpers.callStaticMethod(s, r1, new Object[]{o});

                                        this.b.a(o1, r);

                                        return true;

                                    case 3://纯文字?

                                        String c1 = this.b.c(a);
                                        String r2 = this.b.r(c1);

                                        this.b.b(r2);
                                        return true;
                                    case 4://链接?
                                        Object objectField = XposedHelpers.getObjectField(this.a, this.b.b.aA);
                                        Object objectField1 = XposedHelpers.getObjectField(objectField, this.b.b.Y);

                                        String str = (String) XposedHelpers.getObjectField(objectField1, this.b.b.ay);
                                        String str1 = (String) XposedHelpers.getObjectField(objectField1, this.b.b.ax);

                                        String s1 = null;
                                        if (str.contains("http://")) {

                                            s1 = str.split(" ")[0];

                                        } else {//cond_7
                                            intent.putExtra("Ksnsupload_type", 1);
                                            intent.putExtra("Ksnsupload_title", s1);
                                            intent.putExtra("Ksnsupload_link", str1);

                                            LinkedList linkedList = (LinkedList) XposedHelpers.getObjectField(objectField1, this.b.b.Z);

                                            if (linkedList == null) {

                                                if (linkedList.isEmpty()) {//cond_6
                                                    Activity f = this.b.f;
                                                    getActivity().startActivity(intent);
                                                    return true;
                                                } else {
                                                    Object o2 = linkedList.get(0);

                                                    String s2 = (String) XposedHelpers.getObjectField(o2, this.b.b.az);

                                                    if (TextUtils.isEmpty(s2)) {//cond_6

                                                        Activity f = this.b.f;
                                                        f.startActivity(intent);
                                                        return true;
                                                    } else {

                                                        aa.a("", new af(new ae(b, a), intent));
                                                        return true;

                                                    }
                                                }
                                            } else {//cond_6
                                                Activity f = this.b.f;
                                                f.startActivity(intent);
                                                return true;
                                            }
                                        }

                                    case 5:

                                        Object a1 = this.a;
                                        Object objectField2 = XposedHelpers.getObjectField(a1, this.b.b.aA);
                                        Object objectField3 = XposedHelpers.getObjectField(objectField2, this.b.b.Y);

                                        intent.putExtra("Ksnsupload_type", 2);
                                        LinkedList linkedList = (LinkedList) XposedHelpers.getObjectField(objectField3, this.b.b.Z);


                                        if (linkedList == null) {
                                            if (linkedList.isEmpty()) {//cond_0

                                            } else {
                                                Object o2 = linkedList.get(0);

                                                String s2 = (String) XposedHelpers.getObjectField(o2, this.b.b.az);
                                                String s3 = (String) XposedHelpers.getObjectField(o2, this.b.b.ay);
                                                String s4 = (String) XposedHelpers.getObjectField(o2, this.b.b.ax);

                                                intent.putExtra("Ksnsupload_title", s3);
                                                intent.putExtra("Ksnsupload_link", s3);
                                                intent.putExtra("Ksnsupload_title", s4);

                                                aa.a(s2, new ag(this, intent, s4, s3));//new ae(this.b, this.a)
                                                return true;
                                            }


                                        } else {//cond_0

                                        }

                                    default:
                                        break;

                                }
                                else if (i == 1) {

                                } else if (i == 2) {

                                } else {

                                }*/

                        }/* else if (i == 2) {
                            Log.i("Chengel_HaltuD", "其他==开始往下执行3==");
                        } else if (i == 15) {//cond_5
                            Log.i("Chengel_HaltuD", "其他==开始往下执行4==");
                        } else if (i == 3) {
                            Log.i("Chengel_HaltuD", "其他==开始往下执行5==");
                        } else if (i == 4) {
                            Log.i("Chengel_HaltuD", "其他==开始往下执行6==");
                        } */ else {
                            Log.i("Chengel_HaltuD", "其他==开始往下执行7==");
                            this.b.p("不支持发送这类内容");
                            return true;
                        }

                    } else {
                        Log.i("Chengel_HaltuD", "其他==开始往下执行8==");
                        try {//:try_start_2

                            String a = this.b.b.a;
//                          this.b.a("sns_forward_not_supported","不支持发送这类内容");

                            this.b.p("不支持发送这类内容");
                        } catch (Throwable sss) {
                            b.a(sss);
                            return true;
                        }
                    }
                    Log.i("Chengel_HaltuD", "其他==开始往下执行9==");
                } catch (Throwable sss) {


                }


            }

        } catch (Throwable ss) {

            b.a(ss);

        }

        return true;
        // Byte code:
        //   0: iconst_0
        //   1: istore_2
        //   2: aload_0
        //   3: getfield 16	com/fkzhang/wechatforwarder/b/ae:a	Ljava/lang/Object;
        //   6: invokevirtual 28	java/lang/Object:getClass	()Ljava/lang/Class;
        //   9: invokevirtual 34	java/lang/Class:toString	()Ljava/lang/String;
        //   12: astore_1
        //   13: aload_1
        //   14: aload_0
        //   15: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   18: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   21: getfield 45	com/fkzhang/wechatforwarder/f:W	Ljava/lang/String;
        //   24: invokevirtual 51	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   27: ifeq +101 -> 128
        //   30: aload_0
        //   31: getfield 16	com/fkzhang/wechatforwarder/b/ae:a	Ljava/lang/Object;
        //   34: aload_0
        //   35: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   38: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   41: getfield 54	com/fkzhang/wechatforwarder/f:X	Ljava/lang/String;
        //   44: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   47: aload_0
        //   48: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   51: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   54: getfield 63	com/fkzhang/wechatforwarder/f:Y	Ljava/lang/String;
        //   57: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   60: aload_0
        //   61: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   64: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   67: getfield 66	com/fkzhang/wechatforwarder/f:Z	Ljava/lang/String;
        //   70: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   73: checkcast 68	java/util/LinkedList
        //   76: iconst_0
        //   77: invokevirtual 72	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   80: astore_1
        //   81: aload_0
        //   82: getfield 16	com/fkzhang/wechatforwarder/b/ae:a	Ljava/lang/Object;
        //   85: aload_0
        //   86: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   89: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   92: getfield 54	com/fkzhang/wechatforwarder/f:X	Ljava/lang/String;
        //   95: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   98: aload_0
        //   99: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   102: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   105: getfield 75	com/fkzhang/wechatforwarder/f:E	Ljava/lang/String;
        //   108: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   111: checkcast 47	java/lang/String
        //   114: astore 4
        //   116: aload_0
        //   117: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   120: aload_1
        //   121: aload 4
        //   123: invokevirtual 78	com/fkzhang/wechatforwarder/b/a:a	(Ljava/lang/Object;Ljava/lang/String;)V
        //   126: iconst_1
        //   127: ireturn
        //   128: aload_1
        //   129: aload_0
        //   130: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   133: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   136: getfield 81	com/fkzhang/wechatforwarder/f:ap	Ljava/lang/String;
        //   139: invokevirtual 51	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   142: ifeq +82 -> 224
        //   145: aload_0
        //   146: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   149: getfield 85	com/fkzhang/wechatforwarder/b/a:o	Ljava/lang/Class;
        //   152: aload_0
        //   153: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   156: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   159: getfield 88	com/fkzhang/wechatforwarder/f:U	Ljava/lang/String;
        //   162: iconst_1
        //   163: anewarray 4	java/lang/Object
        //   166: dup
        //   167: iconst_0
        //   168: aload_0
        //   169: getfield 16	com/fkzhang/wechatforwarder/b/ae:a	Ljava/lang/Object;
        //   172: aload_0
        //   173: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   176: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   179: getfield 91	com/fkzhang/wechatforwarder/f:V	Ljava/lang/String;
        //   182: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   185: aastore
        //   186: invokestatic 95	de/robv/android/xposed/XposedHelpers:callStaticMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
        //   189: astore_1
        //   190: aload_1
        //   191: ifnonnull +194 -> 385
        //   194: aload_0
        //   195: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   198: aload_0
        //   199: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   202: getfield 98	com/fkzhang/wechatforwarder/b/a:a	Lcom/fkzhang/wechatforwarder/c/g;
        //   205: ldc 100
        //   207: ldc 102
        //   209: invokevirtual 107	com/fkzhang/wechatforwarder/c/g:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   212: invokevirtual 111	com/fkzhang/wechatforwarder/b/a:p	(Ljava/lang/String;)V
        //   215: iconst_1
        //   216: ireturn
        //   217: astore_1
        //   218: aload_1
        //   219: invokestatic 114	com/fkzhang/wechatforwarder/b/a:a	(Ljava/lang/Throwable;)V
        //   222: iconst_1
        //   223: ireturn
        //   224: aload_1
        //   225: aload_0
        //   226: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   229: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   232: getfield 117	com/fkzhang/wechatforwarder/f:at	Ljava/lang/String;
        //   235: invokevirtual 51	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   238: ifeq +68 -> 306
        //   241: aload_0
        //   242: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   245: getfield 120	com/fkzhang/wechatforwarder/b/a:q	Ljava/lang/Class;
        //   248: aload_0
        //   249: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   252: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   255: getfield 123	com/fkzhang/wechatforwarder/f:aq	Ljava/lang/String;
        //   258: iconst_0
        //   259: anewarray 4	java/lang/Object
        //   262: invokestatic 95	de/robv/android/xposed/XposedHelpers:callStaticMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
        //   265: aload_0
        //   266: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   269: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   272: getfield 126	com/fkzhang/wechatforwarder/f:av	Ljava/lang/String;
        //   275: iconst_1
        //   276: anewarray 4	java/lang/Object
        //   279: dup
        //   280: iconst_0
        //   281: aload_0
        //   282: getfield 16	com/fkzhang/wechatforwarder/b/ae:a	Ljava/lang/Object;
        //   285: aload_0
        //   286: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   289: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   292: getfield 129	com/fkzhang/wechatforwarder/f:au	Ljava/lang/String;
        //   295: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   298: aastore
        //   299: invokestatic 133	de/robv/android/xposed/XposedHelpers:callMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
        //   302: astore_1
        //   303: goto -113 -> 190
        //   306: aload_0
        //   307: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   310: getfield 120	com/fkzhang/wechatforwarder/b/a:q	Ljava/lang/Class;
        //   313: aload_0
        //   314: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   317: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   320: getfield 123	com/fkzhang/wechatforwarder/f:aq	Ljava/lang/String;
        //   323: iconst_0
        //   324: anewarray 4	java/lang/Object
        //   327: invokestatic 95	de/robv/android/xposed/XposedHelpers:callStaticMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
        //   330: aload_0
        //   331: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   334: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   337: getfield 136	com/fkzhang/wechatforwarder/f:as	Ljava/lang/String;
        //   340: iconst_1
        //   341: anewarray 4	java/lang/Object
        //   344: dup
        //   345: iconst_0
        //   346: aload_0
        //   347: getfield 16	com/fkzhang/wechatforwarder/b/ae:a	Ljava/lang/Object;
        //   350: aload_0
        //   351: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   354: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   357: getfield 139	com/fkzhang/wechatforwarder/f:ar	Ljava/lang/String;
        //   360: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   363: aastore
        //   364: invokestatic 133	de/robv/android/xposed/XposedHelpers:callMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
        //   367: astore_1
        //   368: iconst_1
        //   369: istore_2
        //   370: goto -180 -> 190
        //   373: astore_1
        //   374: aload_1
        //   375: invokestatic 114	com/fkzhang/wechatforwarder/b/a:a	(Ljava/lang/Throwable;)V
        //   378: aconst_null
        //   379: astore_1
        //   380: iconst_0
        //   381: istore_2
        //   382: goto -192 -> 190
        //   385: aload_1
        //   386: ldc 141
        //   388: invokestatic 145	de/robv/android/xposed/XposedHelpers:getIntField	(Ljava/lang/Object;Ljava/lang/String;)I
        //   391: istore_3
        //   392: iload_3
        //   393: iconst_1
        //   394: if_icmpeq +47 -> 441
        //   397: iload_3
        //   398: iconst_2
        //   399: if_icmpeq +42 -> 441
        //   402: iload_3
        //   403: bipush 15
        //   405: if_icmpeq +36 -> 441
        //   408: iload_3
        //   409: iconst_3
        //   410: if_icmpeq +31 -> 441
        //   413: iload_3
        //   414: iconst_4
        //   415: if_icmpeq +26 -> 441
        //   418: aload_0
        //   419: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   422: aload_0
        //   423: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   426: getfield 98	com/fkzhang/wechatforwarder/b/a:a	Lcom/fkzhang/wechatforwarder/c/g;
        //   429: ldc 100
        //   431: ldc 102
        //   433: invokevirtual 107	com/fkzhang/wechatforwarder/c/g:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   436: invokevirtual 111	com/fkzhang/wechatforwarder/b/a:p	(Ljava/lang/String;)V
        //   439: iconst_1
        //   440: ireturn
        //   441: aload_0
        //   442: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   445: aload_0
        //   446: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   449: getfield 148	com/fkzhang/wechatforwarder/b/a:n	Ljava/lang/Class;
        //   452: aload_1
        //   453: ldc 150
        //   455: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   458: checkcast 152	[B
        //   461: checkcast 152	[B
        //   464: invokevirtual 155	com/fkzhang/wechatforwarder/b/a:a	(Ljava/lang/Class;[B)Ljava/lang/Object;
        //   467: astore 6
        //   469: new 157	android/content/Intent
        //   472: dup
        //   473: invokespecial 158	android/content/Intent:<init>	()V
        //   476: astore 5
        //   478: aload 5
        //   480: aload_0
        //   481: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   484: getfield 162	com/fkzhang/wechatforwarder/b/a:f	Landroid/app/Activity;
        //   487: invokevirtual 168	android/app/Activity:getApplicationContext	()Landroid/content/Context;
        //   490: aload_0
        //   491: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   494: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   497: getfield 171	com/fkzhang/wechatforwarder/f:g	Ljava/lang/String;
        //   500: invokevirtual 175	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
        //   503: pop
        //   504: aload_0
        //   505: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   508: aload 6
        //   510: invokevirtual 179	com/fkzhang/wechatforwarder/b/a:c	(Ljava/lang/Object;)Ljava/lang/String;
        //   513: invokestatic 183	com/fkzhang/wechatforwarder/b/a:r	(Ljava/lang/String;)Ljava/lang/String;
        //   516: astore 4
        //   518: aload 5
        //   520: ldc 185
        //   522: aload 4
        //   524: invokevirtual 189	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   527: pop
        //   528: iload_2
        //   529: ifeq +492 -> 1021
        //   532: iload_3
        //   533: iconst_1
        //   534: if_icmpeq +487 -> 1021
        //   537: iload_3
        //   538: iconst_2
        //   539: if_icmpeq +482 -> 1021
        //   542: iconst_2
        //   543: istore_2
        //   544: goto +479 -> 1023
        //   547: aload_0
        //   548: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   551: getfield 162	com/fkzhang/wechatforwarder/b/a:f	Landroid/app/Activity;
        //   554: aload 5
        //   556: invokevirtual 193	android/app/Activity:startActivity	(Landroid/content/Intent;)V
        //   559: iconst_1
        //   560: ireturn
        //   561: aload_1
        //   562: aload_0
        //   563: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   566: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   569: getfield 196	com/fkzhang/wechatforwarder/f:Q	Ljava/lang/String;
        //   572: iconst_0
        //   573: anewarray 4	java/lang/Object
        //   576: invokestatic 133	de/robv/android/xposed/XposedHelpers:callMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
        //   579: checkcast 47	java/lang/String
        //   582: astore_1
        //   583: aload_0
        //   584: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   587: getfield 199	com/fkzhang/wechatforwarder/b/a:s	Ljava/lang/Class;
        //   590: aload_0
        //   591: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   594: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   597: getfield 202	com/fkzhang/wechatforwarder/f:R	Ljava/lang/String;
        //   600: iconst_1
        //   601: anewarray 4	java/lang/Object
        //   604: dup
        //   605: iconst_0
        //   606: aload_1
        //   607: aastore
        //   608: invokestatic 95	de/robv/android/xposed/XposedHelpers:callStaticMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
        //   611: checkcast 204	java/util/List
        //   614: astore_1
        //   615: aload_0
        //   616: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   619: aload_1
        //   620: aload 4
        //   622: invokevirtual 207	com/fkzhang/wechatforwarder/b/a:a	(Ljava/util/List;Ljava/lang/String;)V
        //   625: iconst_1
        //   626: ireturn
        //   627: aload_0
        //   628: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   631: aload_0
        //   632: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   635: aload 6
        //   637: invokevirtual 179	com/fkzhang/wechatforwarder/b/a:c	(Ljava/lang/Object;)Ljava/lang/String;
        //   640: invokestatic 183	com/fkzhang/wechatforwarder/b/a:r	(Ljava/lang/String;)Ljava/lang/String;
        //   643: invokevirtual 209	com/fkzhang/wechatforwarder/b/a:b	(Ljava/lang/String;)V
        //   646: iconst_1
        //   647: ireturn
        //   648: aload_0
        //   649: getfield 16	com/fkzhang/wechatforwarder/b/ae:a	Ljava/lang/Object;
        //   652: aload_0
        //   653: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   656: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   659: getfield 212	com/fkzhang/wechatforwarder/f:aA	Ljava/lang/String;
        //   662: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   665: aload_0
        //   666: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   669: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   672: getfield 63	com/fkzhang/wechatforwarder/f:Y	Ljava/lang/String;
        //   675: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   678: astore 6
        //   680: aload 6
        //   682: aload_0
        //   683: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   686: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   689: getfield 215	com/fkzhang/wechatforwarder/f:ay	Ljava/lang/String;
        //   692: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   695: checkcast 47	java/lang/String
        //   698: astore 4
        //   700: aload 6
        //   702: aload_0
        //   703: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   706: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   709: getfield 218	com/fkzhang/wechatforwarder/f:ax	Ljava/lang/String;
        //   712: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   715: checkcast 47	java/lang/String
        //   718: astore 7
        //   720: aload 4
        //   722: astore_1
        //   723: aload 4
        //   725: ldc 220
        //   727: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   730: ifeq +13 -> 743
        //   733: aload 4
        //   735: ldc 226
        //   737: invokevirtual 230	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   740: iconst_0
        //   741: aaload
        //   742: astore_1
        //   743: aload 5
        //   745: ldc 232
        //   747: iconst_1
        //   748: invokevirtual 235	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   751: pop
        //   752: aload 5
        //   754: ldc 237
        //   756: aload_1
        //   757: invokevirtual 189	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   760: pop
        //   761: aload 5
        //   763: ldc 239
        //   765: aload 7
        //   767: invokevirtual 189	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   770: pop
        //   771: aload 6
        //   773: aload_0
        //   774: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   777: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   780: getfield 66	com/fkzhang/wechatforwarder/f:Z	Ljava/lang/String;
        //   783: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   786: checkcast 68	java/util/LinkedList
        //   789: astore_1
        //   790: aload_1
        //   791: ifnull -244 -> 547
        //   794: aload_1
        //   795: invokevirtual 243	java/util/LinkedList:isEmpty	()Z
        //   798: ifne -251 -> 547
        //   801: aload_1
        //   802: iconst_0
        //   803: invokevirtual 72	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   806: aload_0
        //   807: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   810: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   813: getfield 246	com/fkzhang/wechatforwarder/f:az	Ljava/lang/String;
        //   816: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   819: checkcast 47	java/lang/String
        //   822: astore_1
        //   823: aload_1
        //   824: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   827: ifne -280 -> 547
        //   830: aload_1
        //   831: new 252	com/fkzhang/wechatforwarder/b/af
        //   834: dup
        //   835: aload_0
        //   836: aload 5
        //   838: invokespecial 255	com/fkzhang/wechatforwarder/b/af:<init>	(Lcom/fkzhang/wechatforwarder/b/ae;Landroid/content/Intent;)V
        //   841: invokestatic 260	com/fkzhang/wechatforwarder/c/a:a	(Ljava/lang/String;Lcom/fkzhang/wechatforwarder/c/f;)V
        //   844: iconst_1
        //   845: ireturn
        //   846: aload_0
        //   847: getfield 16	com/fkzhang/wechatforwarder/b/ae:a	Ljava/lang/Object;
        //   850: aload_0
        //   851: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   854: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   857: getfield 212	com/fkzhang/wechatforwarder/f:aA	Ljava/lang/String;
        //   860: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   863: aload_0
        //   864: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   867: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   870: getfield 63	com/fkzhang/wechatforwarder/f:Y	Ljava/lang/String;
        //   873: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   876: astore_1
        //   877: aload 5
        //   879: ldc 232
        //   881: iconst_2
        //   882: invokevirtual 235	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   885: pop
        //   886: aload_1
        //   887: aload_0
        //   888: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   891: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   894: getfield 66	com/fkzhang/wechatforwarder/f:Z	Ljava/lang/String;
        //   897: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   900: checkcast 68	java/util/LinkedList
        //   903: astore_1
        //   904: aload_1
        //   905: ifnull -779 -> 126
        //   908: aload_1
        //   909: invokevirtual 243	java/util/LinkedList:isEmpty	()Z
        //   912: ifne -786 -> 126
        //   915: aload_1
        //   916: iconst_0
        //   917: invokevirtual 72	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   920: astore 6
        //   922: aload 6
        //   924: aload_0
        //   925: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   928: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   931: getfield 246	com/fkzhang/wechatforwarder/f:az	Ljava/lang/String;
        //   934: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   937: checkcast 47	java/lang/String
        //   940: astore_1
        //   941: aload 6
        //   943: aload_0
        //   944: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   947: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   950: getfield 215	com/fkzhang/wechatforwarder/f:ay	Ljava/lang/String;
        //   953: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   956: checkcast 47	java/lang/String
        //   959: astore 4
        //   961: aload 6
        //   963: aload_0
        //   964: getfield 14	com/fkzhang/wechatforwarder/b/ae:b	Lcom/fkzhang/wechatforwarder/b/a;
        //   967: getfield 39	com/fkzhang/wechatforwarder/b/a:b	Lcom/fkzhang/wechatforwarder/f;
        //   970: getfield 218	com/fkzhang/wechatforwarder/f:ax	Ljava/lang/String;
        //   973: invokestatic 60	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
        //   976: checkcast 47	java/lang/String
        //   979: astore 6
        //   981: aload 5
        //   983: ldc 237
        //   985: aload 4
        //   987: invokevirtual 189	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   990: pop
        //   991: aload 5
        //   993: ldc 239
        //   995: aload 6
        //   997: invokevirtual 189	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   1000: pop
        //   1001: aload_1
        //   1002: new 262	com/fkzhang/wechatforwarder/b/ag
        //   1005: dup
        //   1006: aload_0
        //   1007: aload 5
        //   1009: aload 6
        //   1011: aload 4
        //   1013: invokespecial 265	com/fkzhang/wechatforwarder/b/ag:<init>	(Lcom/fkzhang/wechatforwarder/b/ae;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)V
        //   1016: invokestatic 260	com/fkzhang/wechatforwarder/c/a:a	(Ljava/lang/String;Lcom/fkzhang/wechatforwarder/c/f;)V
        //   1019: iconst_1
        //   1020: ireturn
        //   1021: iload_3
        //   1022: istore_2
        //   1023: iload_2
        //   1024: tableswitch	default:+32 -> 1056, 1:+-463->561, 2:+-397->627, 3:+-376->648, 4:+-178->846
        //   1057: impdep1
        //   1058: iconst_0
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1059	0	this	ae
        //   0	1059	1	paramMenuItem	android.view.MenuItem
        //   1	1023	2	i	int
        //   391	631	3	j	int
        //   114	898	4	str1	java.lang.String
        //   476	532	5	localIntent	android.content.Intent
        //   467	543	6	localObject	Object
        //   718	48	7	str2	java.lang.String
        // Exception table:
        //   from	to	target	type
        //   2	126	217	java/lang/Throwable
        //   194	215	217	java/lang/Throwable
        //   374	378	217	java/lang/Throwable
        //   385	392	217	java/lang/Throwable
        //   418	439	217	java/lang/Throwable
        //   441	528	217	java/lang/Throwable
        //   547	559	217	java/lang/Throwable
        //   561	625	217	java/lang/Throwable
        //   627	646	217	java/lang/Throwable
        //   648	720	217	java/lang/Throwable
        //   723	743	217	java/lang/Throwable
        //   743	790	217	java/lang/Throwable
        //   794	844	217	java/lang/Throwable
        //   846	904	217	java/lang/Throwable
        //   908	1019	217	java/lang/Throwable
        //   128	190	373	java/lang/Throwable
        //   224	303	373	java/lang/Throwable
        //   306	368	373	java/lang/Throwable
    }
}



/* Location:           C:\Users\John\Desktop\APKDecompile\projects\fkzhang.wechatforwarder_13\ProjectSrc\smali\

 * Qualified Name:     com.fkzhang.wechatforwarder.b.ae

 * JD-Core Version:    0.7.0.1

 */