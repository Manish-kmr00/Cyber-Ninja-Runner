package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g60 implements gt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r9 f8968a;
    private final xl1 b;
    private final d6 c;
    private final b6 d;
    private final z5 e;
    private final ri1 f;
    private final vi1 g;

    public g60(r9 adStateHolder, pi1 playerStateController, ol1 progressProvider, d6 prepareController, b6 playController, z5 adPlayerEventsController, ri1 playerStateHolder, vi1 playerVolumeController) {
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(progressProvider, "progressProvider");
        Intrinsics.checkNotNullParameter(prepareController, "prepareController");
        Intrinsics.checkNotNullParameter(playController, "playController");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(playerVolumeController, "playerVolumeController");
        this.f8968a = adStateHolder;
        this.b = progressProvider;
        this.c = prepareController;
        this.d = playController;
        this.e = adPlayerEventsController;
        this.f = playerStateHolder;
        this.g = playerVolumeController;
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final long a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.b.a().b();
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final long b(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.b.a().c();
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void c(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        try {
            this.d.b(videoAd);
        } catch (RuntimeException e) {
            op0.b(e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void d(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        try {
            this.c.a(videoAd);
        } catch (RuntimeException e) {
            op0.b(e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void e(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void f(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        try {
            this.d.a(videoAd);
        } catch (RuntimeException e) {
            op0.b(e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void g(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        try {
            this.d.c(videoAd);
        } catch (RuntimeException e) {
            op0.b(e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void h(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        try {
            this.d.d(videoAd);
        } catch (RuntimeException e) {
            op0.b(e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void i(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        try {
            this.d.e(videoAd);
        } catch (RuntimeException e) {
            op0.b(e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final boolean j(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        return this.f8968a.a(videoAd) != tm0.b && this.f.c();
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final float k(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Float fA = this.g.a();
        if (fA != null) {
            return fA.floatValue();
        }
        return 0.0f;
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void a(hm0 hm0Var) {
        this.e.a(hm0Var);
    }

    @Override // com.yandex.mobile.ads.impl.gt
    public final void a(do0 videoAd, float f) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.g.a(f);
        this.e.a(videoAd, f);
    }
}
