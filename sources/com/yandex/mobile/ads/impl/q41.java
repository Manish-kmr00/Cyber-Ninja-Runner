package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<y91, p41> f9981a;

    public q41(uu1 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f9981a = MapsKt.mapOf(TuplesKt.to(y91.c, new r81(sdkEnvironmentModule)), TuplesKt.to(y91.d, new c81(sdkEnvironmentModule)), TuplesKt.to(y91.e, new sz1()));
    }

    public final p41 a(y91 y91Var) {
        return this.f9981a.get(y91Var);
    }
}
