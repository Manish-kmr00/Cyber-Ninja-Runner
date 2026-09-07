package com.yandex.mobile.ads.impl;

import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class mj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hl1 f9645a;

    public mj2(hl1 processNameProvider) {
        Intrinsics.checkNotNullParameter(processNameProvider, "processNameProvider");
        this.f9645a = processNameProvider;
    }

    public final void a() {
        String strA = this.f9645a.a();
        String strSubstringAfter = strA != null ? StringsKt.substringAfter(strA, ":", "") : null;
        if (strSubstringAfter == null || strSubstringAfter.length() <= 0) {
            return;
        }
        try {
            WebView.setDataDirectorySuffix(strSubstringAfter);
        } catch (Throwable unused) {
        }
    }
}
