package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ge2 f8471a;

    public b3(ge2 videoDurationHolder) {
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        this.f8471a = videoDurationHolder;
    }

    public final long a(et adBreakPosition) {
        Intrinsics.checkNotNullParameter(adBreakPosition, "adBreakPosition");
        long jB = adBreakPosition.b();
        int iOrdinal = adBreakPosition.a().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return jB;
            }
        } else {
            if (jB == 100) {
                return Long.MIN_VALUE;
            }
            if (jB == 0) {
                return 0L;
            }
            if (this.f8471a.a() != -9223372036854775807L) {
                return (long) ((jB / 100) * this.f8471a.a());
            }
        }
        return -1L;
    }
}
