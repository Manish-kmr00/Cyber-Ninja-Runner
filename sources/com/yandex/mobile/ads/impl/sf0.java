package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class sf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f10202a = new Object();
    private static volatile de0 b;

    @JvmStatic
    public static final de0 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (b == null) {
            synchronized (f10202a) {
                if (b == null) {
                    b = new de0(context, "com.huawei.hms.location.LocationServices");
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        de0 de0Var = b;
        if (de0Var != null) {
            return de0Var;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
