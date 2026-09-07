package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class mi2 {
    public static pq1 a(tc1 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        int i = response.f10286a;
        tq1 tq1Var = new tq1(response.b);
        Map<String, String> mapEmptyMap = response.c;
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        return new pq1(i, tq1Var, mapEmptyMap);
    }
}
