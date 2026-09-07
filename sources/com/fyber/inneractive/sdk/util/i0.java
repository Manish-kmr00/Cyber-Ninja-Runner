package com.fyber.inneractive.sdk.util;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2365a;
    public int b;

    public i0(int i, int i2) {
        this.f2365a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i0.class != obj.getClass()) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.f2365a == i0Var.f2365a && this.b == i0Var.b;
    }

    public final int hashCode() {
        return (this.f2365a * 31) + this.b;
    }
}
