package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ip1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f9252a;
    private f b;

    public /* synthetic */ ip1(Map map, int i) {
        this((Map<String, ? extends Object>) ((i & 1) != 0 ? MapsKt.emptyMap() : map), (f) null);
    }

    public ip1(Map<String, ? extends Object> reportData, f fVar) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        reportData = TypeIntrinsics.isMutableMap(reportData) ? reportData : null;
        this.f9252a = reportData == null ? new LinkedHashMap<>() : reportData;
        this.b = fVar;
    }

    public final Map<String, Object> b() {
        return this.f9252a;
    }

    public final void b(Object obj, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.f9252a.put(key, "undefined");
        } else {
            this.f9252a.put(key, obj);
        }
    }

    public final f a() {
        return this.b;
    }

    public final void a(f fVar) {
        this.b = fVar;
    }

    public final void a(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f9252a.putAll(data);
    }

    public final void a(List list) {
        Intrinsics.checkNotNullParameter("active_experiments", "key");
        if (list == null || !(!list.isEmpty())) {
            return;
        }
        this.f9252a.put("active_experiments", list);
    }

    public final void a(Object obj, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj != null) {
            this.f9252a.put(key, obj);
        }
    }
}
