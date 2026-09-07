package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qe0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile pe0 f10010a;
    private static final Object b = new Object();

    @JvmStatic
    public static final pe0 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f10010a == null) {
            synchronized (b) {
                if (f10010a == null) {
                    int i = ns0.b;
                    Intrinsics.checkNotNullParameter(context, "context");
                    f10010a = new pe0(ns0.a(context, "YadPreferenceFile"));
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        pe0 pe0Var = f10010a;
        if (pe0Var != null) {
            return pe0Var;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
