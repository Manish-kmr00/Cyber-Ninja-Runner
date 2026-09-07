package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n92<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oc2<T> f9710a;
    private final kg2 b;
    private final rb2<T> c;
    private final id2 d;
    private final eg2 e;
    private final g5 f;
    private final bd2 g;
    private final yc2 h;
    private final gc2<T> i;

    public n92(Context context, o3 adConfiguration, oc2 videoAdPlayer, kg2 videoViewProvider, rb2 videoAdInfo, mf2 videoRenderValidator, id2 videoAdStatusController, fg2 videoTracker, vc2 progressEventsObservable, hc2 playbackEventsListener, o8 o8Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoRenderValidator, "videoRenderValidator");
        Intrinsics.checkNotNullParameter(videoAdStatusController, "videoAdStatusController");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(progressEventsObservable, "progressEventsObservable");
        Intrinsics.checkNotNullParameter(playbackEventsListener, "playbackEventsListener");
        this.f9710a = videoAdPlayer;
        this.b = videoViewProvider;
        this.c = videoAdInfo;
        this.d = videoAdStatusController;
        this.e = videoTracker;
        g5 g5Var = new g5();
        this.f = g5Var;
        bd2 bd2Var = new bd2(context, adConfiguration, o8Var, videoAdInfo, g5Var, videoAdStatusController, videoViewProvider, videoRenderValidator, videoTracker);
        this.g = bd2Var;
        yc2 yc2Var = new yc2(videoAdPlayer, progressEventsObservable);
        this.h = yc2Var;
        this.i = new gc2<>(videoAdInfo, videoAdPlayer, yc2Var, bd2Var, videoAdStatusController, g5Var, videoTracker, playbackEventsListener);
        new xc2(context, videoAdInfo, videoViewProvider, videoAdStatusController, videoTracker, videoAdPlayer, playbackEventsListener).a(progressEventsObservable);
    }

    public final void d() {
        this.f9710a.a(this.i);
        this.f9710a.a(this.c);
        g5 g5Var = this.f;
        f5 f5Var = f5.x;
        ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
        View view = this.b.getView();
        if (view != null) {
            this.e.a(view, this.b.a());
        }
        this.g.f();
        this.d.b(hd2.c);
    }

    public final void c() {
        this.f9710a.c();
    }

    public final void f() {
        this.f9710a.a();
    }

    public final void b() {
        this.h.b();
        this.f9710a.pauseAd();
    }

    public final void e() {
        this.f9710a.resumeAd();
    }

    public final void a() {
        this.h.b();
        this.f9710a.a((gc2) null);
        this.d.b();
        this.g.e();
        this.f.a();
    }

    public final void a(dd2.b reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.g.a(reportParameterManager);
    }

    public final void a(dd2.a reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.g.a(reportParameterManager);
    }
}
