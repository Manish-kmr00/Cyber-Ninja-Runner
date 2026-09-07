package com.moloco.sdk.acm.db;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6006a;
    public final String b;
    public final long c;
    public final c d;
    public final Long e;
    public final List<String> f;

    public b(long j, String name, long j2, c eventType, Long l, List<String> tags) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.f6006a = j;
        this.b = name;
        this.c = j2;
        this.d = eventType;
        this.e = l;
        this.f = tags;
    }

    public final long a() {
        return this.f6006a;
    }

    public final String b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final c d() {
        return this.d;
    }

    public final Long e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6006a == bVar.f6006a && Intrinsics.areEqual(this.b, bVar.b) && this.c == bVar.c && this.d == bVar.d && Intrinsics.areEqual(this.e, bVar.e) && Intrinsics.areEqual(this.f, bVar.f);
    }

    public final List<String> f() {
        return this.f;
    }

    public final Long g() {
        return this.e;
    }

    public final c h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.f6006a) * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
        Long l = this.e;
        return ((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.f.hashCode();
    }

    public final long i() {
        return this.f6006a;
    }

    public final String j() {
        return this.b;
    }

    public final List<String> k() {
        return this.f;
    }

    public final long l() {
        return this.c;
    }

    public String toString() {
        return "EventEntity(id=" + this.f6006a + ", name=" + this.b + ", timestamp=" + this.c + ", eventType=" + this.d + ", data=" + this.e + ", tags=" + this.f + ')';
    }

    public final b a(long j, String name, long j2, c eventType, Long l, List<String> tags) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new b(j, name, j2, eventType, l, tags);
    }

    public /* synthetic */ b(long j, String str, long j2, c cVar, Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, j2, cVar, (i & 16) != 0 ? null : l, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }
}
