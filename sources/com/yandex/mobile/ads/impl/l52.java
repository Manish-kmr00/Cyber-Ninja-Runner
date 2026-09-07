package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9480a;
    private final au1 b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l52)) {
            return false;
        }
        l52 l52Var = (l52) obj;
        return Intrinsics.areEqual(this.f9480a, l52Var.f9480a) && this.b == l52Var.b;
    }

    public final int hashCode() {
        String str = this.f9480a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        au1 au1Var = this.b;
        return iHashCode + (au1Var != null ? au1Var.hashCode() : 0);
    }

    public final String toString() {
        return "TokenResult(bidderToken=" + this.f9480a + ", stubReason=" + this.b + ")";
    }

    public l52(String str, au1 au1Var) {
        this.f9480a = str;
        this.b = au1Var;
    }

    public final String a() {
        return this.f9480a;
    }

    public final au1 b() {
        return this.b;
    }
}
