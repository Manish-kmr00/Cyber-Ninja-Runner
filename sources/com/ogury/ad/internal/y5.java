package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y5 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7450a;

    public y5(String message, int i) {
        message = (i & 4) != 0 ? "" : message;
        Intrinsics.checkNotNullParameter("", "type");
        Intrinsics.checkNotNullParameter(message, "message");
        this.f7450a = message;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f7450a;
    }
}
