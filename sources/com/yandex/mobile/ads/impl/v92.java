package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class v92<T> implements uc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<T> f10466a;
    private final eg2 b;
    private final hc2<T> c;
    private final lg2 d;
    private boolean e;

    public /* synthetic */ v92(rb2 rb2Var, kg2 kg2Var, fg2 fg2Var, hc2 hc2Var) {
        this(rb2Var, kg2Var, fg2Var, hc2Var, new lg2(kg2Var));
    }

    public v92(rb2 videoAdInfo, kg2 videoViewProvider, fg2 videoTracker, hc2 playbackEventsListener, lg2 videoVisibleAreaValidator) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(playbackEventsListener, "playbackEventsListener");
        Intrinsics.checkNotNullParameter(videoVisibleAreaValidator, "videoVisibleAreaValidator");
        this.f10466a = videoAdInfo;
        this.b = videoTracker;
        this.c = playbackEventsListener;
        this.d = videoVisibleAreaValidator;
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        if (this.e || j2 <= 0 || !this.d.a()) {
            return;
        }
        this.e = true;
        this.b.h();
        this.c.i(this.f10466a);
    }
}
