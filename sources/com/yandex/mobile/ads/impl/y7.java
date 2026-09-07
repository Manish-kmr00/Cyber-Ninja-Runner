package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class y7 implements dq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10707a;
    private final c8 b;

    public y7(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f10707a = adConfiguration;
        this.b = new c8();
    }

    @Override // com.yandex.mobile.ads.impl.dq1
    public final Map<String, Object> a() {
        Map<String, Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("ad_type", this.f10707a.b().a()));
        String strC = this.f10707a.c();
        if (strC != null) {
            mapMutableMapOf.put("block_id", strC);
            mapMutableMapOf.put("ad_unit_id", strC);
        }
        mapMutableMapOf.putAll(this.b.a(this.f10707a.a()).b());
        return mapMutableMapOf;
    }
}
