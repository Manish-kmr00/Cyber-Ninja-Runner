package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class jr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f9348a;
    private final Integer b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jr0)) {
            return false;
        }
        jr0 jr0Var = (jr0) obj;
        return Intrinsics.areEqual(this.f9348a, jr0Var.f9348a) && Intrinsics.areEqual(this.b, jr0Var.b);
    }

    public final int hashCode() {
        Integer num = this.f9348a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        return "LayoutParamsSize(width=" + this.f9348a + ", height=" + this.b + ")";
    }

    public jr0(Integer num, Integer num2) {
        this.f9348a = num;
        this.b = num2;
    }

    public final Integer b() {
        return this.f9348a;
    }

    public final Integer a() {
        return this.b;
    }
}
