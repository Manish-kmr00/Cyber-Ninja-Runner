package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class uo0 implements uc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oc2<do0> f10411a;
    private final id2 b;
    private final mg2 c;

    public /* synthetic */ uo0(zn0 zn0Var, so0 so0Var, id2 id2Var) {
        this(zn0Var, so0Var, id2Var, new b31());
    }

    public uo0(zn0 videoAdPlayer, so0 videoViewProvider, id2 videoAdStatusController, b31 mrcVideoAdViewValidatorFactory) {
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(videoAdStatusController, "videoAdStatusController");
        Intrinsics.checkNotNullParameter(mrcVideoAdViewValidatorFactory, "mrcVideoAdViewValidatorFactory");
        this.f10411a = videoAdPlayer;
        this.b = videoAdStatusController;
        mrcVideoAdViewValidatorFactory.getClass();
        this.c = b31.a(videoViewProvider);
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        boolean zA = this.c.a();
        if (this.b.a() != hd2.i) {
            if (zA) {
                if (this.f10411a.isPlayingAd()) {
                    return;
                }
                this.f10411a.resumeAd();
            } else if (this.f10411a.isPlayingAd()) {
                this.f10411a.pauseAd();
            }
        }
    }
}
