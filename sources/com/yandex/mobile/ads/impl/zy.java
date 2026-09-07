package com.yandex.mobile.ads.impl;

import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class zy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeUnit f10865a;
    private final Lazy b;

    public zy(TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.f10865a = timeUnit;
        this.b = LazyKt.lazy(new yy(this));
    }

    public static final /* synthetic */ long a(zy zyVar) {
        zyVar.getClass();
        return 1L;
    }

    public final long a() {
        return ((Number) this.b.getValue()).longValue();
    }
}
