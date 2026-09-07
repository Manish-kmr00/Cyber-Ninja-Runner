package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class v61 implements si2<u61> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final aq1<u61> f10450a;

    public v61(aq1<u61> requestPolicy) {
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        this.f10450a = requestPolicy;
    }

    @Override // com.yandex.mobile.ads.impl.si2
    public final u61 a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        return this.f10450a.a(networkResponse);
    }
}
