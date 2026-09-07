package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bs0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8536a;
    private final o3 b;
    private final Cif c;
    private final f11 d;

    public /* synthetic */ bs0(Context context, o3 o3Var) {
        this(context, o3Var, new Cif(), f11.e.a());
    }

    public bs0(Context context, o3 adConfiguration, Cif appMetricaIntegrationValidator, f11 mobileAdsIntegrationValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(appMetricaIntegrationValidator, "appMetricaIntegrationValidator");
        Intrinsics.checkNotNullParameter(mobileAdsIntegrationValidator, "mobileAdsIntegrationValidator");
        this.f8536a = context;
        this.b = adConfiguration;
        this.c = appMetricaIntegrationValidator;
        this.d = mobileAdsIntegrationValidator;
    }

    public final w3 b() {
        List listPlus = CollectionsKt.plus((Collection) a(), (Iterable) CollectionsKt.listOfNotNull(this.b.r() == null ? w7.e() : null));
        String strA = this.b.b().a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
        Iterator it = listPlus.iterator();
        while (it.hasNext()) {
            arrayList.add(((w3) it.next()).d());
        }
        a4.a(strA, arrayList);
        return (w3) CollectionsKt.firstOrNull(listPlus);
    }

    public final w3 c() {
        return (w3) CollectionsKt.firstOrNull((List) a());
    }

    private final List<w3> a() {
        w3 w3VarA;
        w3 w3VarA2;
        w3[] w3VarArr = new w3[4];
        try {
            this.c.a();
            w3VarA = null;
        } catch (xo0 e) {
            int i = w7.A;
            w3VarA = w7.a(e.getMessage(), e.a());
        }
        w3VarArr[0] = w3VarA;
        try {
            this.d.a(this.f8536a);
            w3VarA2 = null;
        } catch (xo0 e2) {
            int i2 = w7.A;
            w3VarA2 = w7.a(e2.getMessage(), e2.a());
        }
        w3VarArr[1] = w3VarA2;
        w3VarArr[2] = this.b.c() == null ? w7.f() : null;
        w3VarArr[3] = this.b.a() == null ? w7.t() : null;
        return CollectionsKt.listOfNotNull((Object[]) w3VarArr);
    }
}
