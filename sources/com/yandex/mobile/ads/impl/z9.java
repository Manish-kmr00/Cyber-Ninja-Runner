package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class z9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d62 f10800a;

    public final bc1 a(c41 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        d62 d62Var = this.f10800a;
        List<xx1> listH = nativeAd.h();
        d62Var.getClass();
        ArrayList arrayListA = d62.a(listH, null);
        d62 d62Var2 = this.f10800a;
        List<String> listF = nativeAd.f();
        d62Var2.getClass();
        return new bc1(nativeAd.b(), arrayListA, d62.a(listF, null), nativeAd.a(), nativeAd.c());
    }

    public /* synthetic */ z9() {
        this(new d62());
    }

    public z9(d62 trackingDataCreator) {
        Intrinsics.checkNotNullParameter(trackingDataCreator, "trackingDataCreator");
        this.f10800a = trackingDataCreator;
    }
}
