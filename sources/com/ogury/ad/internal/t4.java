package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t4 extends u4 {
    public final int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t4(String adId) {
        super(adId, "error");
        Intrinsics.checkNotNullParameter(adId, "adId");
        this.c = 3201;
    }

    public final int a() {
        return this.c;
    }
}
