package io.bidmachine.analytics.internal;

import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12089a;
    private final String b;
    private final long c;
    private final String d;
    private final a e;
    private final q0 f;
    private final boolean g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12090a;
        private final String b;

        public a(String str, String str2) {
            this.f12090a = str;
            this.b = str2;
        }

        public final String a() {
            return this.b;
        }

        public final String b() {
            return this.f12090a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f12090a, aVar.f12090a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.f12090a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Rule(tag=" + this.f12090a + ", path=" + this.b + ')';
        }
    }

    public h0(String str, String str2, long j, String str3, a aVar, q0 q0Var, boolean z) {
        this.f12089a = str;
        this.b = str2;
        this.c = j;
        this.d = str3;
        this.e = aVar;
        this.f = q0Var;
        this.g = z;
    }

    public final h0 a(String str, String str2, long j, String str3, a aVar, q0 q0Var, boolean z) {
        return new h0(str, str2, j, str3, aVar, q0Var, z);
    }

    public final q0 b() {
        return this.f;
    }

    public final String c() {
        return this.f12089a;
    }

    public final String d() {
        return this.b;
    }

    public final a e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return Intrinsics.areEqual(this.f12089a, h0Var.f12089a) && Intrinsics.areEqual(this.b, h0Var.b) && this.c == h0Var.c && Intrinsics.areEqual(this.d, h0Var.d) && Intrinsics.areEqual(this.e, h0Var.e) && Intrinsics.areEqual(this.f, h0Var.f) && this.g == h0Var.g;
    }

    public final long f() {
        return this.c;
    }

    public final boolean g() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        int iHashCode = ((((((((this.f12089a.hashCode() * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        q0 q0Var = this.f;
        int iHashCode2 = (iHashCode + (q0Var == null ? 0 : q0Var.hashCode())) * 31;
        boolean z = this.g;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        return "ReaderRecord(id=" + this.f12089a + ", name=" + this.b + ", timestamp=" + this.c + ", dataHash=" + this.d + ", rule=" + this.e + ", error=" + this.f + ", isDirty=" + this.g + ')';
    }

    public /* synthetic */ h0(String str, String str2, long j, String str3, a aVar, q0 q0Var, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UUID.randomUUID().toString() : str, str2, (i & 4) != 0 ? System.currentTimeMillis() : j, str3, aVar, (i & 32) != 0 ? null : q0Var, (i & 64) != 0 ? true : z);
    }

    public final String a() {
        return this.d;
    }
}
