package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    @JvmStatic
    public static final b2 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = c2.h;
        return new b2(context, c2.a.a(context));
    }

    @JvmStatic
    public static final fe b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = iw1.l;
        return new fe(context, iw1.a.a(), new fu1());
    }

    @JvmStatic
    public static final b a() {
        return new b(new o82());
    }
}
