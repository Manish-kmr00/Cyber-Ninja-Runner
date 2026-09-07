package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rk2 implements eq1<eb2, List<? extends eb2>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fd2 f10116a;

    public rk2(fd2 reportParametersProvider) {
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        this.f10116a = reportParametersProvider;
    }

    @Override // com.yandex.mobile.ads.impl.eq1
    public final hp1 a(eb2 eb2Var) {
        eb2 request = eb2Var;
        Intrinsics.checkNotNullParameter(request, "request");
        Map<String, String> reportData = this.f10116a.a();
        hp1.b reportType = hp1.b.o;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        return new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), (f) null);
    }

    @Override // com.yandex.mobile.ads.impl.eq1
    public final hp1 a(qq1<List<? extends eb2>> qq1Var, int i, eb2 eb2Var) {
        hp1.c cVar;
        eb2 request = eb2Var;
        Intrinsics.checkNotNullParameter(request, "request");
        List<? extends eb2> list = qq1Var != null ? qq1Var.f10044a : null;
        if (204 == i) {
            cVar = hp1.c.e;
        } else if (list != null && i == 200) {
            cVar = list.isEmpty() ? hp1.c.e : hp1.c.c;
        } else {
            cVar = hp1.c.d;
        }
        Map reportData = MapsKt.plus(this.f10116a.a(), MapsKt.mapOf(TuplesKt.to("status", cVar.a())));
        hp1.b reportType = hp1.b.p;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        return new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), (f) null);
    }
}
