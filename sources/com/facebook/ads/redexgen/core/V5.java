package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class V5 {
    public final InterfaceC1957Uo A00;

    public abstract boolean A0B(C2447fq c2447fq) throws Q6;

    public abstract boolean A0C(C2447fq c2447fq, long j) throws Q6;

    public V5(InterfaceC1957Uo interfaceC1957Uo) {
        this.A00 = interfaceC1957Uo;
    }

    public final boolean A00(C2447fq c2447fq, long j) throws Q6 {
        return A0B(c2447fq) && A0C(c2447fq, j);
    }
}
