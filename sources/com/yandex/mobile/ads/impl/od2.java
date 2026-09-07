package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class od2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<eb2> f9809a;
    private final List<eb2> b;

    public od2(List<eb2> inLineAds, List<eb2> wrapperAds) {
        Intrinsics.checkNotNullParameter(inLineAds, "inLineAds");
        Intrinsics.checkNotNullParameter(wrapperAds, "wrapperAds");
        this.f9809a = inLineAds;
        this.b = wrapperAds;
    }

    public final List<eb2> a() {
        return this.f9809a;
    }

    public final List<eb2> b() {
        return this.b;
    }
}
