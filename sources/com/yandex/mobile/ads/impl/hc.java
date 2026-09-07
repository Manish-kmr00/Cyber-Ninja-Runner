package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class hc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<do0> f9081a;
    private final ic b;

    public hc(rb2<do0> videoAdInfo, ic advertiserPresentController) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(advertiserPresentController, "advertiserPresentController");
        this.f9081a = videoAdInfo;
        this.b = advertiserPresentController;
    }

    public final gc a() {
        v12 v12VarA = new w12(this.b).a(this.f9081a);
        b12 b12VarF = this.f9081a.f();
        if (v12.c != v12VarA || b12VarF == null) {
            return v12.d == v12VarA ? new z40() : new xy();
        }
        return new a12(b12VarF);
    }
}
