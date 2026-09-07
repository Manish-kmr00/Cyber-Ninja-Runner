package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class p92 implements fd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a8 f9904a;

    public p92(z92 configuration, a8 adRequestParametersProvider) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(adRequestParametersProvider, "adRequestParametersProvider");
        this.f9904a = adRequestParametersProvider;
    }

    @Override // com.yandex.mobile.ads.impl.fd2
    public final Map<String, String> a() {
        Pair[] pairArr = new Pair[3];
        String strD = this.f9904a.d();
        String str = "undefined";
        if (strD == null || strD.length() == 0) {
            strD = "undefined";
        }
        pairArr[0] = TuplesKt.to("page_id", strD);
        String strC = this.f9904a.c();
        if (strC != null && strC.length() != 0) {
            str = strC;
        }
        pairArr[1] = TuplesKt.to("imp_id", str);
        pairArr[2] = TuplesKt.to("ad_type", qs.h.a());
        return MapsKt.mapOf(pairArr);
    }
}
