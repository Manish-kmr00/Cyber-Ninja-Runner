package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class L3 implements Y7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11236a;
    public final X7 b;

    public L3(Map<String, String> map, X7 x7) {
        this.f11236a = map;
        this.b = x7;
    }

    public final L3 a(Map<String, String> map, X7 x7) {
        return new L3(map, x7);
    }

    public final Map<String, String> b() {
        return this.f11236a;
    }

    public final X7 c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.f11236a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof L3)) {
            return false;
        }
        L3 l3 = (L3) obj;
        return Intrinsics.areEqual(this.f11236a, l3.f11236a) && this.b == l3.b;
    }

    public final int hashCode() {
        Map map = this.f11236a;
        return this.b.hashCode() + ((map == null ? 0 : map.hashCode()) * 31);
    }

    public final String toString() {
        return "Candidate(clids=" + this.f11236a + ", source=" + this.b + ')';
    }

    public static L3 a(L3 l3, Map map, X7 x7, int i, Object obj) {
        if ((i & 1) != 0) {
            map = l3.f11236a;
        }
        if ((i & 2) != 0) {
            x7 = l3.b;
        }
        l3.getClass();
        return new L3(map, x7);
    }

    @Override // io.appmetrica.analytics.impl.Y7
    public final X7 a() {
        return this.b;
    }
}
