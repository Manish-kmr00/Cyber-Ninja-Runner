package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class fu1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s32 f8926a;

    public final boolean a(cu1 sdkConfiguration) {
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        this.f8926a.getClass();
        return System.currentTimeMillis() >= sdkConfiguration.w();
    }

    public /* synthetic */ fu1() {
        this(new s32());
    }

    public fu1(s32 systemCurrentTimeProvider) {
        Intrinsics.checkNotNullParameter(systemCurrentTimeProvider, "systemCurrentTimeProvider");
        this.f8926a = systemCurrentTimeProvider;
    }
}
