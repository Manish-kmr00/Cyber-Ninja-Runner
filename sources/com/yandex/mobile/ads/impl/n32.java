package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes12.dex */
public final class n32 implements pq0 {
    private final View b;

    public n32(uf1 htmlWebView) {
        Intrinsics.checkNotNullParameter(htmlWebView, "htmlWebView");
        this.b = htmlWebView;
    }

    @Override // com.yandex.mobile.ads.impl.pq0
    public final String a() {
        boolean zIsHardwareAccelerated = this.b.isHardwareAccelerated();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return z0.a(new Object[]{Boolean.valueOf(zIsHardwareAccelerated)}, 1, "supports: {inlineVideo: %s}", "format(...)");
    }
}
