package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.InstreamAdRequestConfiguration;
import java.util.Collections;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cm2 implements gi2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InstreamAdRequestConfiguration f8627a;

    public cm2(InstreamAdRequestConfiguration adRequestConfiguration) {
        Intrinsics.checkNotNullParameter(adRequestConfiguration, "adRequestConfiguration");
        this.f8627a = adRequestConfiguration;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof cm2) && Intrinsics.areEqual(this.f8627a, ((cm2) obj).f8627a);
    }

    public final int hashCode() {
        return this.f8627a.hashCode();
    }

    public final String toString() {
        return "YandexInstreamAdRequestConfigurationAdapter(adRequestConfiguration=" + this.f8627a + ")";
    }

    @Override // com.yandex.mobile.ads.impl.gi2
    public final String b() {
        return this.f8627a.getCategoryId();
    }

    @Override // com.yandex.mobile.ads.impl.gi2
    public final String a() {
        return this.f8627a.getPageId();
    }

    @Override // com.yandex.mobile.ads.impl.gi2
    public final Map<String, String> getParameters() {
        Map<String, String> parameters = this.f8627a.getParameters();
        if (parameters != null) {
            return parameters;
        }
        Map<String, String> mapEmptyMap = Collections.emptyMap();
        Intrinsics.checkNotNullExpressionValue(mapEmptyMap, "emptyMap(...)");
        return mapEmptyMap;
    }
}
