package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c60 f8478a;
    private final String b;

    public b60(c60 type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f8478a = type;
        this.b = value;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b60)) {
            return false;
        }
        b60 b60Var = (b60) obj;
        return this.f8478a == b60Var.f8478a && Intrinsics.areEqual(this.b, b60Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f8478a.hashCode() * 31);
    }

    public final String toString() {
        return "ExclusionRule(type=" + this.f8478a + ", value=" + this.b + ")";
    }

    public final c60 a() {
        return this.f8478a;
    }

    public final String b() {
        return this.b;
    }
}
