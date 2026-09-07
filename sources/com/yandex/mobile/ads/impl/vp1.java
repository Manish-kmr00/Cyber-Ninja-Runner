package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class vp1 {
    public static String a(di0 url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String strC = url.c();
        String strE = url.e();
        return strE != null ? strC + "?" + strE : strC;
    }
}
