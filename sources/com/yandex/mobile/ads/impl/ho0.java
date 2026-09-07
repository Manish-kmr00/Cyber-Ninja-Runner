package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ho0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f9122a = new LinkedHashMap();

    public final in0 a(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        return (in0) this.f9122a.get(videoAdInfo);
    }

    public final void a(rb2<do0> videoAdInfo, in0 controlsState) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(controlsState, "controlsState");
        this.f9122a.put(videoAdInfo, controlsState);
    }
}
