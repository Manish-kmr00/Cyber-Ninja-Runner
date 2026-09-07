package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class cl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qs f8621a;
    private final zy1 b;
    private final Map<String, String> c;

    public cl(qs qsVar, zy1 zy1Var, Map<String, String> parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.f8621a = qsVar;
        this.b = zy1Var;
        this.c = parameters;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cl)) {
            return false;
        }
        cl clVar = (cl) obj;
        return this.f8621a == clVar.f8621a && Intrinsics.areEqual(this.b, clVar.b) && Intrinsics.areEqual(this.c, clVar.c);
    }

    public final int hashCode() {
        qs qsVar = this.f8621a;
        int iHashCode = (qsVar == null ? 0 : qsVar.hashCode()) * 31;
        zy1 zy1Var = this.b;
        return this.c.hashCode() + ((iHashCode + (zy1Var != null ? zy1Var.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "BidderTokenRequestData(adType=" + this.f8621a + ", sizeInfo=" + this.b + ", parameters=" + this.c + ")";
    }

    public final qs a() {
        return this.f8621a;
    }

    public final zy1 c() {
        return this.b;
    }

    public final Map<String, String> b() {
        return this.c;
    }
}
