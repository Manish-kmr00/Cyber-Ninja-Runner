package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xc2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zm1 f10642a;
    private final sl1 b;
    private final v92<T> c;
    private final ea2<T> d;
    private final th2<T> e;

    public xc2(Context context, rb2 videoAdInfo, kg2 videoViewProvider, id2 adStatusController, fg2 videoTracker, oc2 videoAdPlayer, hc2 playbackEventsListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(adStatusController, "adStatusController");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(playbackEventsListener, "playbackEventsListener");
        this.f10642a = new zm1(videoTracker);
        this.b = new sl1(context, videoAdInfo);
        this.c = new v92<>(videoAdInfo, videoViewProvider, videoTracker, playbackEventsListener);
        this.d = new ea2<>(videoViewProvider, videoTracker, videoAdPlayer);
        this.e = new th2<>(videoAdInfo, videoViewProvider, adStatusController, videoTracker, playbackEventsListener);
    }

    public final void a(vc2 progressEventsObservable) {
        Intrinsics.checkNotNullParameter(progressEventsObservable, "progressEventsObservable");
        progressEventsObservable.a(this.f10642a, this.b, this.d, this.c, this.e);
        progressEventsObservable.a(this.e);
    }
}
