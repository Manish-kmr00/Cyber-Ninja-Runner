package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class jb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pe2 f9301a;
    private final jg2 b;
    private final fb1 c;
    private final rx1 d;
    private final pa1 e;
    private final jl1 f;
    private final vb1 g;
    private final th1 h;
    private final th1 i;
    private final zo1 j;
    private final a k;
    private final et0 l;
    private th1 m;

    public jb1(Context context, o8 adResponse, o3 adConfiguration, oa1 videoAdPlayer, db2 video, pe2 videoOptions, jg2 videoViewAdapter, mc2 playbackParametersProvider, fg2 videoTracker, me2 impressionTrackingListener, fb1 nativeVideoPlaybackEventListener, pj0 imageProvider, rx1 rx1Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(videoOptions, "videoOptions");
        Intrinsics.checkNotNullParameter(videoViewAdapter, "videoViewAdapter");
        Intrinsics.checkNotNullParameter(playbackParametersProvider, "playbackParametersProvider");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(impressionTrackingListener, "impressionTrackingListener");
        Intrinsics.checkNotNullParameter(nativeVideoPlaybackEventListener, "nativeVideoPlaybackEventListener");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        this.f9301a = videoOptions;
        this.b = videoViewAdapter;
        this.c = nativeVideoPlaybackEventListener;
        this.d = rx1Var;
        this.j = new zo1(videoViewAdapter, new b());
        this.k = new a();
        this.l = new et0();
        yb1 yb1Var = new yb1(videoViewAdapter);
        this.e = new pa1(videoAdPlayer);
        this.g = new vb1(videoAdPlayer);
        vc2 vc2Var = new vc2();
        new ta1(videoViewAdapter, videoAdPlayer, yb1Var, nativeVideoPlaybackEventListener).a(vc2Var);
        eb1 eb1Var = new eb1(context, adResponse, adConfiguration, videoAdPlayer, video.b(), yb1Var, playbackParametersProvider, videoTracker, vc2Var, impressionTrackingListener);
        gp1 gp1Var = new gp1(videoAdPlayer, video.b(), vc2Var);
        wb1 wb1Var = new wb1(videoAdPlayer, videoOptions);
        jl1 jl1Var = new jl1(video, new gj0(context, new z81(adResponse), imageProvider));
        this.f = jl1Var;
        this.i = new th1(videoViewAdapter, eb1Var, wb1Var, jl1Var);
        this.h = new th1(videoViewAdapter, gp1Var, wb1Var, jl1Var);
    }

    public final void b(ub1 nativeVideoView) {
        Intrinsics.checkNotNullParameter(nativeVideoView, "nativeVideoView");
        th1 th1Var = this.m;
        if (th1Var != null) {
            th1Var.a(nativeVideoView);
        }
        this.g.b(nativeVideoView);
    }

    public static final void a(jb1 jb1Var, th1 th1Var) {
        jb1Var.m = th1Var;
        if (th1Var != null) {
            th1Var.a(jb1Var.k);
        }
        th1 th1Var2 = jb1Var.m;
        if (th1Var2 != null) {
            th1Var2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class a implements lc2 {
        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(jb1 this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            jb1.a(this$0, this$0.h);
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.lc2
        public final void c() {
            ub1 ub1VarB = jb1.this.b.b();
            if (ub1VarB != null) {
                ub1VarB.setClickable(true);
            }
        }

        @Override // com.yandex.mobile.ads.impl.lc2
        public final void b() {
            jb1.this.m = null;
            rx1 rx1Var = jb1.this.d;
            if (rx1Var == null || !rx1Var.c()) {
                jb1.this.j.a();
            } else {
                et0 et0Var = jb1.this.l;
                final jb1 jb1Var = jb1.this;
                et0Var.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.jb1$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        jb1.a.a(jb1Var);
                    }
                });
            }
            jb1.this.c.b();
        }

        @Override // com.yandex.mobile.ads.impl.lc2
        public final void a() {
            jb1.this.c.a();
        }
    }

    public final void a() {
        ub1 ub1VarB = this.b.b();
        if (ub1VarB != null) {
            ub1VarB.setClickable(false);
        }
    }

    public final void a(ub1 nativeVideoView) {
        Intrinsics.checkNotNullParameter(nativeVideoView, "nativeVideoView");
        this.e.a(this.f9301a);
        this.g.a(nativeVideoView);
        this.f.a(nativeVideoView.b());
        th1 th1Var = this.i;
        this.m = th1Var;
        if (th1Var != null) {
            th1Var.a(this.k);
        }
        th1 th1Var2 = this.m;
        if (th1Var2 != null) {
            th1Var2.a();
        }
    }

    private final class b implements fp1 {
        @Override // com.yandex.mobile.ads.impl.fp1
        public final void a(ub1 nativeVideoView) {
            Intrinsics.checkNotNullParameter(nativeVideoView, "nativeVideoView");
            jb1 jb1Var = jb1.this;
            jb1.a(jb1Var, jb1Var.h);
        }

        public b() {
        }
    }
}
