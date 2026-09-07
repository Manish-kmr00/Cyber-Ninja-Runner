package com.yandex.mobile.ads.impl;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
public final class ff2 {
    public static int a() {
        int i = iw1.l;
        Integer numE = iw1.a.a().e();
        if (numE != null) {
            return RangesKt.coerceIn(numE.intValue(), 1, 4);
        }
        return 4;
    }
}
