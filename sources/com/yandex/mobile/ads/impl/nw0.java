package com.yandex.mobile.ads.impl;

import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes6.dex */
public class nw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9759a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;

    public nw0(int i, long j, Object obj) {
        this(obj, -1, -1, j, i);
    }

    protected nw0(nw0 nw0Var) {
        this.f9759a = nw0Var.f9759a;
        this.b = nw0Var.b;
        this.c = nw0Var.c;
        this.d = nw0Var.d;
        this.e = nw0Var.e;
    }

    public final nw0 a(Object obj) {
        return this.f9759a.equals(obj) ? this : new nw0(obj, this.b, this.c, this.d, this.e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nw0)) {
            return false;
        }
        nw0 nw0Var = (nw0) obj;
        return this.f9759a.equals(nw0Var.f9759a) && this.b == nw0Var.b && this.c == nw0Var.c && this.d == nw0Var.d && this.e == nw0Var.e;
    }

    public final int hashCode() {
        return ((((((((this.f9759a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d)) * 31) + this.e;
    }

    public nw0(Object obj) {
        this(obj, -1L);
    }

    public final boolean a() {
        return this.b != -1;
    }

    public nw0(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    private nw0(Object obj, int i, int i2, long j, int i3) {
        this.f9759a = obj;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = i3;
    }

    public nw0(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }
}
