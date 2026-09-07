package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qs f9390a;
    private final long b;
    private final o0.a c;
    private final j80 d;
    private final Map<String, Object> e;
    private final f f;

    public k80(qs adType, long j, o0.a activityInteractionType, j80 j80Var, Map<String, ? extends Object> reportData, f fVar) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(activityInteractionType, "activityInteractionType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        this.f9390a = adType;
        this.b = j;
        this.c = activityInteractionType;
        this.d = j80Var;
        this.e = reportData;
        this.f = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k80)) {
            return false;
        }
        k80 k80Var = (k80) obj;
        return this.f9390a == k80Var.f9390a && this.b == k80Var.b && this.c == k80Var.c && Intrinsics.areEqual(this.d, k80Var.d) && Intrinsics.areEqual(this.e, k80Var.e) && Intrinsics.areEqual(this.f, k80Var.f);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ((Long.hashCode(this.b) + (this.f9390a.hashCode() * 31)) * 31)) * 31;
        j80 j80Var = this.d;
        int iHashCode2 = (this.e.hashCode() + ((iHashCode + (j80Var == null ? 0 : j80Var.hashCode())) * 31)) * 31;
        f fVar = this.f;
        return iHashCode2 + (fVar != null ? fVar.hashCode() : 0);
    }

    public final String toString() {
        return "FalseClickData(adType=" + this.f9390a + ", startTime=" + this.b + ", activityInteractionType=" + this.c + ", falseClick=" + this.d + ", reportData=" + this.e + ", abExperiments=" + this.f + ")";
    }

    public final qs c() {
        return this.f9390a;
    }

    public final long f() {
        return this.b;
    }

    public final o0.a b() {
        return this.c;
    }

    public final j80 d() {
        return this.d;
    }

    public final Map<String, Object> e() {
        return this.e;
    }

    public final f a() {
        return this.f;
    }
}
