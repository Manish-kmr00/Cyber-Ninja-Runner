package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ml0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9649a;
    private final int b;
    private final int c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ml0)) {
            return false;
        }
        ml0 ml0Var = (ml0) obj;
        return Intrinsics.areEqual(this.f9649a, ml0Var.f9649a) && this.b == ml0Var.b && this.c == ml0Var.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + wx1.a(this.b, this.f9649a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "InstalledPackage(name=" + this.f9649a + ", minVersion=" + this.b + ", maxVersion=" + this.c + ")";
    }

    public ml0(int i, int i2, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f9649a = name;
        this.b = i;
        this.c = i2;
    }
}
