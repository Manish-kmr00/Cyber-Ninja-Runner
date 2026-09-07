package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kf2 implements wl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q9 f9411a;
    private final pj1 b;
    private final ge2 c;
    private final qi1 d;

    public kf2(q9 adStateHolder, oi1 playerStateController, pj1 positionProviderHolder, ge2 videoDurationHolder, qi1 playerStateHolder) {
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        this.f9411a = adStateHolder;
        this.b = positionProviderHolder;
        this.c = videoDurationHolder;
        this.d = playerStateHolder;
    }

    @Override // com.yandex.mobile.ads.impl.wl1
    public final zh1 a() {
        long jA;
        nj1 nj1VarA = this.b.a();
        ki1 ki1VarB = this.b.b();
        if (nj1VarA != null) {
            jA = nj1VarA.a();
        } else {
            jA = (ki1VarB == null || this.f9411a.b() || this.d.c()) ? -1L : ki1VarB.a();
        }
        return new zh1(jA, this.c.a() != -9223372036854775807L ? this.c.a() : -1L);
    }
}
