package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class dk<T> implements eq1<o3, o8<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c8 f8703a;
    private final q8<T> b;

    public interface a<K> {
        ip1 a(qq1<o8<K>> qq1Var, o3 o3Var);
    }

    public dk(a<T> responseReportDataProvider) {
        Intrinsics.checkNotNullParameter(responseReportDataProvider, "responseReportDataProvider");
        this.f8703a = new c8();
        this.b = new q8<>(responseReportDataProvider);
    }

    @Override // com.yandex.mobile.ads.impl.eq1
    public final hp1 a(o3 o3Var) {
        o3 adConfiguration = o3Var;
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA2 = a2(adConfiguration);
        hp1.b bVar = hp1.b.k;
        Map<String, Object> mapB = ip1VarA2.b();
        return new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA2, bVar, "reportType", mapB, "reportData"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    protected ip1 a2(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1Var = new ip1(new HashMap(), 2);
        v7 v7VarA = adConfiguration.a();
        if (v7VarA != null) {
            ip1Var = jp1.a(ip1Var, this.f8703a.a(v7VarA));
        }
        ip1Var.b(adConfiguration.c(), "block_id");
        ip1Var.b(adConfiguration.c(), "ad_unit_id");
        ip1Var.b(adConfiguration.b().a(), "ad_type");
        zy1 zy1VarR = adConfiguration.r();
        if (zy1VarR != null) {
            ip1Var.b(zy1VarR.a().a(), "size_type");
        }
        ip1Var.b(Boolean.valueOf(adConfiguration.t() == i82.a.c), "is_passback");
        return ip1Var;
    }

    @Override // com.yandex.mobile.ads.impl.eq1
    public final hp1 a(qq1 qq1Var, int i, o3 o3Var) {
        o3 adConfiguration = o3Var;
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA = a(i, adConfiguration, qq1Var);
        hp1.b bVar = hp1.b.l;
        Map<String, Object> mapB = ip1VarA.b();
        return new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1VarA, bVar, "reportType", mapB, "reportData"));
    }

    protected ip1 a(int i, o3 adConfiguration, qq1 qq1Var) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        return this.b.a(i, adConfiguration, qq1Var);
    }
}
