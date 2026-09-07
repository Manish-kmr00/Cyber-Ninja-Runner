package com.chartboost.sdk.impl;

import android.os.Build;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class f9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1016a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final JSONObject m;
    public final String n;
    public final String o;
    public final Integer p;
    public final r2 q;
    public final m8 r;
    public final t9 s;
    public final r5 t;
    public final v8 u;
    public final ca v;
    public final n3 w;
    public final w3 x;
    public final e7 y;

    public f9(String str, String str2, r5 r5Var, v8 v8Var, r2 r2Var, t9 t9Var, ca caVar, m8 m8Var, n3 n3Var, w3 w3Var, e7 e7Var) {
        String str3;
        this.t = r5Var;
        this.u = v8Var;
        this.q = r2Var;
        this.s = t9Var;
        this.v = caVar;
        this.r = m8Var;
        this.h = str;
        this.i = str2;
        this.w = n3Var;
        this.x = w3Var;
        this.y = e7Var;
        String str4 = Build.PRODUCT;
        if (!"sdk".equals(str4) && !"google_sdk".equals(str4) && ((str3 = Build.MANUFACTURER) == null || !str3.contains("Genymotion"))) {
            this.f1016a = Build.MODEL;
        } else {
            this.f1016a = "Android Simulator";
        }
        String str5 = Build.MANUFACTURER;
        this.k = str5 == null ? "unknown" : str5;
        this.j = str5 + " " + Build.MODEL;
        this.l = w3Var.getDeviceType();
        this.b = "Android " + Build.VERSION.RELEASE;
        this.c = Locale.getDefault().getCountry();
        this.d = Locale.getDefault().getLanguage();
        this.g = "9.8.3";
        this.e = w3Var.getVersionName();
        this.f = w3Var.getPackageName();
        this.n = b(r2Var);
        this.m = a(r2Var);
        this.o = n2.a();
        this.p = v8Var.getCellularConnectionType();
    }

    public m8 f() {
        return this.r;
    }

    public r5 c() {
        return this.t;
    }

    public v8 g() {
        return this.u;
    }

    public final String b(r2 r2Var) {
        if (r2Var != null) {
            return r2Var.d();
        }
        return "";
    }

    public final JSONObject a(r2 r2Var) {
        if (r2Var != null) {
            return a(r2Var, new t2());
        }
        return new JSONObject();
    }

    public t9 h() {
        return this.s;
    }

    public ca j() {
        return this.v;
    }

    public int i() {
        t9 t9Var = this.s;
        if (t9Var != null) {
            return t9Var.getSessionCounter();
        }
        return -1;
    }

    public Integer e() {
        return Integer.valueOf(this.x.getOrtbDeviceType());
    }

    public e7 d() {
        return this.y;
    }

    public w3 b() {
        return this.x;
    }

    public n3 a() {
        return this.w;
    }

    public JSONObject a(r2 r2Var, t2 t2Var) {
        if (t2Var != null) {
            return t2Var.a(r2Var);
        }
        return new JSONObject();
    }
}
