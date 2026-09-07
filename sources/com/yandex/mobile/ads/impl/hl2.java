package com.yandex.mobile.ads.impl;

import android.app.Activity;
import com.yandex.mobile.ads.appopenad.AppOpenAd;
import com.yandex.mobile.ads.appopenad.AppOpenAdEventListener;
import com.yandex.mobile.ads.common.AdInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hl2 implements AppOpenAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rs f9111a;
    private final bl2 b;

    public hl2(rs coreAppOpenAd, bl2 adInfoConverter) {
        Intrinsics.checkNotNullParameter(coreAppOpenAd, "coreAppOpenAd");
        Intrinsics.checkNotNullParameter(adInfoConverter, "adInfoConverter");
        this.f9111a = coreAppOpenAd;
        this.b = adInfoConverter;
    }

    @Override // com.yandex.mobile.ads.appopenad.AppOpenAd
    public final void show(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f9111a.show(activity);
    }

    @Override // com.yandex.mobile.ads.appopenad.AppOpenAd
    public final AdInfo getInfo() {
        bl2 bl2Var = this.b;
        ps info = this.f9111a.getInfo();
        bl2Var.getClass();
        return bl2.a(info);
    }

    @Override // com.yandex.mobile.ads.appopenad.AppOpenAd
    public final void setAdEventListener(AppOpenAdEventListener appOpenAdEventListener) {
        this.f9111a.a(new il2(appOpenAdEventListener));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof hl2) && Intrinsics.areEqual(((hl2) obj).f9111a, this.f9111a);
    }

    public final int hashCode() {
        return this.f9111a.hashCode();
    }
}
