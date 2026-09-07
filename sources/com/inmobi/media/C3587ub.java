package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.ub, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3587ub {
    public static String d;
    public static boolean e;
    public static long f;
    public static final SignalsConfig.SessionConfig h;
    public static final AtomicBoolean i;
    public static final K5 j;
    public static final C3391h1 k;
    public static final C3391h1 l;
    public static final /* synthetic */ KProperty[] b = {Reflection.property1(new PropertyReference1Impl(C3587ub.class, "sessionCnt", "getSessionCnt()I", 0)), Reflection.property1(new PropertyReference1Impl(C3587ub.class, "userRetention", "getUserRetention()I", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3587ub f3446a = new C3587ub();
    public static final String c = "ub";
    public static final List g = CollectionsKt.mutableListOf(0, 0, 0, 0);

    static {
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        K5 k5A = null;
        h = ((SignalsConfig) B4.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getSession();
        i = new AtomicBoolean(false);
        Context contextD = C3517pb.d();
        if (contextD != null) {
            ConcurrentHashMap concurrentHashMap = K5.b;
            k5A = J5.a(contextD, "session_pref_file");
        }
        j = k5A;
        k = new C3391h1((Integer) (-1), (Function0) C3559sb.f3430a, false, 12);
        l = new C3391h1((Integer) (-1), (Function0) C3573tb.f3436a, false, 12);
    }

    public static int a() {
        K5 k5 = j;
        if (k5 == null) {
            return 0;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter("u-ret", "key");
        return Integer.min((int) ((jCurrentTimeMillis - k5.f3112a.getLong("u-ret", jCurrentTimeMillis)) / 86400000), Integer.MAX_VALUE);
    }

    public static void c() {
        if (i.getAndSet(true)) {
            return;
        }
        if (C3601vb.a().getSessionEnabled()) {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            d = string;
            String TAG = c;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
        f = System.currentTimeMillis() - Process.getElapsedCpuTime();
        if (a(5)) {
            K5 k5 = j;
            if (k5 != null) {
                Intrinsics.checkNotNullParameter(com.safedk.android.analytics.brandsafety.l.R, "key");
                int iMin = Integer.min(k5.f3112a.getInt(com.safedk.android.analytics.brandsafety.l.R, 0) + 1, Integer.MAX_VALUE);
                Intrinsics.checkNotNullParameter(com.safedk.android.analytics.brandsafety.l.R, "key");
                SharedPreferences.Editor editorEdit = k5.f3112a.edit();
                editorEdit.putInt(com.safedk.android.analytics.brandsafety.l.R, iMin);
                editorEdit.apply();
            }
            k.a();
        }
        if (a(6)) {
            K5 k6 = j;
            if (k6 != null) {
                Intrinsics.checkNotNullParameter("u-ret", "key");
                if (!k6.f3112a.contains("u-ret")) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Intrinsics.checkNotNullParameter("u-ret", "key");
                    SharedPreferences.Editor editorEdit2 = k6.f3112a.edit();
                    editorEdit2.putLong("u-ret", jCurrentTimeMillis);
                    editorEdit2.apply();
                }
            }
            l.a();
        }
    }

    public final JSONObject b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (a(0)) {
            linkedHashMap.put("st", Long.valueOf(f));
        }
        if (a(5)) {
            C3391h1 c3391h1 = k;
            KProperty[] kPropertyArr = b;
            if (((Number) c3391h1.getValue(this, kPropertyArr[0])).intValue() != -1) {
                linkedHashMap.put(com.safedk.android.analytics.brandsafety.l.R, Integer.valueOf(((Number) c3391h1.getValue(this, kPropertyArr[0])).intValue()));
            }
        }
        if (a(6)) {
            C3391h1 c3391h2 = l;
            KProperty[] kPropertyArr2 = b;
            if (((Number) c3391h2.getValue(this, kPropertyArr2[1])).intValue() != -1) {
                linkedHashMap.put("u-ret", Integer.valueOf(((Number) c3391h2.getValue(this, kPropertyArr2[1])).intValue()));
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) g);
        if (!a(1)) {
            mutableList.set(0, -1);
        }
        if (!a(2)) {
            mutableList.set(1, -1);
        }
        if (!a(3)) {
            mutableList.set(2, -1);
        }
        if (!a(4)) {
            mutableList.set(3, -1);
        }
        if (!(mutableList instanceof Collection) || !mutableList.isEmpty()) {
            Iterator it = mutableList.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() != -1) {
                    linkedHashMap.put("dep", mutableList);
                    break;
                }
            }
        }
        try {
            return new JSONObject(linkedHashMap);
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public static boolean a(int i2) {
        return h.getSigControlList().contains(Integer.valueOf(i2));
    }

    public static void a(String adtype, Boolean bool) {
        Intrinsics.checkNotNullParameter(adtype, "adtype");
        if (Intrinsics.areEqual(adtype, "banner") && a(1)) {
            List list = g;
            list.set(0, Integer.valueOf(Integer.min(((Number) list.get(0)).intValue() + 1, Integer.MAX_VALUE)));
        }
        if (Intrinsics.areEqual(adtype, com.safedk.android.analytics.brandsafety.l.w) && !Intrinsics.areEqual(bool, Boolean.TRUE) && a(2)) {
            List list2 = g;
            list2.set(1, Integer.valueOf(Integer.min(((Number) list2.get(1)).intValue() + 1, Integer.MAX_VALUE)));
        }
        if (Intrinsics.areEqual(adtype, "native") && a(4)) {
            List list3 = g;
            list3.set(3, Integer.valueOf(Integer.min(((Number) list3.get(3)).intValue() + 1, Integer.MAX_VALUE)));
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE) && a(3)) {
            List list4 = g;
            list4.set(2, Integer.valueOf(Integer.min(((Number) list4.get(2)).intValue() + 1, Integer.MAX_VALUE)));
        }
    }
}
