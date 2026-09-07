package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s22 extends IOException {
    public final q50 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s22(q50 errorCode) {
        super("stream was reset: " + errorCode);
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.b = errorCode;
    }
}
