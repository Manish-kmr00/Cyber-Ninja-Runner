package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class S5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3190a;
    public final Integer b;

    public S5(int i) {
        this.f3190a = i;
        this.b = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S5)) {
            return false;
        }
        S5 s5 = (S5) obj;
        return this.f3190a == s5.f3190a && Intrinsics.areEqual(this.b, s5.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f3190a) * 31;
        Integer num = this.b;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public final String toString() {
        return "OpenRequestResultData(result=" + this.f3190a + ", errorCode=" + this.b + ')';
    }

    public S5(int i, Integer num) {
        this.f3190a = i;
        this.b = num;
    }
}
