package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class zn0 implements oc2<do0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final do0 f10835a;
    private final gm0 b;
    private a c;

    public zn0(do0 instreamVideoAd, gm0 instreamAdPlayerController) {
        Intrinsics.checkNotNullParameter(instreamVideoAd, "instreamVideoAd");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        this.f10835a = instreamVideoAd;
        this.b = instreamAdPlayerController;
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void a(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.b.g(videoAdInfo.d());
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final long b() {
        return this.b.a(this.f10835a);
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final long getAdPosition() {
        return this.b.b(this.f10835a);
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final float getVolume() {
        return this.b.c(this.f10835a);
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final boolean isPlayingAd() {
        return this.b.d(this.f10835a);
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void a(gc2 gc2Var) {
        a aVar = this.c;
        if (aVar != null) {
            this.b.b(this.f10835a, aVar);
            this.c = null;
        }
        if (gc2Var != null) {
            a aVar2 = new a(gc2Var);
            this.b.a(this.f10835a, aVar2);
            this.c = aVar2;
        }
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void c() {
        this.b.f(this.f10835a);
    }

    public final void e() {
        this.b.j(this.f10835a);
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void pauseAd() {
        this.b.e(this.f10835a);
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void resumeAd() {
        this.b.i(this.f10835a);
    }

    public final void d() {
        this.b.h(this.f10835a);
    }

    public final void a(float f) {
        this.b.a(this.f10835a, f);
    }

    private static final class a implements ht {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qc2 f10836a;

        public a(gc2 listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f10836a = listener;
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void a(do0 videoAd) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            this.f10836a.a(videoAd.f());
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void b(do0 videoAd) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            this.f10836a.d(videoAd.f());
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void c(do0 videoAd) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            this.f10836a.b(videoAd.f());
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void d(do0 videoAd) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            this.f10836a.h(videoAd.f());
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void e(do0 videoAd) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            this.f10836a.g(videoAd.f());
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void f(do0 videoAd) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            this.f10836a.e(videoAd.f());
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void g(do0 videoAd) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            this.f10836a.a((jc2) videoAd.f());
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void h(do0 videoAd) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            this.f10836a.c(videoAd.f());
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void i(do0 videoAd) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            this.f10836a.f(videoAd.f());
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void a(do0 videoAd, pc2 error) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            Intrinsics.checkNotNullParameter(error, "error");
            this.f10836a.a(videoAd.f(), error);
        }

        @Override // com.yandex.mobile.ads.impl.ht
        public final void a(do0 videoAd, float f) {
            Intrinsics.checkNotNullParameter(videoAd, "videoAd");
            this.f10836a.a(videoAd.f(), f);
        }
    }

    @Override // com.yandex.mobile.ads.impl.oc2
    public final void a() {
        this.b.k(this.f10835a);
    }
}
