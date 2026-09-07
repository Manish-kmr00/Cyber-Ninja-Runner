package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class lf2 implements xl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r9 f9512a;
    private final qj1 b;
    private final he2 c;
    private final ri1 d;

    public lf2(r9 adStateHolder, pi1 playerStateController, qj1 positionProviderHolder, he2 videoDurationHolder, ri1 playerStateHolder) {
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        this.f9512a = adStateHolder;
        this.b = positionProviderHolder;
        this.c = videoDurationHolder;
        this.d = playerStateHolder;
    }

    @Override // com.yandex.mobile.ads.impl.xl1
    public final yh1 a() {
        long jA;
        oj1 oj1VarA = this.b.a();
        li1 li1VarB = this.b.b();
        if (oj1VarA != null) {
            jA = oj1VarA.a();
        } else {
            jA = (li1VarB == null || this.f9512a.b() || this.d.c()) ? -1L : li1VarB.a();
        }
        return new yh1(jA, this.c.a() != -9223372036854775807L ? this.c.a() : -1L);
    }
}
