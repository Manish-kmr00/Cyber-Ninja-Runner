package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ea2<T> implements uc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eg2 f8779a;
    private final oc2<T> b;
    private final lg2 c;
    private boolean d;

    public /* synthetic */ ea2(kg2 kg2Var, fg2 fg2Var, oc2 oc2Var) {
        this(kg2Var, fg2Var, oc2Var, new lg2(kg2Var));
    }

    public ea2(kg2 videoViewProvider, fg2 videoTracker, oc2 videoAdPlayer, lg2 singlePercentAreaValidator) {
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(singlePercentAreaValidator, "singlePercentAreaValidator");
        this.f8779a = videoTracker;
        this.b = videoAdPlayer;
        this.c = singlePercentAreaValidator;
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        if (this.d || j2 <= 0 || !this.c.a()) {
            return;
        }
        this.d = true;
        this.f8779a.a(this.b.getVolume(), j);
    }
}
