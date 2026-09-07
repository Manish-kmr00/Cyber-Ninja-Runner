package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes12.dex */
public final class yw1 {
    public static final yw1 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10776a;
    public final long b;

    static {
        yw1 yw1Var = new yw1(0L, 0L);
        new yw1(Long.MAX_VALUE, Long.MAX_VALUE);
        new yw1(Long.MAX_VALUE, 0L);
        new yw1(0L, Long.MAX_VALUE);
        c = yw1Var;
    }

    public yw1(long j, long j2) {
        hg.a(j >= 0);
        hg.a(j2 >= 0);
        this.f10776a = j;
        this.b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || yw1.class != obj.getClass()) {
            return false;
        }
        yw1 yw1Var = (yw1) obj;
        return this.f10776a == yw1Var.f10776a && this.b == yw1Var.b;
    }

    public final int hashCode() {
        return (((int) this.f10776a) * 31) + ((int) this.b);
    }
}
