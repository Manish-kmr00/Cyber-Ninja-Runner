package com.moloco.sdk.internal.services.bidtoken.providers;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f6338a;
    public final Long b;
    public final Long c;

    public p() {
        this(null, null, null, 7, null);
    }

    public final Boolean a() {
        return this.f6338a;
    }

    public final Long b() {
        return this.b;
    }

    public final Long c() {
        return this.c;
    }

    public final Boolean d() {
        return this.f6338a;
    }

    public final Long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Intrinsics.areEqual(this.f6338a, pVar.f6338a) && Intrinsics.areEqual(this.b, pVar.b) && Intrinsics.areEqual(this.c, pVar.c);
    }

    public final Long f() {
        return this.c;
    }

    public int hashCode() {
        Boolean bool = this.f6338a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l = this.b;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.c;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "MemoryInfoSignal(lowMemory=" + this.f6338a + ", threshold=" + this.b + ", totalMem=" + this.c + ')';
    }

    public p(Boolean bool, Long l, Long l2) {
        this.f6338a = bool;
        this.b = l;
        this.c = l2;
    }

    public final p a(Boolean bool, Long l, Long l2) {
        return new p(bool, l, l2);
    }

    public static /* synthetic */ p a(p pVar, Boolean bool, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = pVar.f6338a;
        }
        if ((i & 2) != 0) {
            l = pVar.b;
        }
        if ((i & 4) != 0) {
            l2 = pVar.c;
        }
        return pVar.a(bool, l, l2);
    }

    public /* synthetic */ p(Boolean bool, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
    }
}
