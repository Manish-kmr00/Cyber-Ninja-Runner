package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class lr1 implements y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ds1 f9563a;
    private final mr1 b;

    public lr1(j1 adActivityListener, ds1 closeVerificationController, mr1 rewardController) {
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(closeVerificationController, "closeVerificationController");
        Intrinsics.checkNotNullParameter(rewardController, "rewardController");
        this.f9563a = closeVerificationController;
        this.b = rewardController;
    }

    @Override // com.yandex.mobile.ads.impl.y1
    public final void b() {
        this.f9563a.a();
        this.b.a();
    }
}
