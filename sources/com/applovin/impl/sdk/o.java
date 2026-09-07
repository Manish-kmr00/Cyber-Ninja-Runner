package com.applovin.impl.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.s2;
import com.applovin.impl.v4;
import com.json.b9;

/* JADX INFO: loaded from: classes4.dex */
public class o {
    private static boolean b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f683a;

    o(k kVar) {
        this.f683a = kVar;
        a("SDK Session Begin");
    }

    public static void a(boolean z) {
        b = z;
    }

    public static void c(String str, String str2, Throwable th) {
        if (!b || a()) {
            Log.e("AppLovinSdk", b9.i.d + str + "] " + str2, th);
        }
    }

    public static void e(String str, String str2) {
        g(str, str2);
    }

    public static void g(String str, String str2) {
        if (!b || a()) {
            Log.d("AppLovinSdk", b9.i.d + str + "] " + str2);
        }
    }

    public static void h(String str, String str2) {
        c(str, str2, null);
    }

    public static void i(String str, String str2) {
        if (!b || a()) {
            Log.i("AppLovinSdk", b9.i.d + str + "] " + str2);
        }
    }

    public static void j(String str, String str2) {
        if (!b || a()) {
            Log.w("AppLovinSdk", b9.i.d + str + "] " + str2);
        }
    }

    public static void l(String str, String str2) {
        k kVar = k.D0;
        if (kVar == null) {
            return;
        }
        kVar.O();
        if (a()) {
            k.D0.O().k(str, str2);
        }
    }

    public void b(String str, String str2) {
        a(str, str2, null);
    }

    public void d(String str, String str2) {
        Log.i("AppLovinSdk", b9.i.d + str + "] " + str2);
    }

    public void f(String str, String str2) {
        int iIntValue;
        if (a(this.f683a) && !TextUtils.isEmpty(str2) && (iIntValue = ((Integer) this.f683a.a(v4.r)).intValue()) > 0) {
            int length = str2.length();
            int i = ((length + iIntValue) - 1) / iIntValue;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * iIntValue;
                a(str, str2.substring(i3, Math.min(length, i3 + iIntValue)));
            }
        }
    }

    public void k(String str, String str2) {
        d(str, str2, null);
    }

    private void a(String str) {
        s2 s2Var = new s2();
        s2Var.a().a(str).a();
        g("AppLovinSdk", s2Var.toString());
    }

    public static void b(String str, String str2, Throwable th) {
        k kVar = k.D0;
        if (kVar == null) {
            return;
        }
        kVar.O();
        if (a()) {
            k.D0.O().a(str, str2, th);
        }
    }

    public void d(String str, String str2, Throwable th) {
        Log.w("AppLovinSdk", b9.i.d + str + "] " + str2, th);
    }

    public static void c(String str, String str2) {
        b(str, str2, null);
    }

    public void a(String str, Throwable th) {
        for (Throwable th2 : th.getSuppressed()) {
            b(str, th2.toString());
        }
    }

    public void a(String str, String str2) {
        Log.d("AppLovinSdk", b9.i.d + str + "] " + str2);
    }

    public void a(String str, String str2, Throwable th) {
        Log.e("AppLovinSdk", b9.i.d + str + "] " + str2, th);
    }

    public static boolean a() {
        return a(k.D0);
    }

    public static boolean a(k kVar) {
        return kVar != null && kVar.p0().c();
    }
}
