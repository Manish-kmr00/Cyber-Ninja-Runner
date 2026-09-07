package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n91 implements bf1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v9 f9709a;
    private final y32 b;
    private final mp1 c;

    public n91(v9 adTracker, y32 targetUrlHandler, mp1 reporter) {
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        Intrinsics.checkNotNullParameter(targetUrlHandler, "targetUrlHandler");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.f9709a = adTracker;
        this.b = targetUrlHandler;
        this.c = reporter;
    }

    @Override // com.yandex.mobile.ads.impl.bf1
    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f9709a.a(url, this.b, this.c);
    }
}
