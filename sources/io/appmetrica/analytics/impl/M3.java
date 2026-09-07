package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class M3 implements V7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L3 f11253a;
    public final List b;

    public M3(L3 l3, List<L3> list) {
        this.f11253a = l3;
        this.b = list;
    }

    public final M3 a(L3 l3, List<L3> list) {
        return new M3(l3, list);
    }

    @Override // io.appmetrica.analytics.impl.V7
    public final Object b() {
        return this.f11253a;
    }

    public final L3 c() {
        return this.f11253a;
    }

    public final List<L3> d() {
        return this.b;
    }

    public final L3 e() {
        return this.f11253a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M3)) {
            return false;
        }
        M3 m3 = (M3) obj;
        return Intrinsics.areEqual(this.f11253a, m3.f11253a) && Intrinsics.areEqual(this.b, m3.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f11253a.hashCode() * 31);
    }

    public final String toString() {
        return "ClidsInfo(chosen=" + this.f11253a + ", candidates=" + this.b + ')';
    }

    public static M3 a(M3 m3, L3 l3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l3 = m3.f11253a;
        }
        if ((i & 2) != 0) {
            list = m3.b;
        }
        m3.getClass();
        return new M3(l3, list);
    }

    @Override // io.appmetrica.analytics.impl.V7
    public final List<L3> a() {
        return this.b;
    }
}
