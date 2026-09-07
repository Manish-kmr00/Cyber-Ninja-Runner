package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class qn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ht1 f10039a;
    private final z2 b;

    public qn1(ht1 schedulePlaylistItemsProvider, z2 adBreakStatusController) {
        Intrinsics.checkNotNullParameter(schedulePlaylistItemsProvider, "schedulePlaylistItemsProvider");
        Intrinsics.checkNotNullParameter(adBreakStatusController, "adBreakStatusController");
        this.f10039a = schedulePlaylistItemsProvider;
        this.b = adBreakStatusController;
    }

    public final dt a(long j) {
        for (aj1 aj1Var : this.f10039a.a()) {
            dt dtVarA = aj1Var.a();
            boolean z = Math.abs(aj1Var.b() - j) < 200;
            y2 y2VarA = this.b.a(dtVarA);
            if (z && y2.d == y2VarA) {
                return dtVarA;
            }
        }
        return null;
    }
}
