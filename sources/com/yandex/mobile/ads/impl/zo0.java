package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zo0 implements aq1<ox> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final si2<ox> f10840a;

    public zo0(si2<ox> responseParser) {
        Intrinsics.checkNotNullParameter(responseParser, "responseParser");
        this.f10840a = responseParser;
    }

    @Override // com.yandex.mobile.ads.impl.aq1
    public final boolean a() {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.aq1
    public final ox a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        return this.f10840a.a(networkResponse);
    }
}
