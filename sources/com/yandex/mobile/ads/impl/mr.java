package com.yandex.mobile.ads.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class mr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vn1 f9664a;

    public final vn1 a() {
        return this.f9664a;
    }

    public mr() {
        this(TimeUnit.MINUTES);
    }

    public mr(vn1 delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f9664a = delegate;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mr(TimeUnit timeUnit) {
        this(new vn1(e42.h, timeUnit));
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
    }
}
