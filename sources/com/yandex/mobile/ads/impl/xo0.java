package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xo0 extends RuntimeException {
    private final String b;
    private final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xo0(String message, String displayMessage) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(displayMessage, "displayMessage");
        this.b = message;
        this.c = displayMessage;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.b;
    }

    public final String a() {
        return this.c;
    }
}
