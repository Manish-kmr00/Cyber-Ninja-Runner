package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1702Jx implements Runnable {
    public final /* synthetic */ C2110aI A00;

    public RunnableC1702Jx(C2110aI c2110aI) {
        this.A00 = c2110aI;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            C2110aI.A03(this.A00);
            throw null;
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
