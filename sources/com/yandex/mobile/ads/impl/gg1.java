package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class gg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9001a;
    private final dz0 b;

    public gg1(String str, dz0 mediationData) {
        Intrinsics.checkNotNullParameter(mediationData, "mediationData");
        this.f9001a = str;
        this.b = mediationData;
    }

    public final Map<String, String> a() {
        String str = this.f9001a;
        if (str != null && str.length() != 0) {
            return MapsKt.plus(this.b.d(), MapsKt.mapOf(TuplesKt.to("adf-resp_time", this.f9001a)));
        }
        return this.b.d();
    }
}
