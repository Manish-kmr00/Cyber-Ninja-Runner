package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class jx1 implements gs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kx1 f9360a;
    private final v9 b;

    public jx1(Context context, o3 adConfiguration, kx1 serverSideReward, v9 adTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(serverSideReward, "serverSideReward");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        this.f9360a = serverSideReward;
        this.b = adTracker;
    }

    @Override // com.yandex.mobile.ads.impl.gs1
    public final void a() {
        this.b.a(this.f9360a.c(), s62.j);
    }
}
