package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.e9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RunnableC2343e9 implements Runnable {
    public final InterfaceC2342e8 A00;

    public RunnableC2343e9(InterfaceC2342e8 interfaceC2342e8) {
        this.A00 = interfaceC2342e8;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.ADx();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
