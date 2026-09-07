package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class cw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bw f8645a;

    public cw(Context context, o3 adConfiguration, ip1 debugParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(debugParams, "debugParams");
        adConfiguration.q().f();
        this.f8645a = new bw(nd.a(context, bn2.f8524a, adConfiguration.q().b()), debugParams);
    }

    public final bw a() {
        return this.f8645a;
    }
}
