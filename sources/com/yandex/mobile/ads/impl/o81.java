package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o81 implements s51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fc0 f9792a;

    public o81(oa1 forcePausablePlayer) {
        Intrinsics.checkNotNullParameter(forcePausablePlayer, "forcePausablePlayer");
        this.f9792a = forcePausablePlayer;
    }

    @Override // com.yandex.mobile.ads.impl.s51
    public final void b() {
        this.f9792a.f();
    }

    @Override // com.yandex.mobile.ads.impl.s51
    public final void a() {
        this.f9792a.d();
    }
}
