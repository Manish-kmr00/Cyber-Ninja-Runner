package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class gp1 implements fc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oa1 f9026a;
    private final rb2<gb1> b;
    private final yc2 c;
    private final a d;
    private lc2 e;

    public /* synthetic */ gp1(oa1 oa1Var, rb2 rb2Var, vc2 vc2Var) {
        qa1 qa1Var = new qa1(oa1Var);
        this(oa1Var, rb2Var, vc2Var, qa1Var, new yc2(qa1Var, vc2Var));
    }

    public gp1(oa1 nativeVideoAdPlayer, rb2<gb1> videoAdInfo, vc2 videoAdProgressEventsObservable, oc2<?> videoAdPlayer, yc2 videoAdProgressTrackingManager) {
        Intrinsics.checkNotNullParameter(nativeVideoAdPlayer, "nativeVideoAdPlayer");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoAdProgressEventsObservable, "videoAdProgressEventsObservable");
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(videoAdProgressTrackingManager, "videoAdProgressTrackingManager");
        this.f9026a = nativeVideoAdPlayer;
        this.b = videoAdInfo;
        this.c = videoAdProgressTrackingManager;
        this.d = new a();
    }

    @Override // com.yandex.mobile.ads.impl.fc2
    public final void play() {
        this.f9026a.a(this.d);
        this.f9026a.a(this.b.d());
    }

    @Override // com.yandex.mobile.ads.impl.fc2
    public final void stop() {
        this.c.b();
        this.f9026a.pauseAd();
        this.f9026a.a();
    }

    private final class a implements qc2 {
        @Override // com.yandex.mobile.ads.impl.qc2
        public final void a(jc2 playbackInfo) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
            gp1.this.c.b();
            gp1.this.f9026a.a((qc2) null);
            lc2 lc2Var = gp1.this.e;
            if (lc2Var != null) {
                lc2Var.b();
            }
        }

        @Override // com.yandex.mobile.ads.impl.qc2
        public final void b(jc2 playbackInfo) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        }

        @Override // com.yandex.mobile.ads.impl.qc2
        public final void c(jc2 playbackInfo) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        }

        @Override // com.yandex.mobile.ads.impl.qc2
        public final void d(jc2 playbackInfo) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
            gp1.this.f9026a.c();
        }

        @Override // com.yandex.mobile.ads.impl.qc2
        public final void e(jc2 playbackInfo) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
            gp1.this.c.b();
            gp1.this.f9026a.a((qc2) null);
        }

        @Override // com.yandex.mobile.ads.impl.qc2
        public final void f(jc2 playbackInfo) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        }

        @Override // com.yandex.mobile.ads.impl.qc2
        public final void g(jc2 playbackInfo) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        }

        @Override // com.yandex.mobile.ads.impl.qc2
        public final void h(jc2 playbackInfo) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
            gp1.this.c.a();
            lc2 lc2Var = gp1.this.e;
            if (lc2Var != null) {
                lc2Var.c();
            }
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.qc2
        public final void a(un0 playbackInfo) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
            gp1.this.c.b();
            gp1.this.f9026a.a((qc2) null);
        }

        @Override // com.yandex.mobile.ads.impl.qc2
        public final void a(jc2 playbackInfo, pc2 videoAdPlayerError) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
            Intrinsics.checkNotNullParameter(videoAdPlayerError, "videoAdPlayerError");
            gp1.this.c.b();
            gp1.this.f9026a.a((qc2) null);
            gp1.this.f9026a.a(videoAdPlayerError);
        }

        @Override // com.yandex.mobile.ads.impl.qc2
        public final void a(jc2 playbackInfo, float f) {
            Intrinsics.checkNotNullParameter(playbackInfo, "playbackInfo");
        }
    }

    @Override // com.yandex.mobile.ads.impl.fc2
    public final void a(lc2 lc2Var) {
        this.e = lc2Var;
    }
}
