package com.yandex.mobile.ads.impl;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8964a = new Object();
    private final ug1 b = new ug1();
    private final LinkedHashMap c = new LinkedHashMap();
    private final ArrayList d = new ArrayList();

    public final List<e5> b() {
        List<e5> list;
        synchronized (this.f8964a) {
            list = CollectionsKt.toList(this.d);
        }
        return list;
    }

    public final void b(f5 adLoadingPhaseType) {
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        a(adLoadingPhaseType, null);
    }

    public final void a() {
        synchronized (this.f8964a) {
            this.c.clear();
            this.d.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(f5 adLoadingPhaseType) {
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        ug1 parametersProvider = this.b;
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        Intrinsics.checkNotNullParameter(parametersProvider, "parametersProvider");
        a(adLoadingPhaseType, parametersProvider, null);
    }

    public final void a(f5 adLoadingPhaseType, vg1 parametersProvider, z92 z92Var) {
        Long l;
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        Intrinsics.checkNotNullParameter(parametersProvider, "parametersProvider");
        synchronized (this.f8964a) {
            Map map = (Map) this.c.get(adLoadingPhaseType);
            Long lValueOf = (map == null || (l = (Long) map.get(z92Var)) == null) ? null : Long.valueOf(SystemClock.elapsedRealtime() - l.longValue());
            if (lValueOf != null) {
                this.d.add(new e5(adLoadingPhaseType, parametersProvider.a(lValueOf.longValue())));
            }
            Map map2 = (Map) this.c.get(adLoadingPhaseType);
            if (map2 != null) {
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(f5 adLoadingPhaseType, z92 z92Var) {
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        synchronized (this.f8964a) {
            Map linkedHashMap = (Map) this.c.get(adLoadingPhaseType);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            this.c.put(adLoadingPhaseType, linkedHashMap);
            linkedHashMap.put(z92Var, Long.valueOf(SystemClock.elapsedRealtime()));
            Unit unit = Unit.INSTANCE;
        }
    }
}
