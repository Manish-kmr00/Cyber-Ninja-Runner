package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i4 extends u4 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i4(String adId) {
        super(adId, "ad clicked");
        Intrinsics.checkNotNullParameter(adId, "adId");
    }
}
