package com.yandex.mobile.ads.impl;

import androidx.media3.common.Player;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class s6 implements wl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q9 f10178a;
    private final qi1 b;
    private final x60 c;

    public s6(q9 adStateHolder, oi1 playerStateController, qi1 playerStateHolder, x60 playerProvider) {
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(playerProvider, "playerProvider");
        this.f10178a = adStateHolder;
        this.b = playerStateHolder;
        this.c = playerProvider;
    }

    @Override // com.yandex.mobile.ads.impl.wl1
    public final zh1 a() {
        do0 do0VarD;
        Player playerA;
        xi1 xi1VarC = this.f10178a.c();
        if (xi1VarC == null || (do0VarD = xi1VarC.d()) == null) {
            return zh1.c;
        }
        boolean zC = this.b.c();
        sm0 sm0VarA = this.f10178a.a(do0VarD);
        zh1 zh1Var = zh1.c;
        return (sm0.b == sm0VarA || !zC || (playerA = this.c.a()) == null) ? zh1Var : new zh1(playerA.getCurrentPosition(), playerA.getDuration());
    }
}
