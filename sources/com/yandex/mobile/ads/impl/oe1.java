package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class oe1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ne1 f9810a;
    private static final Object b = new Object();

    @JvmStatic
    public static final ne1 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f9810a == null) {
            synchronized (b) {
                if (f9810a == null) {
                    int i = ns0.b;
                    Intrinsics.checkNotNullParameter(context, "context");
                    f9810a = new ne1(ns0.a(context, "YadPreferenceFile"));
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        ne1 ne1Var = f9810a;
        if (ne1Var != null) {
            return ne1Var;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
