package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ig<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9213a;
    private final String b;
    private final T c;
    private final rr0 d;
    private final boolean e;
    private final boolean f;

    public ig(String name, String type, T t, rr0 rr0Var, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.f9213a = name;
        this.b = type;
        this.c = t;
        this.d = rr0Var;
        this.e = z;
        this.f = z2;
    }

    public static ig a(ig igVar, ax0 ax0Var) {
        String name = igVar.f9213a;
        String type = igVar.b;
        rr0 rr0Var = igVar.d;
        boolean z = igVar.e;
        boolean z2 = igVar.f;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new ig(name, type, ax0Var, rr0Var, z, z2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ig)) {
            return false;
        }
        ig igVar = (ig) obj;
        return Intrinsics.areEqual(this.f9213a, igVar.f9213a) && Intrinsics.areEqual(this.b, igVar.b) && Intrinsics.areEqual(this.c, igVar.c) && Intrinsics.areEqual(this.d, igVar.d) && this.e == igVar.e && this.f == igVar.f;
    }

    public final int hashCode() {
        int iA = v3.a(this.b, this.f9213a.hashCode() * 31, 31);
        T t = this.c;
        int iHashCode = (iA + (t == null ? 0 : t.hashCode())) * 31;
        rr0 rr0Var = this.d;
        return Boolean.hashCode(this.f) + a7.a(this.e, (iHashCode + (rr0Var != null ? rr0Var.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        return "Asset(name=" + this.f9213a + ", type=" + this.b + ", value=" + this.c + ", link=" + this.d + ", isClickable=" + this.e + ", isRequired=" + this.f + ")";
    }

    public final String b() {
        return this.f9213a;
    }

    public final String c() {
        return this.b;
    }

    public final T d() {
        return this.c;
    }

    public final boolean e() {
        return this.e;
    }

    public final rr0 a() {
        return this.d;
    }

    public final boolean f() {
        return this.f;
    }
}
