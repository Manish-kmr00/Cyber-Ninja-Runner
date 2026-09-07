package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l81 {
    public static long a(o8 adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        qs qsVarN = adResponse.n();
        Long lU = adResponse.u();
        if (lU == null) {
            lU = qsVarN == qs.f ? 5000L : 0L;
        }
        return lU.longValue();
    }
}
