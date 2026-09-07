package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d62 f9076a;

    public final bc1 a(o41 nativeAdBlock) {
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        u61 u61VarC = nativeAdBlock.c();
        List<ig<?>> listB = u61VarC.b();
        d62 d62Var = this.f9076a;
        List<xx1> listI = u61VarC.i();
        d62Var.getClass();
        ArrayList arrayListA = d62.a(null, listI);
        d62 d62Var2 = this.f9076a;
        List<String> listG = u61VarC.g();
        d62Var2.getClass();
        return new bc1(listB, arrayListA, d62.a(null, listG), "ad_unit", u61VarC.d());
    }

    public /* synthetic */ ha() {
        this(new d62());
    }

    public ha(d62 trackingDataCreator) {
        Intrinsics.checkNotNullParameter(trackingDataCreator, "trackingDataCreator");
        this.f9076a = trackingDataCreator;
    }
}
