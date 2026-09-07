package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class wc1 implements vc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rj f10555a;

    @Override // com.yandex.mobile.ads.impl.vc1
    public final String a(pq1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        byte[] bArrA = networkResponse.a().a();
        if (bArrA == null) {
            return null;
        }
        if (!kf0.a(networkResponse.b(), sh0.e0, true)) {
            return new String(bArrA, Charsets.UTF_8);
        }
        this.f10555a.getClass();
        return rj.a(bArrA);
    }

    public /* synthetic */ wc1() {
        this(new rj());
    }

    public wc1(rj base64Decoder) {
        Intrinsics.checkNotNullParameter(base64Decoder, "base64Decoder");
        this.f10555a = base64Decoder;
    }
}
