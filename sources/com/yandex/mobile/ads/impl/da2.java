package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class da2 implements eq1<z92, r92> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a8 f8676a;

    public da2(a8 adRequestParametersProvider) {
        Intrinsics.checkNotNullParameter(adRequestParametersProvider, "adRequestParametersProvider");
        this.f8676a = adRequestParametersProvider;
    }

    @Override // com.yandex.mobile.ads.impl.eq1
    public final hp1 a(z92 z92Var) {
        z92 requestConfiguration = z92Var;
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Map<String, Object> reportData = a();
        hp1.b reportType = hp1.b.m;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        return new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), (f) null);
    }

    @Override // com.yandex.mobile.ads.impl.eq1
    public final hp1 a(qq1<r92> qq1Var, int i, z92 z92Var) {
        z92 requestConfiguration = z92Var;
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Map reportData = MapsKt.toMutableMap(a());
        if (i != -1) {
            reportData.put("code", Integer.valueOf(i));
        }
        hp1.b reportType = hp1.b.n;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        return new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), (f) null);
    }

    private final Map<String, Object> a() {
        Pair[] pairArr = new Pair[3];
        String strD = this.f8676a.d();
        if (strD == null) {
            strD = "";
        }
        if (strD.length() == 0) {
            strD = "null";
        }
        pairArr[0] = TuplesKt.to("page_id", strD);
        String strC = this.f8676a.c();
        String str = strC != null ? strC : "";
        pairArr[1] = TuplesKt.to("imp_id", str.length() != 0 ? str : "null");
        pairArr[2] = TuplesKt.to("ad_type", qs.h.a());
        return MapsKt.mapOf(pairArr);
    }
}
