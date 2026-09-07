package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ta1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wh1 f10280a;
    private final if2 b;
    private final yh2 c;

    public ta1(jg2 viewAdapter, oa1 nativeVideoAdPlayer, yb1 videoViewProvider, fb1 listener) {
        Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
        Intrinsics.checkNotNullParameter(nativeVideoAdPlayer, "nativeVideoAdPlayer");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(listener, "listener");
        qa1 qa1Var = new qa1(nativeVideoAdPlayer);
        this.f10280a = new wh1(listener);
        this.b = new if2(viewAdapter);
        this.c = new yh2(qa1Var, videoViewProvider);
    }

    public final void a(vc2 progressEventsObservable) {
        Intrinsics.checkNotNullParameter(progressEventsObservable, "progressEventsObservable");
        progressEventsObservable.a(this.f10280a, this.b, this.c);
    }
}
