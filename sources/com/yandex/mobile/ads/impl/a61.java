package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a61 extends Exception {
    private final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a61(String detailMessage) {
        super(detailMessage);
        Intrinsics.checkNotNullParameter(detailMessage, "detailMessage");
        this.b = detailMessage;
    }

    public final String a() {
        return this.b;
    }
}
