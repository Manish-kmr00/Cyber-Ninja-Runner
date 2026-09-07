package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ii2 implements wp1<ci2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f9226a;
    private final wp1<ci2> b;

    public ii2(g5 adLoadingPhasesManager, wp1<ci2> requestListener) {
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.f9226a = adLoadingPhasesManager;
        this.b = requestListener;
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(kb2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f9226a.a(f5.y);
        this.b.a(error);
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(ci2 ci2Var) {
        ci2 vmap = ci2Var;
        Intrinsics.checkNotNullParameter(vmap, "vmap");
        this.f9226a.a(f5.y);
        this.b.a(vmap);
    }
}
