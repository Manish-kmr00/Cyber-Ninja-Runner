package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Player;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t6 implements xl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r9 f10271a;
    private final ri1 b;
    private final y60 c;

    public t6(r9 adStateHolder, pi1 playerStateController, ri1 playerStateHolder, y60 playerProvider) {
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(playerProvider, "playerProvider");
        this.f10271a = adStateHolder;
        this.b = playerStateHolder;
        this.c = playerProvider;
    }

    @Override // com.yandex.mobile.ads.impl.xl1
    public final yh1 a() {
        do0 do0VarD;
        Player playerA;
        yi1 yi1VarC = this.f10271a.c();
        if (yi1VarC == null || (do0VarD = yi1VarC.d()) == null) {
            return yh1.c;
        }
        boolean zC = this.b.c();
        tm0 tm0VarA = this.f10271a.a(do0VarD);
        yh1 yh1Var = yh1.c;
        return (tm0.b == tm0VarA || !zC || (playerA = this.c.a()) == null) ? yh1Var : new yh1(playerA.getCurrentPosition(), playerA.getDuration());
    }
}
