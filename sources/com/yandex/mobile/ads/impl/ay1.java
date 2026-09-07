package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ay1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f8458a;
    private final t71 b;
    private final lp1 c;

    public ay1(Context context, o8<?> adResponse, o3 adConfiguration, t71 t71Var, lp1 metricaReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        this.f8458a = adResponse;
        this.b = t71Var;
        this.c = metricaReporter;
    }

    public final void a(List<s02> socialActionItems) {
        Intrinsics.checkNotNullParameter(socialActionItems, "socialActionItems");
        ip1 ip1Var = new ip1((Map) null, 3);
        ip1Var.b(hp1.a.f9125a, "adapter");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(socialActionItems, 10));
        Iterator<T> it = socialActionItems.iterator();
        while (it.hasNext()) {
            arrayList.add(((s02) it.next()).b());
        }
        ip1Var.b((String[]) arrayList.toArray(new String[0]), "social_actions");
        t71 t71Var = this.b;
        if (t71Var != null) {
            ip1Var = jp1.a(ip1Var, t71Var.a());
        }
        ip1Var.a(this.f8458a.a());
        hp1.b bVar = hp1.b.G;
        Map<String, Object> mapB = ip1Var.b();
        this.c.a(new hp1(bVar.a(), (Map<String, Object>) MapsKt.toMutableMap(mapB), ze1.a(ip1Var, bVar, "reportType", mapB, "reportData")));
    }
}
