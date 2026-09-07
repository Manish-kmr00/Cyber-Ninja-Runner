package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class go0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ho0 f9023a;
    private final wz b;

    public go0(ho0 instreamVideoAdControlsStateStorage, wi1 playerVolumeProvider) {
        Intrinsics.checkNotNullParameter(instreamVideoAdControlsStateStorage, "instreamVideoAdControlsStateStorage");
        Intrinsics.checkNotNullParameter(playerVolumeProvider, "playerVolumeProvider");
        this.f9023a = instreamVideoAdControlsStateStorage;
        this.b = new wz(playerVolumeProvider);
    }

    public final in0 a(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        in0 in0VarA = this.f9023a.a(videoAdInfo);
        return in0VarA == null ? this.b.a() : in0VarA;
    }
}
