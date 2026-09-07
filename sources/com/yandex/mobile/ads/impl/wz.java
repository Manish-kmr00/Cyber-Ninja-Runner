package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final in0 f10606a;

    public wz(wi1 playerVolumeProvider) {
        Intrinsics.checkNotNullParameter(playerVolumeProvider, "playerVolumeProvider");
        in0.a aVar = new in0.a();
        float volume = playerVolumeProvider.getVolume();
        if (volume == 0.0f) {
            aVar.a(1.0f);
            aVar.b(true);
        } else {
            aVar.a(volume);
            aVar.b(false);
        }
        this.f10606a = aVar.a();
    }

    public final in0 a() {
        return this.f10606a;
    }
}
