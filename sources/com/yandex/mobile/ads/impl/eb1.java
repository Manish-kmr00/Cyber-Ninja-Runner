package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class eb1 implements fc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oa1 f8780a;
    private final me2 b;
    private final ic2 c;
    private final n92<gb1> d;
    private lc2 e;

    public /* synthetic */ eb1(Context context, o8 o8Var, o3 o3Var, oa1 oa1Var, rb2 rb2Var, yb1 yb1Var, mc2 mc2Var, fg2 fg2Var, vc2 vc2Var, me2 me2Var) {
        this(context, o8Var, o3Var, oa1Var, rb2Var, yb1Var, mc2Var, fg2Var, vc2Var, me2Var, new ic2(context, o3Var, mc2Var));
    }

    public eb1(Context context, o8 adResponse, o3 adConfiguration, oa1 videoAdPlayer, rb2 videoAdInfo, yb1 videoViewProvider, mc2 playbackParametersProvider, fg2 videoTracker, vc2 progressEventsObservable, me2 videoImpressionTrackingListener, ic2 playbackEventsReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(playbackParametersProvider, "playbackParametersProvider");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(progressEventsObservable, "progressEventsObservable");
        Intrinsics.checkNotNullParameter(videoImpressionTrackingListener, "videoImpressionTrackingListener");
        Intrinsics.checkNotNullParameter(playbackEventsReporter, "playbackEventsReporter");
        this.f8780a = videoAdPlayer;
        this.b = videoImpressionTrackingListener;
        this.c = playbackEventsReporter;
        n92<gb1> n92Var = new n92<>(context, adConfiguration, new qa1(videoAdPlayer), videoViewProvider, videoAdInfo, new lb1(videoViewProvider), new id2(), videoTracker, progressEventsObservable, new a(), adResponse);
        this.d = n92Var;
        n92Var.a(playbackParametersProvider);
    }

    @Override // com.yandex.mobile.ads.impl.fc2
    public final void play() {
        this.d.d();
    }

    @Override // com.yandex.mobile.ads.impl.fc2
    public final void stop() {
        this.d.b();
        this.f8780a.a();
    }

    private final class a implements hc2<gb1> {
        @Override // com.yandex.mobile.ads.impl.hc2
        public final void b(rb2<gb1> videoAdPlaybackInfo) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void c(rb2<gb1> videoAdPlaybackInfo) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
            eb1.this.c.b();
            lc2 lc2Var = eb1.this.e;
            if (lc2Var != null) {
                lc2Var.c();
            }
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void d(rb2<gb1> videoAdPlaybackInfo) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
            eb1.this.d.c();
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void e(rb2<gb1> videoAdPlaybackInfo) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
            a();
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void f(rb2<gb1> videoAdPlaybackInfo) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void g(rb2<gb1> videoAdPlaybackInfo) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
            eb1.this.c.a();
            a();
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void i(rb2<gb1> videoAdPlaybackInfo) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void j(rb2<gb1> videoAdInfo) {
            Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void k(rb2<gb1> videoAdPlaybackInfo) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
            eb1.this.b.h();
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void l(rb2<gb1> videoAdPlaybackInfo) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
            eb1.this.b.d();
        }

        public a() {
        }

        private final void a() {
            lc2 lc2Var = eb1.this.e;
            if (lc2Var != null) {
                lc2Var.b();
            }
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void a(rb2<gb1> videoAdPlaybackInfo, pc2 videoAdPlayerError) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
            Intrinsics.checkNotNullParameter(videoAdPlayerError, "videoAdPlayerError");
            eb1.this.f8780a.a(videoAdPlayerError);
            lc2 lc2Var = eb1.this.e;
            if (lc2Var != null) {
                lc2Var.a();
            }
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void a(rb2<gb1> videoAdPlaybackInfo) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
            a();
        }

        @Override // com.yandex.mobile.ads.impl.hc2
        public final void a(rb2<gb1> videoAdPlaybackInfo, float f) {
            Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
        }
    }

    @Override // com.yandex.mobile.ads.impl.fc2
    public final void a(lc2 lc2Var) {
        this.e = lc2Var;
    }
}
