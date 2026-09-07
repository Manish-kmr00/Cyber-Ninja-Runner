package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class gm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gt f9017a;
    private final hm0 b;

    public final void a(do0 videoAd, ht listener) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b.a(videoAd, listener);
    }

    public final long b(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.f9017a.b(videoAd);
    }

    public final float c(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.f9017a.k(videoAd);
    }

    public final boolean d(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.f9017a.j(videoAd);
    }

    public final void e(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f9017a.f(videoAd);
    }

    public final void f(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f9017a.c(videoAd);
    }

    public final void g(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f9017a.d(videoAd);
    }

    public final void h(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f9017a.e(videoAd);
    }

    public final void i(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f9017a.g(videoAd);
    }

    public final void j(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f9017a.h(videoAd);
    }

    public final void k(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f9017a.i(videoAd);
    }

    public /* synthetic */ gm0(gt gtVar) {
        this(gtVar, new hm0());
    }

    public gm0(gt instreamAdPlayer, hm0 instreamAdPlayerEventsObservable) {
        Intrinsics.checkNotNullParameter(instreamAdPlayer, "instreamAdPlayer");
        Intrinsics.checkNotNullParameter(instreamAdPlayerEventsObservable, "instreamAdPlayerEventsObservable");
        this.f9017a = instreamAdPlayer;
        this.b = instreamAdPlayerEventsObservable;
    }

    public final long a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.f9017a.a(videoAd);
    }

    public final void b(do0 videoAd, ht listener) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b.b(videoAd, listener);
    }

    public final void a(do0 videoAd, float f) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f9017a.a(videoAd, f);
    }

    public final void b() {
        this.f9017a.a((hm0) null);
        this.b.a();
    }

    public final void a() {
        this.f9017a.a(this.b);
    }
}
