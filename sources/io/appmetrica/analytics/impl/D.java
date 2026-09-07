package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11095a;
    public final int b;
    public final int c;

    public D(int i, int i2, int i3) {
        this.f11095a = i;
        this.b = i2;
        this.c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(D.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.impl.id.AdvIdGetterController.CanTrackIdentifiers");
        }
        D d = (D) obj;
        return this.f11095a == d.f11095a && this.b == d.b && this.c == d.c;
    }

    public final int hashCode() {
        return Q7.a(this.c) + ((Q7.a(this.b) + (Q7.a(this.f11095a) * 31)) * 31);
    }

    public final String toString() {
        return "CanTrackIdentifiers(canTrackGaid=" + E.a(this.f11095a) + ", canTrackHoaid=" + E.a(this.b) + ", canTrackYandexAdvId=" + E.a(this.c) + ')';
    }
}
