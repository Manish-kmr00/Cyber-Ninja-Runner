package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final it0 f9696a;
    private final li b;

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9696a.getClass();
        String strA = it0.a(context);
        if (strA == null) {
            strA = this.b.a(context);
        }
        return a(strA);
    }

    public /* synthetic */ n4() {
        this(new it0(), new li());
    }

    public n4(it0 manifestAnalyzer, li availableHostSelector) {
        Intrinsics.checkNotNullParameter(manifestAnalyzer, "manifestAnalyzer");
        Intrinsics.checkNotNullParameter(availableHostSelector, "availableHostSelector");
        this.f9696a = manifestAnalyzer;
        this.b = availableHostSelector;
    }

    private static String a(String str) {
        return "https://" + str;
    }
}
