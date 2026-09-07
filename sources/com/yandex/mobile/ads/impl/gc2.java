package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class gc2<T> implements qc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<T> f8993a;
    private final oc2<T> b;
    private final yc2 c;
    private final bd2 d;
    private final id2 e;
    private final g5 f;
    private final eg2 g;
    private final hc2<T> h;
    private nc2 i;
    private boolean j;

    public gc2(rb2 videoAdInfo, oc2 videoAdPlayer, yc2 progressTrackingManager, bd2 videoAdRenderingController, id2 videoAdStatusController, g5 adLoadingPhasesManager, fg2 videoTracker, hc2 playbackEventsListener) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(progressTrackingManager, "progressTrackingManager");
        Intrinsics.checkNotNullParameter(videoAdRenderingController, "videoAdRenderingController");
        Intrinsics.checkNotNullParameter(videoAdStatusController, "videoAdStatusController");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(playbackEventsListener, "playbackEventsListener");
        this.f8993a = videoAdInfo;
        this.b = videoAdPlayer;
        this.c = progressTrackingManager;
        this.d = videoAdRenderingController;
        this.e = videoAdStatusController;
        this.f = adLoadingPhasesManager;
        this.g = videoTracker;
        this.h = playbackEventsListener;
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void a(jc2 playbackInfo) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        this.j = false;
        this.e.b(hd2.g);
        this.g.b();
        this.c.b();
        this.d.c();
        this.h.g(this.f8993a);
        this.b.a((gc2) null);
        this.h.j(this.f8993a);
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void b(jc2 playbackInfo) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        this.e.b(hd2.h);
        if (this.j) {
            this.g.d();
        }
        this.h.b(this.f8993a);
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void c(jc2 playbackInfo) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        if (this.j) {
            this.e.b(hd2.e);
            this.g.j();
        }
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void d(jc2 playbackInfo) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        this.e.b(hd2.d);
        this.f.a(f5.x);
        this.h.d(this.f8993a);
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void e(jc2 playbackInfo) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        this.g.g();
        this.j = false;
        this.e.b(hd2.f);
        this.c.b();
        this.d.d();
        this.h.e(this.f8993a);
        this.b.a((gc2) null);
        this.h.j(this.f8993a);
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void f(jc2 playbackInfo) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        if (this.j) {
            this.e.b(hd2.i);
            this.g.f();
        }
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void g(jc2 playbackInfo) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        this.e.b(hd2.e);
        if (this.j) {
            this.g.c();
        }
        this.c.a();
        this.h.f(this.f8993a);
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void h(jc2 playbackInfo) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        this.j = true;
        this.e.b(hd2.e);
        this.c.a();
        this.i = new nc2(this.b, this.g);
        this.h.c(this.f8993a);
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void a(un0 playbackInfo) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        this.g.e();
        this.j = false;
        this.e.b(hd2.f);
        this.c.b();
        this.d.d();
        this.h.a(this.f8993a);
        this.b.a((gc2) null);
        this.h.j(this.f8993a);
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void a(jc2 playbackInfo, pc2 videoAdPlayerError) {
        hd2 hd2Var;
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        Intrinsics.checkNotNullParameter(videoAdPlayerError, "videoAdPlayerError");
        this.j = false;
        if (this.e.a(hd2.d)) {
            hd2Var = hd2.j;
        } else {
            hd2Var = hd2.k;
        }
        this.e.b(hd2Var);
        this.c.b();
        this.d.a(videoAdPlayerError);
        this.g.a(videoAdPlayerError);
        this.h.a(this.f8993a, videoAdPlayerError);
        this.b.a((gc2) null);
        this.h.j(this.f8993a);
    }

    @Override // com.yandex.mobile.ads.impl.qc2
    public final void a(jc2 playbackInfo, float f) {
        Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        this.g.a(f);
        nc2 nc2Var = this.i;
        if (nc2Var != null) {
            nc2Var.a(f);
        }
        this.h.a(this.f8993a, f);
    }
}
