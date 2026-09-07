package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class z5 implements ht {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n9 f10789a;
    private ht b;

    public z5(n9 adStartedListener) {
        Intrinsics.checkNotNullParameter(adStartedListener, "adStartedListener");
        this.f10789a = adStartedListener;
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        ht htVar = this.b;
        if (htVar != null) {
            htVar.a(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void b(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        ht htVar = this.b;
        if (htVar != null) {
            htVar.b(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void c(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        ht htVar = this.b;
        if (htVar != null) {
            htVar.c(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void d(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f10789a.a();
        ht htVar = this.b;
        if (htVar != null) {
            htVar.d(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void e(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        ht htVar = this.b;
        if (htVar != null) {
            htVar.e(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void f(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        ht htVar = this.b;
        if (htVar != null) {
            htVar.f(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void g(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        ht htVar = this.b;
        if (htVar != null) {
            htVar.g(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void h(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        ht htVar = this.b;
        if (htVar != null) {
            htVar.h(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void i(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        ht htVar = this.b;
        if (htVar != null) {
            htVar.i(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void a(do0 videoAd, pc2 error) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(error, "error");
        ht htVar = this.b;
        if (htVar != null) {
            htVar.a(videoAd, error);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void a(do0 videoAd, float f) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        ht htVar = this.b;
        if (htVar != null) {
            htVar.a(videoAd, f);
        }
    }

    public final void a(hm0 hm0Var) {
        this.b = hm0Var;
    }
}
