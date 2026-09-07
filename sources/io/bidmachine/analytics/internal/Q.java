package io.bidmachine.analytics.internal;

import java.util.Map;
import java.util.UUID;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class Q {
    public static final a g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12058a;
    private final String b;
    private final String c;
    private final long d;
    private final Map e;
    private final q0 f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Q(String str, String str2, String str3, long j, Map map, q0 q0Var) {
        this.f12058a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = map;
        this.f = q0Var;
    }

    public final Q a(String str, String str2, String str3, long j, Map map, q0 q0Var) {
        return new Q(str, str2, str3, j, map, q0Var);
    }

    public final q0 b() {
        return this.f;
    }

    public final String c() {
        return this.f12058a;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q)) {
            return false;
        }
        Q q = (Q) obj;
        return Intrinsics.areEqual(this.f12058a, q.f12058a) && Intrinsics.areEqual(this.b, q.b) && Intrinsics.areEqual(this.c, q.c) && this.d == q.d && Intrinsics.areEqual(this.e, q.e) && Intrinsics.areEqual(this.f, q.f);
    }

    public final long f() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.f12058a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31;
        q0 q0Var = this.f;
        return iHashCode + (q0Var == null ? 0 : q0Var.hashCode());
    }

    public String toString() {
        return "MonitorRecord(id=" + this.f12058a + ", name=" + this.b + ", sessionId=" + this.c + ", timestamp=" + this.d + ", data=" + this.e + ", error=" + this.f + ')';
    }

    public /* synthetic */ Q(String str, String str2, String str3, long j, Map map, q0 q0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UUID.randomUUID().toString() : str, str2, str3, (i & 8) != 0 ? System.currentTimeMillis() : j, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? null : q0Var);
    }

    public static /* synthetic */ Q a(Q q, String str, String str2, String str3, long j, Map map, q0 q0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            str = q.f12058a;
        }
        if ((i & 2) != 0) {
            str2 = q.b;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = q.c;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            j = q.d;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            map = q.e;
        }
        Map map2 = map;
        if ((i & 32) != 0) {
            q0Var = q.f;
        }
        return q.a(str, str4, str5, j2, map2, q0Var);
    }

    public final Map a() {
        return this.e;
    }
}
