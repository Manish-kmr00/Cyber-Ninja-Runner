package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9901a;

    public p71(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f9901a = adConfiguration;
    }

    public final Map<String, Object> a() {
        Map<String, Object> mapMapOf;
        List<String> listM = this.f9901a.m();
        if (listM.isEmpty()) {
            listM = null;
        }
        return (listM == null || (mapMapOf = MapsKt.mapOf(TuplesKt.to("image_sizes", CollectionsKt.toList(listM)))) == null) ? MapsKt.emptyMap() : mapMapOf;
    }
}
