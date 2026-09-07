package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class fp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ja1 f8917a;
    private final int b;

    public fp0(ja1 nativeValidator, int i) {
        Intrinsics.checkNotNullParameter(nativeValidator, "nativeValidator");
        this.f8917a = nativeValidator;
        this.b = i;
    }

    public final f92 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f8917a.a(context, this.b);
    }
}
