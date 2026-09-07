package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class yh2 implements uc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oc2<?> f10737a;
    private final ld2 b;

    public /* synthetic */ yh2(qa1 qa1Var, yb1 yb1Var) {
        this(qa1Var, yb1Var, new b31(), b31.a(yb1Var));
    }

    public yh2(qa1 videoAdPlayer, yb1 videoViewProvider, b31 mrcVideoAdViewValidatorFactory, ld2 videoAdVisibilityValidator) {
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(mrcVideoAdViewValidatorFactory, "mrcVideoAdViewValidatorFactory");
        Intrinsics.checkNotNullParameter(videoAdVisibilityValidator, "videoAdVisibilityValidator");
        this.f10737a = videoAdPlayer;
        this.b = videoAdVisibilityValidator;
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        if (this.b.a()) {
            if (this.f10737a.isPlayingAd()) {
                return;
            }
            this.f10737a.resumeAd();
        } else if (this.f10737a.isPlayingAd()) {
            this.f10737a.pauseAd();
        }
    }
}
