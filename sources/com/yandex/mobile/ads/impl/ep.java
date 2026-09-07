package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ep implements gs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final is1 f8820a;
    private final hw1 b;

    public ep(fp clientSideReward, is1 rewardedListener, hw1 reward) {
        Intrinsics.checkNotNullParameter(clientSideReward, "clientSideReward");
        Intrinsics.checkNotNullParameter(rewardedListener, "rewardedListener");
        Intrinsics.checkNotNullParameter(reward, "reward");
        this.f8820a = rewardedListener;
        this.b = reward;
    }

    @Override // com.yandex.mobile.ads.impl.gs1
    public final void a() {
        this.f8820a.a(this.b);
    }
}
