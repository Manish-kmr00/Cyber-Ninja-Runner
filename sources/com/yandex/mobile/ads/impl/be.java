package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f8498a;

    public be(lp1 reporter) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.f8498a = reporter;
    }

    public final void a(Map<Thread, StackTraceElement[]> traces) {
        Intrinsics.checkNotNullParameter(traces, "traces");
        this.f8498a.reportAnr(traces);
    }
}
