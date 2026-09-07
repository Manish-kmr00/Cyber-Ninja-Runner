package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class P8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I3 f3168a;
    public final String b;

    public P8(I3 errorCode, String str) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.f3168a = errorCode;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P8)) {
            return false;
        }
        P8 p8 = (P8) obj;
        return this.f3168a == p8.f3168a && Intrinsics.areEqual(this.b, p8.b);
    }

    public final int hashCode() {
        int iHashCode = this.f3168a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "NetworkError(errorCode=" + this.f3168a + ", errorMessage=" + this.b + ')';
    }
}
