package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.rewarded.Reward;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class sm2 implements Reward {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final or1 f10220a;

    public sm2(or1 rewardData) {
        Intrinsics.checkNotNullParameter(rewardData, "rewardData");
        this.f10220a = rewardData;
    }

    @Override // com.yandex.mobile.ads.rewarded.Reward
    public final int getAmount() {
        return this.f10220a.getAmount();
    }

    @Override // com.yandex.mobile.ads.rewarded.Reward
    public final String getType() {
        return this.f10220a.getType();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof sm2) && Intrinsics.areEqual(((sm2) obj).f10220a, this.f10220a);
    }

    public final int hashCode() {
        return this.f10220a.hashCode();
    }
}
