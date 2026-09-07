package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e21 implements yo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s21 f8753a;

    public e21(s21 mraidWebView) {
        Intrinsics.checkNotNullParameter(mraidWebView, "mraidWebView");
        this.f8753a = mraidWebView;
    }

    @Override // com.yandex.mobile.ads.impl.yo
    public final void a(rr0 link, ap clickListenerCreator) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(clickListenerCreator, "clickListenerCreator");
        this.f8753a.setClickListener(new d21(link, clickListenerCreator));
    }
}
