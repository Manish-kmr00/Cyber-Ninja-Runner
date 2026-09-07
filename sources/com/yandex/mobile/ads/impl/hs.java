package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class hs {
    public static final gf1 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        int i = context.getResources().getConfiguration().orientation;
        if (i != 1) {
            return i != 2 ? gf1.e : gf1.c;
        }
        return gf1.d;
    }
}
