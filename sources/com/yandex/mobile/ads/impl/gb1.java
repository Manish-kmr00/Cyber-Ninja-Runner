package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class gb1 implements jc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8986a;
    private final int b;
    private final int c;

    public gb1(String url, int i, int i2) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f8986a = url;
        this.b = i;
        this.c = i2;
    }

    @Override // com.yandex.mobile.ads.impl.jc2
    public final String getUrl() {
        return this.f8986a;
    }

    public final int getAdWidth() {
        return this.b;
    }

    public final int getAdHeight() {
        return this.c;
    }
}
