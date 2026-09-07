package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t9 f9393a;
    private final String b;

    public k9(t9 adTagUri, String str) {
        Intrinsics.checkNotNullParameter(adTagUri, "adTagUri");
        this.f9393a = adTagUri;
        this.b = str;
    }

    public final t9 a() {
        return this.f9393a;
    }

    public final String b() {
        return this.b;
    }
}
