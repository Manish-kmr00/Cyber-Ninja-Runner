package com.yandex.mobile.ads.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s81 f10276a;
    private final s81 b;

    public final s81 a(zq1 responseNativeType) {
        Intrinsics.checkNotNullParameter(responseNativeType, "responseNativeType");
        int iOrdinal = responseNativeType.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            return this.f10276a;
        }
        if (iOrdinal == 3) {
            return this.b;
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ t81() {
        this(new f51(), new gm1());
    }

    public t81(s81 nativeAdCreator, s81 promoAdCreator) {
        Intrinsics.checkNotNullParameter(nativeAdCreator, "nativeAdCreator");
        Intrinsics.checkNotNullParameter(promoAdCreator, "promoAdCreator");
        this.f10276a = nativeAdCreator;
        this.b = promoAdCreator;
    }
}
