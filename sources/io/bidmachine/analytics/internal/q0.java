package io.bidmachine.analytics.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12171a;
    private final a b;
    private final String c;

    public enum a {
        UNKNOWN,
        MONITOR_INVALID,
        MONITOR_NO_CONTENT,
        MONITOR_BAD_CONTENT,
        READER_INVALID,
        READER_NO_CONTENT,
        READER_BAD_CONTENT,
        READER_NO_ACCESS
    }

    public q0(String str, a aVar, String str2) {
        this.f12171a = str;
        this.b = aVar;
        this.c = str2;
    }

    public final String a() {
        return this.f12171a;
    }

    public final String b() {
        return this.c;
    }

    public final a c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return Intrinsics.areEqual(this.f12171a, q0Var.f12171a) && this.b == q0Var.b && Intrinsics.areEqual(this.c, q0Var.c);
    }

    public int hashCode() {
        return (((this.f12171a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "TrackerError(name=" + this.f12171a + ", type=" + this.b + ", reason=" + this.c + ')';
    }

    public /* synthetic */ q0(String str, a aVar, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, aVar, (i & 4) != 0 ? "" : str2);
    }
}
