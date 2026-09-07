package com.inmobi.media;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class N1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3141a;
    public final String b;
    public final Map c;

    public N1(int i, String str, Map map) {
        this.f3141a = i;
        this.b = str;
        this.c = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N1)) {
            return false;
        }
        N1 n1 = (N1) obj;
        return this.f3141a == n1.f3141a && Intrinsics.areEqual(this.b, n1.b) && Intrinsics.areEqual(this.c, n1.c);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f3141a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map map = this.c;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        return "BusEvent(eventId=" + this.f3141a + ", eventMessage=" + this.b + ", eventData=" + this.c + ')';
    }

    public N1(int i, String str, Map map, int i2) {
        str = (i2 & 2) != 0 ? null : str;
        map = (i2 & 4) != 0 ? null : map;
        this.f3141a = i;
        this.b = str;
        this.c = map;
    }
}
