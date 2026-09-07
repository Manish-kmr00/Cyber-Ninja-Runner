package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class lg1 {
    public static ig1 a() {
        Handler handler = new Handler(Looper.getMainLooper());
        Intrinsics.checkNotNullParameter(handler, "handler");
        int i = ig1.f9217a;
        Intrinsics.checkNotNullParameter(handler, "handler");
        return new jg1(true, handler);
    }

    private lg1() {
    }
}
