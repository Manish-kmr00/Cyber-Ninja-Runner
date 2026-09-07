package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class oi2 implements ni2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mi2 f9823a;
    private final vc1 b;

    public oi2(mi2 volleyMapper, vc1 networkResponseDecoder) {
        Intrinsics.checkNotNullParameter(volleyMapper, "volleyMapper");
        Intrinsics.checkNotNullParameter(networkResponseDecoder, "networkResponseDecoder");
        this.f9823a = volleyMapper;
        this.b = networkResponseDecoder;
    }

    @Override // com.yandex.mobile.ads.impl.ni2
    public final String a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        this.f9823a.getClass();
        return this.b.a(mi2.a(networkResponse));
    }
}
