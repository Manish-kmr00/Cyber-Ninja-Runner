package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class pi2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mi2 f9932a;
    private final xc1<T> b;

    public pi2(o3 adConfiguration, si2<T> volleyResponseBodyParser, uq1<T> responseBodyParser, mi2 volleyMapper, xc1<T> responseParser) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(volleyResponseBodyParser, "volleyResponseBodyParser");
        Intrinsics.checkNotNullParameter(responseBodyParser, "responseBodyParser");
        Intrinsics.checkNotNullParameter(volleyMapper, "volleyMapper");
        Intrinsics.checkNotNullParameter(responseParser, "responseParser");
        this.f9932a = volleyMapper;
        this.b = responseParser;
    }

    public final o8<T> a(tc1 networkResponse, Map<String, String> headers, qs responseAdType) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(responseAdType, "responseAdType");
        this.f9932a.getClass();
        return this.b.a(mi2.a(networkResponse), headers, responseAdType);
    }
}
