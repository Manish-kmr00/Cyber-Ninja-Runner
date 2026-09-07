package com.yandex.mobile.ads.impl;

import com.monetization.ads.quality.base.model.configuration.AdQualityVerifiableNetwork;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class o7 {
    public static d7 a(b7 sdkAdQualityConfiguration) {
        z6 next;
        Intrinsics.checkNotNullParameter(sdkAdQualityConfiguration, "sdkAdQualityConfiguration");
        int iG = sdkAdQualityConfiguration.g();
        boolean zE = sdkAdQualityConfiguration.e();
        boolean zC = sdkAdQualityConfiguration.c();
        Map<String, c7> mapA = sdkAdQualityConfiguration.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = mapA.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            z6.a aVar = z6.c;
            String value = (String) entry.getKey();
            aVar.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<z6> it2 = z6.a().iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!Intrinsics.areEqual(next.b(), value));
            AdQualityVerifiableNetwork adQualityVerifiableNetworkA = z6.a.a(next);
            if (adQualityVerifiableNetworkA != null) {
                linkedHashMap.put(adQualityVerifiableNetworkA, new m7(((c7) entry.getValue()).a(), ((c7) entry.getValue()).b()));
            }
        }
        return new d7(iG, zE, zC, linkedHashMap, sdkAdQualityConfiguration.f());
    }
}
