package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class uu0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ot f10423a;

    public uu0(ot nativeAdAssets) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        this.f10423a = nativeAdAssets;
    }

    public final Float a() {
        ut utVarI = this.f10423a.i();
        qt qtVarH = this.f10423a.h();
        if (utVarI != null) {
            return Float.valueOf(utVarI.a());
        }
        if (qtVarH == null || qtVarH.d() <= 0 || qtVarH.b() <= 0) {
            return null;
        }
        return Float.valueOf(qtVarH.d() / qtVarH.b());
    }
}
