package com.facebook.ads.redexgen.core;

import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8q, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC14288q extends AbstractC2012Wu implements InterfaceC2013Wv {
    public long A00;
    public InterfaceC2013Wv A01;

    @Override // com.facebook.ads.redexgen.core.AbstractC2012Wu
    public abstract void A0B();

    @Override // com.facebook.ads.redexgen.core.AbstractC1902Sf
    public final void A0A() {
        super.A0A();
        this.A01 = null;
    }

    public final void A0C(long j, InterfaceC2013Wv interfaceC2013Wv, long j2) {
        super.A01 = j;
        this.A01 = interfaceC2013Wv;
        if (j2 == Long.MAX_VALUE) {
            j2 = super.A01;
        }
        this.A00 = j2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final List<C1853Qh> A7N(long j) {
        return ((InterfaceC2013Wv) AbstractC2388es.A01(this.A01)).A7N(j - this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final long A7t(int i) {
        return ((InterfaceC2013Wv) AbstractC2388es.A01(this.A01)).A7t(i) + this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final int A7u() {
        return ((InterfaceC2013Wv) AbstractC2388es.A01(this.A01)).A7u();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final int A8Q(long j) {
        return ((InterfaceC2013Wv) AbstractC2388es.A01(this.A01)).A8Q(j - this.A00);
    }
}
