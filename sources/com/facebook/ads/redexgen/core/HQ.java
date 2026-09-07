package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class HQ implements Runnable {
    public final /* synthetic */ C1714Kj A00;

    public HQ(C1714Kj c1714Kj) {
        this.A00 = c1714Kj;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            ((AbstractC2347eD) this.A00).A09.A4Z(((AbstractC2347eD) this.A00).A0A.A7m());
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
