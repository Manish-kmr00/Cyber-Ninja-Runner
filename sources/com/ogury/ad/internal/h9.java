package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h9 extends y3 {
    public final c b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h9(String name, c ad) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.b = ad;
    }
}
