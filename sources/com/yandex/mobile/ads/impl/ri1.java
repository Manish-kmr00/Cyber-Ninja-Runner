package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Timeline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ri1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Timeline.Period f10111a;
    private Timeline b;
    private boolean c;

    public /* synthetic */ ri1() {
        Timeline.Period period = new Timeline.Period();
        Timeline EMPTY = Timeline.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        this(period, EMPTY, false);
    }

    public ri1(Timeline.Period period, Timeline timeline, boolean z) {
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(timeline, "timeline");
        this.f10111a = period;
        this.b = timeline;
        this.c = z;
    }

    public final Timeline.Period a() {
        return this.f10111a;
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
