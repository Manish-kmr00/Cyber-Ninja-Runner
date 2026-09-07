package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ic f10526a;

    public w12(ic advertiserPresentController) {
        Intrinsics.checkNotNullParameter(advertiserPresentController, "advertiserPresentController");
        this.f10526a = advertiserPresentController;
    }

    public final v12 a(rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        if (videoAdInfo.f() != null) {
            return v12.c;
        }
        return this.f10526a.a() ? v12.d : v12.b;
    }
}
