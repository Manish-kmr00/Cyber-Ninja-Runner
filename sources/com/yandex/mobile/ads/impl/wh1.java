package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class wh1 implements uc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fb1 f10565a;

    public wh1(fb1 nativeVideoPlaybackEventListener) {
        Intrinsics.checkNotNullParameter(nativeVideoPlaybackEventListener, "nativeVideoPlaybackEventListener");
        this.f10565a = nativeVideoPlaybackEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        this.f10565a.a(j, j2);
    }
}
