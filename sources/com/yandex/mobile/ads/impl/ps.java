package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9947a;
    private final h9 b;
    private final String c;

    public ps(String adUnitId, h9 h9Var, String str) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.f9947a = adUnitId;
        this.b = h9Var;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ps)) {
            return false;
        }
        ps psVar = (ps) obj;
        return Intrinsics.areEqual(this.f9947a, psVar.f9947a) && Intrinsics.areEqual(this.b, psVar.b) && Intrinsics.areEqual(this.c, psVar.c);
    }

    public final int hashCode() {
        int iHashCode = this.f9947a.hashCode() * 31;
        h9 h9Var = this.b;
        int iHashCode2 = (iHashCode + (h9Var == null ? 0 : h9Var.hashCode())) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "CoreAdInfo(adUnitId=" + this.f9947a + ", adSize=" + this.b + ", data=" + this.c + ")";
    }

    public final String b() {
        return this.f9947a;
    }

    public final h9 a() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
