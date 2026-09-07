package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f5 f8761a;
    private final Map<String, Object> b;

    public e5(f5 adLoadingPhaseType, Map<String, ? extends Object> reportParameters) {
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        Intrinsics.checkNotNullParameter(reportParameters, "reportParameters");
        this.f8761a = adLoadingPhaseType;
        this.b = reportParameters;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e5)) {
            return false;
        }
        e5 e5Var = (e5) obj;
        return this.f8761a == e5Var.f8761a && Intrinsics.areEqual(this.b, e5Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f8761a.hashCode() * 31);
    }

    public final String toString() {
        return "AdLoadingPhase(adLoadingPhaseType=" + this.f8761a + ", reportParameters=" + this.b + ")";
    }

    public final f5 a() {
        return this.f8761a;
    }

    public final Map<String, Object> b() {
        return this.b;
    }
}
