package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class qt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10048a;
    private final c8 b;
    private final uq c;

    public final void b(Context context, o8<?> adResponse) {
        Map mapEmptyMap;
        nr1 nr1VarJ;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Boolean boolValueOf = null;
        ip1 ip1Var = new ip1((Map) null, 3);
        if (adResponse != null && (nr1VarJ = adResponse.J()) != null) {
            boolValueOf = Boolean.valueOf(nr1VarJ.e());
        }
        if (Intrinsics.areEqual(boolValueOf, Boolean.TRUE)) {
            mapEmptyMap = MapsKt.mapOf(TuplesKt.to("rewarding_side", "server_side"));
        } else if (Intrinsics.areEqual(boolValueOf, Boolean.FALSE)) {
            mapEmptyMap = MapsKt.mapOf(TuplesKt.to("rewarding_side", "client_side"));
        } else {
            if (boolValueOf != null) {
                throw new NoWhenBranchMatchedException();
            }
            mapEmptyMap = MapsKt.emptyMap();
        }
        ip1Var.b(mapEmptyMap, "reward_info");
        a(context, adResponse, hp1.b.N, ip1Var);
    }

    public /* synthetic */ qt1(o3 o3Var) {
        this(o3Var, new c8(), new uq());
    }

    private final void a(Context context, o8<?> o8Var, hp1.b bVar, ip1 ip1Var) {
        c41 c41Var;
        zq1 zq1VarG;
        ip1 ip1VarA = this.b.a(this.f10048a.a());
        ip1VarA.b(o8Var.p(), "ad_unit_id");
        ip1VarA.b(o8Var.p(), "block_id");
        String str = hp1.a.f9125a;
        ip1VarA.b(str, "adapter");
        qs qsVarN = o8Var.n();
        ip1VarA.b(qsVarN != null ? qsVarN.a() : null, "ad_type");
        Object objI = o8Var.I();
        if (objI instanceof u61) {
            List<c41> listE = ((u61) objI).e();
            String strA = (listE == null || (c41Var = (c41) CollectionsKt.firstOrNull((List) listE)) == null || (zq1VarG = c41Var.g()) == null) ? null : zq1VarG.a();
            if (strA == null) {
                strA = "";
            }
            ip1VarA.b(strA, "native_ad_type");
        }
        ip1VarA.b(o8Var.m(), FirebaseAnalytics.Param.AD_SOURCE);
        ip1 ip1VarA2 = jp1.a(ip1VarA, ip1Var);
        Map<String, Object> mapB = ip1VarA2.b();
        hp1 hp1Var = new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA2, bVar, "reportType", mapB, "reportData"));
        this.f10048a.q().f();
        nd.a(context, bn2.f8524a, this.f10048a.q().b()).a(hp1Var);
        new id(context).a(bVar, hp1Var.b(), str, null);
    }

    public qt1(o3 adConfiguration, c8 adRequestReportDataProvider, uq commonReportDataProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adRequestReportDataProvider, "adRequestReportDataProvider");
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        this.f10048a = adConfiguration;
        this.b = adRequestReportDataProvider;
        this.c = commonReportDataProvider;
    }

    public final void a(Context context, o8<?> adResponse, p71 p71Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        ip1 ip1Var = new ip1((Map) null, 3);
        if (p71Var != null) {
            ip1Var.a((Map<String, ? extends Object>) p71Var.a());
        }
        a(context, adResponse, hp1.b.g, ip1Var);
    }

    public final void a(Context context, o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        ip1 ip1VarA = this.c.a(adResponse, this.f10048a);
        ip1VarA.b(hp1.c.c.a(), "status");
        a(context, adResponse, hp1.b.h, ip1VarA);
    }

    public final void a(Context context, o8<?> adResponse, q71 q71Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        ip1 ip1Var = new ip1((Map) null, 3);
        if (q71Var != null) {
            ip1Var = q71Var.a();
        }
        ip1Var.b(hp1.c.c.a(), "status");
        a(context, adResponse, hp1.b.h, ip1Var);
    }
}
