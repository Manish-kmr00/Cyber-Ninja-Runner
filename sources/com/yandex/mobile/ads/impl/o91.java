package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v9 f9796a;
    private final y32 b;

    public o91(v9 adTracker, y32 targetUrlHandler) {
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        Intrinsics.checkNotNullParameter(targetUrlHandler, "targetUrlHandler");
        this.f9796a = adTracker;
        this.b = targetUrlHandler;
    }

    public final n91 a(mp1 clickReporter) {
        Intrinsics.checkNotNullParameter(clickReporter, "clickReporter");
        return new n91(this.f9796a, this.b, clickReporter);
    }
}
