package com.yandex.mobile.ads.impl;

import android.app.Activity;
import com.yandex.mobile.ads.common.AdInfo;
import com.yandex.mobile.ads.interstitial.InterstitialAd;
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class em2 implements InterstitialAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kt f8813a;
    private final bl2 b;

    public em2(kt coreInterstitialAd, bl2 adInfoConverter) {
        Intrinsics.checkNotNullParameter(coreInterstitialAd, "coreInterstitialAd");
        Intrinsics.checkNotNullParameter(adInfoConverter, "adInfoConverter");
        this.f8813a = coreInterstitialAd;
        this.b = adInfoConverter;
    }

    @Override // com.yandex.mobile.ads.interstitial.InterstitialAd
    public final void show(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f8813a.show(activity);
    }

    @Override // com.yandex.mobile.ads.interstitial.InterstitialAd
    public final AdInfo getInfo() {
        bl2 bl2Var = this.b;
        ps info = this.f8813a.getInfo();
        bl2Var.getClass();
        return bl2.a(info);
    }

    @Override // com.yandex.mobile.ads.interstitial.InterstitialAd
    public final void setAdEventListener(InterstitialAdEventListener interstitialAdEventListener) {
        this.f8813a.a(new fm2(interstitialAdEventListener));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof em2) && Intrinsics.areEqual(((em2) obj).f8813a, this.f8813a);
    }

    public final int hashCode() {
        return this.f8813a.hashCode();
    }
}
