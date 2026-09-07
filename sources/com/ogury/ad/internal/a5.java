package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a5 extends u4 {
    public final g8 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a5(String adId, g8 rewardItem) {
        super(adId, rewardItem.f7308a);
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        this.c = rewardItem;
    }

    public final g8 a() {
        return this.c;
    }
}
