package com.chartboost.sdk.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ld {
    public static void a() {
        if (!p7.b()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    public static void b(zb zbVar) {
        if (zbVar.k()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void c(zb zbVar) {
        if (zbVar.n()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    public static void d(zb zbVar) {
        if (!zbVar.n()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }

    public static void e(zb zbVar) {
        if (!zbVar.l()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    public static void f(zb zbVar) {
        if (!zbVar.m()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    public static void g(zb zbVar) {
        if (zbVar.f().c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    public static void h(zb zbVar) {
        if (zbVar.f().d() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }

    public static void a(e8 e8Var, q3 q3Var, n6 n6Var) {
        if (e8Var == e8.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (q3Var == q3.DEFINED_BY_JAVASCRIPT && e8Var == e8.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (n6Var == n6.DEFINED_BY_JAVASCRIPT && e8Var == e8.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public static void a(zb zbVar) {
        d(zbVar);
        b(zbVar);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }
}
