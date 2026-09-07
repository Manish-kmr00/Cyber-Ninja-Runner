package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x92 implements vg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10633a;
    private final kb2 b;

    public x92(String responseStatus, kb2 kb2Var) {
        Intrinsics.checkNotNullParameter(responseStatus, "responseStatus");
        this.f10633a = responseStatus;
        this.b = kb2Var;
    }

    @Override // com.yandex.mobile.ads.impl.vg1
    public final Map<String, Object> a(long j) {
        Map<String, Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("duration", Long.valueOf(j)), TuplesKt.to("status", this.f10633a));
        kb2 kb2Var = this.b;
        if (kb2Var != null) {
            mapMutableMapOf.put("failure_reason", kb2Var.a());
        }
        return mapMutableMapOf;
    }
}
