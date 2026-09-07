package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
public final class y22 implements ar1<String> {
    @Override // com.yandex.mobile.ads.impl.ar1
    public final String a(pq1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        byte[] bArrA = networkResponse.a().a();
        if (bArrA == null) {
            return null;
        }
        try {
            return new String(bArrA, kf0.a(networkResponse.b()));
        } catch (Exception unused) {
            return new String(bArrA, Charsets.UTF_8);
        }
    }
}
