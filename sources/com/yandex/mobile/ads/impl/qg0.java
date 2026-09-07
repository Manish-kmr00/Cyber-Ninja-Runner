package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qg0 implements si2<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ni2 f10015a;

    public /* synthetic */ qg0() {
        this(sc1.a());
    }

    @Override // com.yandex.mobile.ads.impl.si2
    public final String a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        return this.f10015a.a(networkResponse);
    }

    public qg0(ni2 volleyNetworkResponseDecoder) {
        Intrinsics.checkNotNullParameter(volleyNetworkResponseDecoder, "volleyNetworkResponseDecoder");
        this.f10015a = volleyNetworkResponseDecoder;
    }
}
