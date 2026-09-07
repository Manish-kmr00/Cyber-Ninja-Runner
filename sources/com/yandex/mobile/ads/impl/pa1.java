package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class pa1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oa1 f9906a;
    private final sa1 b;

    public final void a(pe2 options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.b.a(options.a());
        this.f9906a.a(options.c());
    }

    public /* synthetic */ pa1(oa1 oa1Var) {
        this(oa1Var, new sa1(oa1Var));
    }

    public pa1(oa1 nativeVideoAdPlayer, sa1 playerVolumeManager) {
        Intrinsics.checkNotNullParameter(nativeVideoAdPlayer, "nativeVideoAdPlayer");
        Intrinsics.checkNotNullParameter(playerVolumeManager, "playerVolumeManager");
        this.f9906a = nativeVideoAdPlayer;
        this.b = playerVolumeManager;
    }
}
