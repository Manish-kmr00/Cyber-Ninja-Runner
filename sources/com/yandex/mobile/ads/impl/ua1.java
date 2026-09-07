package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class ua1 implements fd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10371a;

    public ua1(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f10371a = adConfiguration;
    }

    @Override // com.yandex.mobile.ads.impl.fd2
    public final Map<String, String> a() {
        Pair[] pairArr = new Pair[2];
        String strC = this.f10371a.c();
        if (strC == null || StringsKt.isBlank(strC)) {
            strC = "undefined";
        }
        pairArr[0] = TuplesKt.to("block_id", strC);
        pairArr[1] = TuplesKt.to("ad_type", this.f10371a.b().a());
        return MapsKt.mapOf(pairArr);
    }
}
