package com.yandex.mobile.ads.impl;

import com.android.volley.toolbox.HttpClientStack;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xh0 {
    @JvmStatic
    public static final boolean a(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return (Intrinsics.areEqual(method, "GET") || Intrinsics.areEqual(method, "HEAD")) ? false : true;
    }

    @JvmStatic
    public static final boolean b(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return Intrinsics.areEqual(method, "POST") || Intrinsics.areEqual(method, com.safedk.android.a.g.f) || Intrinsics.areEqual(method, HttpClientStack.HttpPatch.METHOD_NAME) || Intrinsics.areEqual(method, "PROPPATCH") || Intrinsics.areEqual(method, "REPORT");
    }
}
