package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q4 extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q4(String message) {
        super(message, null);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
