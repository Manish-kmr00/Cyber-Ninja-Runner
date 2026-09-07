package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class qu1 implements br1<cu1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ar1<cu1> f10051a;
    private final mi2 b;

    public /* synthetic */ qu1(lp1 lp1Var) {
        this(lp1Var, rc1.a(lp1Var), new mi2());
    }

    @Override // com.yandex.mobile.ads.impl.br1
    public final cu1 a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        this.b.getClass();
        return this.f10051a.a(mi2.a(networkResponse));
    }

    public qu1(lp1 reporter, ar1<cu1> sdkConfigurationResponseParser, mi2 volleyMapper) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(sdkConfigurationResponseParser, "sdkConfigurationResponseParser");
        Intrinsics.checkNotNullParameter(volleyMapper, "volleyMapper");
        this.f10051a = sdkConfigurationResponseParser;
        this.b = volleyMapper;
    }
}
