package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class te {
    @JvmStatic
    public static final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception unused) {
            op0.c(new Object[0]);
            return null;
        }
    }

    @JvmStatic
    public static final String b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            op0.c(new Object[0]);
            return null;
        }
    }
}
