package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dt f9120a;
    private final rb2<do0> b;

    public hn0(dt adBreak, rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9120a = adBreak;
        this.b = videoAdInfo;
    }

    public final String a() {
        return "yma_" + this.f9120a + "_position_" + this.b.d().b().a();
    }
}
