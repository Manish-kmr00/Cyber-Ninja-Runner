package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Build;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes5.dex */
public final class pa {
    @JvmStatic
    public static final boolean a(Context context) {
        return (context == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    @JvmStatic
    public static final boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }
}
