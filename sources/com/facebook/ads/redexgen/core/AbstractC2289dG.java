package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2289dG {
    public InterfaceC2288dF A00;
    public InterfaceC2301dS A01;

    public abstract boolean A0Y();

    public abstract C2290dH A0b(InterfaceC1854Qi[] interfaceC1854QiArr, C1863Qs c1863Qs, R5 r5, Timeline timeline) throws EK;

    public abstract void A0c(Object obj);

    public final InterfaceC2301dS A00() {
        return (InterfaceC2301dS) AbstractC2388es.A02(this.A01);
    }

    public final void A01() {
        if (this.A00 != null) {
            this.A00.AFL();
        }
    }

    public final void A02(InterfaceC2288dF interfaceC2288dF, InterfaceC2301dS interfaceC2301dS) {
        this.A00 = interfaceC2288dF;
        this.A01 = interfaceC2301dS;
    }
}
