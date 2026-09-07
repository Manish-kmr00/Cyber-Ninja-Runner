package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i4 implements hc2<do0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io0 f9171a;
    private final hv b;
    private b4 c;

    public i4(fb2 adCreativePlaybackListener, hv currentAdCreativePlaybackEventListener) {
        Intrinsics.checkNotNullParameter(adCreativePlaybackListener, "adCreativePlaybackListener");
        Intrinsics.checkNotNullParameter(currentAdCreativePlaybackEventListener, "currentAdCreativePlaybackEventListener");
        this.f9171a = adCreativePlaybackListener;
        this.b = currentAdCreativePlaybackEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void a(rb2<do0> videoAdInfo, pc2 videoAdPlayerError) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoAdPlayerError, "videoAdPlayerError");
        this.f9171a.h(videoAdInfo.d());
        if (h(videoAdInfo)) {
            this.b.a(videoAdInfo, videoAdPlayerError);
        }
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void b(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9171a.c(videoAdInfo.d());
        if (h(videoAdInfo)) {
            this.b.b(videoAdInfo);
        }
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void c(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9171a.d(videoAdInfo.d());
        if (h(videoAdInfo)) {
            this.b.c(videoAdInfo);
        }
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void d(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9171a.b(videoAdInfo.d());
        if (h(videoAdInfo)) {
            this.b.d(videoAdInfo);
        }
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void e(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9171a.f(videoAdInfo.d());
        if (h(videoAdInfo)) {
            this.b.e(videoAdInfo);
        }
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void f(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9171a.e(videoAdInfo.d());
        if (h(videoAdInfo)) {
            this.b.f(videoAdInfo);
        }
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void g(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9171a.g(videoAdInfo.d());
        if (h(videoAdInfo)) {
            this.b.g(videoAdInfo);
        }
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void i(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9171a.j(videoAdInfo.d());
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void j(rb2<do0> videoAdInfo) {
        k4 k4VarA;
        ao0 ao0VarA;
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        b4 b4Var = this.c;
        if (b4Var == null || (k4VarA = b4Var.a(videoAdInfo)) == null || (ao0VarA = k4VarA.a()) == null) {
            return;
        }
        ao0VarA.e();
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void k(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void l(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void a(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9171a.a(videoAdInfo.d());
        if (h(videoAdInfo)) {
            this.b.a(videoAdInfo);
        }
    }

    private final boolean h(rb2<do0> rb2Var) {
        b4 b4Var = this.c;
        return Intrinsics.areEqual(b4Var != null ? b4Var.b() : null, rb2Var);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void a(rb2<do0> videoAdInfo, float f) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9171a.a(videoAdInfo.d(), f);
    }

    public final void a(b4 b4Var) {
        this.c = b4Var;
    }
}
