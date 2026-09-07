package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.x2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3620x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f3471a;
    public final String b;

    public C3620x2(byte b, String str) {
        this.f3471a = b;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3620x2)) {
            return false;
        }
        C3620x2 c3620x2 = (C3620x2) obj;
        return this.f3471a == c3620x2.f3471a && Intrinsics.areEqual(this.b, c3620x2.b);
    }

    public final int hashCode() {
        int iHashCode = Byte.hashCode(this.f3471a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "ConfigError(errorCode=" + ((int) this.f3471a) + ", errorMessage=" + this.b + ')';
    }
}
