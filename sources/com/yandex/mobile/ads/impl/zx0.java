package com.yandex.mobile.ads.impl;

import com.monetization.ads.mediation.base.MediatedAdapterInfo;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class zx0 {
    public static Map a(px0 mediatedAdData) {
        Intrinsics.checkNotNullParameter(mediatedAdData, "mediatedAdData");
        MediatedAdapterInfo mediatedAdapterInfoB = mediatedAdData.b();
        Pair[] pairArr = new Pair[3];
        String str = mediatedAdapterInfoB.getCom.ironsource.bu.b java.lang.String();
        if (str == null) {
            str = "null";
        }
        pairArr[0] = TuplesKt.to("mediation_adapter_version", str);
        String networkName = mediatedAdapterInfoB.getNetworkName();
        if (networkName == null) {
            networkName = "null";
        }
        pairArr[1] = TuplesKt.to("mediation_network_name", networkName);
        String networkSdkVersion = mediatedAdapterInfoB.getNetworkSdkVersion();
        pairArr[2] = TuplesKt.to("mediation_network_sdk_version", networkSdkVersion != null ? networkSdkVersion : "null");
        return MapsKt.mapOf(pairArr);
    }
}
