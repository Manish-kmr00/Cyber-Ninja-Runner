package com.yandex.mobile.ads.impl;

import android.app.Activity;
import com.yandex.mobile.ads.common.AdInfo;
import com.yandex.mobile.ads.rewarded.RewardedAd;
import com.yandex.mobile.ads.rewarded.RewardedAdEventListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tm2 implements RewardedAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final du f10318a;
    private final bl2 b;

    public tm2(du coreRewardedAd, bl2 adInfoConverter) {
        Intrinsics.checkNotNullParameter(coreRewardedAd, "coreRewardedAd");
        Intrinsics.checkNotNullParameter(adInfoConverter, "adInfoConverter");
        this.f10318a = coreRewardedAd;
        this.b = adInfoConverter;
    }

    @Override // com.yandex.mobile.ads.rewarded.RewardedAd
    public final void show(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f10318a.show(activity);
    }

    @Override // com.yandex.mobile.ads.rewarded.RewardedAd
    public final AdInfo getInfo() {
        bl2 bl2Var = this.b;
        ps info = this.f10318a.getInfo();
        bl2Var.getClass();
        return bl2.a(info);
    }

    @Override // com.yandex.mobile.ads.rewarded.RewardedAd
    public final void setAdEventListener(RewardedAdEventListener rewardedAdEventListener) {
        this.f10318a.a(new um2(rewardedAdEventListener));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof tm2) && Intrinsics.areEqual(((tm2) obj).f10318a, this.f10318a);
    }

    public final int hashCode() {
        return this.f10318a.hashCode();
    }
}
