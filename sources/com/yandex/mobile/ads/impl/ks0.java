package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ks0 implements js0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qe f9446a;
    private final qv1 b;
    private final xz0 c;
    private final rr d;
    private final yv e;
    private final bt0 f;

    public ks0(qe appDataSource, qv1 sdkIntegrationDataSource, xz0 mediationNetworksDataSource, rr consentsDataSource, yv debugErrorIndicatorDataSource, bt0 logsDataSource) {
        Intrinsics.checkNotNullParameter(appDataSource, "appDataSource");
        Intrinsics.checkNotNullParameter(sdkIntegrationDataSource, "sdkIntegrationDataSource");
        Intrinsics.checkNotNullParameter(mediationNetworksDataSource, "mediationNetworksDataSource");
        Intrinsics.checkNotNullParameter(consentsDataSource, "consentsDataSource");
        Intrinsics.checkNotNullParameter(debugErrorIndicatorDataSource, "debugErrorIndicatorDataSource");
        Intrinsics.checkNotNullParameter(logsDataSource, "logsDataSource");
        this.f9446a = appDataSource;
        this.b = sdkIntegrationDataSource;
        this.c = mediationNetworksDataSource;
        this.d = consentsDataSource;
        this.e = debugErrorIndicatorDataSource;
        this.f = logsDataSource;
    }

    @Override // com.yandex.mobile.ads.impl.js0
    public final kx a() {
        return new kx(this.f9446a.a(), this.b.a(), this.c.a(), this.d.a(), this.e.a(), this.f.a());
    }

    @Override // com.yandex.mobile.ads.impl.js0
    public final void a(boolean z) {
        this.e.a(z);
    }
}
