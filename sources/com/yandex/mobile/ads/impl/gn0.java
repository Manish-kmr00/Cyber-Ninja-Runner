package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class gn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hn0 f9020a;

    public gn0(dt coreInstreamAdBreak, rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f9020a = new hn0(coreInstreamAdBreak, videoAdInfo);
    }

    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        uiElements.a().setTag(this.f9020a.a());
    }
}
