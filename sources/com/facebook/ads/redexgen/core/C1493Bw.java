package com.facebook.ads.redexgen.core;

import android.app.Activity;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1493Bw {
    public static final C1493Bw A04 = new C1493Bw(new C2598iM(), new C2597iL());
    public final InterfaceC1492Bv A02;
    public final InterfaceC1516Ct A03;
    public boolean A01 = true;
    public long A00 = -1;

    public C1493Bw(InterfaceC1516Ct interfaceC1516Ct, InterfaceC1492Bv interfaceC1492Bv) {
        this.A03 = interfaceC1516Ct;
        this.A02 = interfaceC1492Bv;
    }

    public static C1493Bw A00() {
        return A04;
    }

    public final synchronized void A01() {
        this.A01 = false;
        this.A00 = this.A03.A5d();
    }

    public final synchronized void A02() {
        this.A00 = -1L;
    }

    public final boolean A03() {
        Activity lastResumedActivity = this.A02.A8C();
        boolean z = true;
        if (lastResumedActivity != null) {
            return true;
        }
        synchronized (C1493Bw.class) {
            if (this.A01) {
                return true;
            }
            if (this.A00 >= 0 && this.A03.A5d() - this.A00 >= 1000) {
                z = false;
            }
            return z;
        }
    }
}
