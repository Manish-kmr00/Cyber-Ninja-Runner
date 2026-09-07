package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vq1<T> implements uq1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final si2<T> f10502a;
    private final mi2 b;

    @Override // com.yandex.mobile.ads.impl.uq1
    public final T a(pq1 response) {
        Intrinsics.checkNotNullParameter(response, "networkResponse");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(response, "response");
        return this.f10502a.a(new tc1(response.c(), response.a().a(), response.b(), true));
    }

    public /* synthetic */ vq1(si2 si2Var) {
        this(si2Var, new mi2());
    }

    public vq1(si2<T> responseBodyParser, mi2 volleyMapper) {
        Intrinsics.checkNotNullParameter(responseBodyParser, "responseBodyParser");
        Intrinsics.checkNotNullParameter(volleyMapper, "volleyMapper");
        this.f10502a = responseBodyParser;
        this.b = volleyMapper;
    }
}
