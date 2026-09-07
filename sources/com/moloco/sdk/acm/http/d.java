package com.moloco.sdk.acm.http;

import com.moloco.sdk.MetricsRequest;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MetricsRequest.PostMetricsRequest.CountEvent> f6042a;
    public final List<MetricsRequest.PostMetricsRequest.TimerEvent> b;

    public d(List<MetricsRequest.PostMetricsRequest.CountEvent> counts, List<MetricsRequest.PostMetricsRequest.TimerEvent> timers) {
        Intrinsics.checkNotNullParameter(counts, "counts");
        Intrinsics.checkNotNullParameter(timers, "timers");
        this.f6042a = counts;
        this.b = timers;
    }

    public final List<MetricsRequest.PostMetricsRequest.CountEvent> a() {
        return this.f6042a;
    }

    public final List<MetricsRequest.PostMetricsRequest.TimerEvent> b() {
        return this.b;
    }
}
