package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y4 f9782a;
    private final m51 b;
    private final ac1 c;
    private final fx0 d;
    private final i62 e;

    public o51(y4 adInfoReportDataProviderFactory, m51 eventControllerFactory, ac1 nativeViewRendererFactory, fx0 mediaViewAdapterFactory, i62 trackingManagerFactory) {
        Intrinsics.checkNotNullParameter(adInfoReportDataProviderFactory, "adInfoReportDataProviderFactory");
        Intrinsics.checkNotNullParameter(eventControllerFactory, "eventControllerFactory");
        Intrinsics.checkNotNullParameter(nativeViewRendererFactory, "nativeViewRendererFactory");
        Intrinsics.checkNotNullParameter(mediaViewAdapterFactory, "mediaViewAdapterFactory");
        Intrinsics.checkNotNullParameter(trackingManagerFactory, "trackingManagerFactory");
        this.f9782a = adInfoReportDataProviderFactory;
        this.b = eventControllerFactory;
        this.c = nativeViewRendererFactory;
        this.d = mediaViewAdapterFactory;
        this.e = trackingManagerFactory;
    }

    public final y4 a() {
        return this.f9782a;
    }

    public final m51 b() {
        return this.b;
    }

    public final ac1 d() {
        return this.c;
    }

    public final fx0 c() {
        return this.d;
    }

    public final i62 e() {
        return this.e;
    }
}
