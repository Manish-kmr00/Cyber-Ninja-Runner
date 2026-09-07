package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class qy1 implements kd1 {
    private static final List<yx1> c = CollectionsKt.listOf((Object[]) new yx1[]{yx1.b, yx1.c});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<yx1, kd1> f10057a;
    private boolean b;

    public qy1(l62 innerAdNoticeReportController, l62 blockNoticeReportController) {
        Intrinsics.checkNotNullParameter(innerAdNoticeReportController, "innerAdNoticeReportController");
        Intrinsics.checkNotNullParameter(blockNoticeReportController, "blockNoticeReportController");
        this.f10057a = MapsKt.mapOf(TuplesKt.to(yx1.b, innerAdNoticeReportController), TuplesKt.to(yx1.c, blockNoticeReportController));
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void a(yx1 showNoticeType, f92 validationResult) {
        Intrinsics.checkNotNullParameter(showNoticeType, "showNoticeType");
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        kd1 kd1Var = this.f10057a.get(showNoticeType);
        if (kd1Var != null) {
            kd1Var.a(showNoticeType, validationResult);
        }
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void invalidate() {
        Iterator<T> it = this.f10057a.values().iterator();
        while (it.hasNext()) {
            ((kd1) it.next()).invalidate();
        }
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void a(List<qd1> forcedFailures) {
        Intrinsics.checkNotNullParameter(forcedFailures, "forcedFailures");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : forcedFailures) {
            yx1 yx1VarC = ((qd1) obj).a().c();
            Object arrayList = linkedHashMap.get(yx1VarC);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(yx1VarC, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (Map.Entry entry : MapsKt.withDefault(linkedHashMap, a.b).entrySet()) {
            yx1 yx1Var = (yx1) entry.getKey();
            List<qd1> list = (List) entry.getValue();
            kd1 kd1Var = this.f10057a.get(yx1Var);
            if (kd1Var != null) {
                kd1Var.a(list);
            }
        }
    }

    static final class a extends Lambda implements Function1<yx1, List<? extends qd1>> {
        public static final a b = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final List<? extends qd1> invoke(yx1 yx1Var) {
            yx1 it = yx1Var;
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void a(yx1 showNoticeType, List<? extends yx1> notTrackedShowNoticeTypes) {
        Intrinsics.checkNotNullParameter(showNoticeType, "showNoticeType");
        Intrinsics.checkNotNullParameter(notTrackedShowNoticeTypes, "notTrackedShowNoticeTypes");
        if (!this.b) {
            this.b = true;
            List<? extends yx1> listPlus = CollectionsKt.plus((Collection<? extends yx1>) notTrackedShowNoticeTypes, showNoticeType);
            for (yx1 yx1Var : CollectionsKt.minus((Iterable) c, (Iterable) CollectionsKt.toSet(listPlus))) {
                a(yx1Var);
                a(yx1Var, listPlus);
            }
        }
        if (!(notTrackedShowNoticeTypes instanceof Collection) || !notTrackedShowNoticeTypes.isEmpty()) {
            Iterator<T> it = notTrackedShowNoticeTypes.iterator();
            while (it.hasNext()) {
                if (((yx1) it.next()) == showNoticeType) {
                    return;
                }
            }
        }
        kd1 kd1Var = this.f10057a.get(showNoticeType);
        if (kd1Var != null) {
            kd1Var.a(showNoticeType, notTrackedShowNoticeTypes);
        }
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void a(yx1 showNoticeType) {
        Intrinsics.checkNotNullParameter(showNoticeType, "showNoticeType");
        kd1 kd1Var = this.f10057a.get(showNoticeType);
        if (kd1Var != null) {
            kd1Var.a(showNoticeType);
        }
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void a(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Iterator<T> it = this.f10057a.values().iterator();
        while (it.hasNext()) {
            ((kd1) it.next()).a(adResponse);
        }
    }
}
