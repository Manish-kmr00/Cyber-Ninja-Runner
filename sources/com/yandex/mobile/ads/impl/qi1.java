package com.yandex.mobile.ads.impl;

import androidx.media3.common.Timeline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Timeline.Period f10021a;
    private Timeline b;
    private boolean c;

    public /* synthetic */ qi1() {
        Timeline.Period period = new Timeline.Period();
        Timeline EMPTY = Timeline.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        this(period, EMPTY, false);
    }

    public qi1(Timeline.Period period, Timeline timeline, boolean z) {
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(timeline, "timeline");
        this.f10021a = period;
        this.b = timeline;
        this.c = z;
    }

    public final Timeline.Period a() {
        return this.f10021a;
    }

    public final Timeline b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void a(Timeline timeline) {
        Intrinsics.checkNotNullParameter(timeline, "<set-?>");
        this.b = timeline;
    }
}
