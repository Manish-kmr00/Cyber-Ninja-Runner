package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ko1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9441a;
    private final o8<?> b;
    private final s9 c;
    private final lp1 d;
    private final cu1 e;
    private final uq f;
    private q91 g;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ko1(Context context, o3 o3Var, o8 o8Var, s9 s9Var) {
        o3Var.q().f();
        o01 o01VarA = nd.a(context, bn2.f8524a, o3Var.q().b());
        int i = iw1.l;
        this(context, o3Var, o8Var, s9Var, o01VarA, iw1.a.a().a(context), new uq());
    }

    public final void a() {
        List listListOf;
        ip1 ip1VarA = this.f.a(this.b, this.f9441a);
        ip1VarA.b(hp1.a.f9125a, "adapter");
        q91 q91Var = this.g;
        if (q91Var != null) {
            ip1VarA.a((Map<String, ? extends Object>) q91Var.a());
        }
        zy1 zy1VarR = this.f9441a.r();
        if (zy1VarR != null) {
            ip1VarA.b(zy1VarR.a().a(), "size_type");
            ip1VarA.b(Integer.valueOf(zy1VarR.getWidth()), "width");
            ip1VarA.b(Integer.valueOf(zy1VarR.getHeight()), "height");
        }
        cu1 cu1Var = this.e;
        if (cu1Var != null) {
            ip1VarA.b(cu1Var.m(), "banner_size_calculation_type");
        }
        int iOrdinal = this.c.ordinal();
        if (iOrdinal == 0) {
            listListOf = CollectionsKt.listOf((Object[]) new hp1.b[]{hp1.b.w, hp1.b.v});
        } else if (iOrdinal == 1) {
            listListOf = CollectionsKt.listOf(hp1.b.w);
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            listListOf = CollectionsKt.listOf(hp1.b.v);
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            this.d.a(new hp1((hp1.b) it.next(), (Map<String, ? extends Object>) ip1VarA.b(), ip1VarA.a()));
        }
    }

    public ko1(Context context, o3 adConfiguration, o8<?> adResponse, s9 adStructureType, lp1 metricaReporter, cu1 cu1Var, uq commonReportDataProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        this.f9441a = adConfiguration;
        this.b = adResponse;
        this.c = adStructureType;
        this.d = metricaReporter;
        this.e = cu1Var;
        this.f = commonReportDataProvider;
    }

    public final void a(q91 q91Var) {
        this.g = q91Var;
    }
}
