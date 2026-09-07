package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PI {
    public long A00 = Long.MIN_VALUE;
    public long A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;

    public final PI A05(long j) {
        AbstractC2388es.A07(j == Long.MIN_VALUE || j >= 0);
        this.A00 = j;
        return this;
    }

    public final PI A06(long j) {
        AbstractC2388es.A07(j >= 0);
        this.A01 = j;
        return this;
    }

    public final PI A07(boolean z) {
        this.A02 = z;
        return this;
    }

    public final PI A08(boolean z) {
        this.A03 = z;
        return this;
    }

    public final PI A09(boolean z) {
        this.A04 = z;
        return this;
    }

    public final E1 A0A() {
        return A0B();
    }

    @Deprecated
    public final E1 A0B() {
        return new E1(this);
    }
}
