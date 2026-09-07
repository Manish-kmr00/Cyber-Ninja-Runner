package com.yandex.mobile.ads.impl;

import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes13.dex */
final class ow0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rw0.b f9869a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    ow0(rw0.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        hg.a(!z4 || z2);
        hg.a(!z3 || z2);
        if (!z || (!z2 && !z3 && !z4)) {
            z5 = true;
        }
        hg.a(z5);
        this.f9869a = bVar;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ow0.class != obj.getClass()) {
            return false;
        }
        ow0 ow0Var = (ow0) obj;
        return this.b == ow0Var.b && this.c == ow0Var.c && this.d == ow0Var.d && this.e == ow0Var.e && this.f == ow0Var.f && this.g == ow0Var.g && this.h == ow0Var.h && this.i == ow0Var.i && x82.a(this.f9869a, ow0Var.f9869a);
    }

    public final int hashCode() {
        return ((((((((((((((((this.f9869a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + ((int) this.b)) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }
}
