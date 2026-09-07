package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class dg1 {
    public static cg1 a(bh0 htmlWebViewRenderer) {
        Intrinsics.checkNotNullParameter(htmlWebViewRenderer, "htmlWebViewRenderer");
        return new cg1(htmlWebViewRenderer, new Handler(Looper.getMainLooper()), new wy1(), new r7());
    }
}
