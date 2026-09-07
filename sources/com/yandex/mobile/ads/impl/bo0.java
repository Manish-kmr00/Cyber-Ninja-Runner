package com.yandex.mobile.ads.impl;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bo0 implements hc2<do0>, qn0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hc2<do0> f8525a;
    private final AtomicInteger b;

    public bo0(hc2<do0> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f8525a = listener;
        this.b = new AtomicInteger(2);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void b(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.b(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void c(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.c(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void d(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        m(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void e(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.e(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void f(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.f(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void g(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.g(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.qn0.a
    public final void h(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        m(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void i(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.i(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void j(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.j(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void k(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.k(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void l(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.l(videoAdInfo);
    }

    public final void a() {
        this.b.set(2);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void a(rb2<do0> videoAdInfo, pc2 videoAdPlayerError) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoAdPlayerError, "videoAdPlayerError");
        this.f8525a.a(videoAdInfo, videoAdPlayerError);
    }

    private final void m(rb2<do0> rb2Var) {
        if (this.b.decrementAndGet() == 0) {
            this.f8525a.d(rb2Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void a(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.a(videoAdInfo);
    }

    @Override // com.yandex.mobile.ads.impl.hc2
    public final void a(rb2<do0> videoAdInfo, float f) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f8525a.a(videoAdInfo, f);
    }
}
