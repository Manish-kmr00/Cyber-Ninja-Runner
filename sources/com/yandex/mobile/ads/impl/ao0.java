package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ao0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<do0> f8429a;
    private final pj0 b;
    private final zn0 c;
    private final bo0 d;
    private final n92<do0> e;
    private final qn0 f;

    public ao0(Context context, uu1 sdkEnvironmentModule, gm0 instreamAdPlayerController, zm0 viewHolderManager, dt adBreak, rb2 videoAdVideoAdInfo, id2 adStatusController, fg2 videoTracker, pj0 imageProvider, hc2 eventsListener, o3 adConfiguration, do0 videoAd, zn0 instreamVastAdPlayer, so0 videoViewProvider, mf2 videoRenderValidator, vc2 progressEventsObservable, bo0 eventsController, n92 vastPlaybackController, hj0 imageLoadManager, g5 adLoadingPhasesManager, qn0 instreamImagesLoader, om0 progressTrackersConfigurator, am0 adParameterManager, ul0 requestParameterManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(viewHolderManager, "viewHolderManager");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(videoAdVideoAdInfo, "videoAdVideoAdInfo");
        Intrinsics.checkNotNullParameter(adStatusController, "adStatusController");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(eventsListener, "eventsListener");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(videoRenderValidator, "videoRenderValidator");
        Intrinsics.checkNotNullParameter(progressEventsObservable, "progressEventsObservable");
        Intrinsics.checkNotNullParameter(eventsController, "eventsController");
        Intrinsics.checkNotNullParameter(vastPlaybackController, "vastPlaybackController");
        Intrinsics.checkNotNullParameter(imageLoadManager, "imageLoadManager");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(instreamImagesLoader, "instreamImagesLoader");
        Intrinsics.checkNotNullParameter(progressTrackersConfigurator, "progressTrackersConfigurator");
        Intrinsics.checkNotNullParameter(adParameterManager, "adParameterManager");
        Intrinsics.checkNotNullParameter(requestParameterManager, "requestParameterManager");
        this.f8429a = videoAdVideoAdInfo;
        this.b = imageProvider;
        this.c = instreamVastAdPlayer;
        this.d = eventsController;
        this.e = vastPlaybackController;
        this.f = instreamImagesLoader;
        progressTrackersConfigurator.a(progressEventsObservable);
        vastPlaybackController.a(adParameterManager);
        vastPlaybackController.a(requestParameterManager);
    }

    public final void d() {
        this.e.d();
        this.f.a(this.f8429a, this.b, this.d);
    }

    public final void c() {
        this.e.c();
    }

    public final void g() {
        this.e.f();
        this.d.a();
    }

    public final void b() {
        this.e.b();
    }

    public final void f() {
        this.e.e();
    }

    public final void e() {
        this.c.d();
        this.d.a();
    }

    public final void a() {
        this.e.a();
        this.f.getClass();
    }
}
