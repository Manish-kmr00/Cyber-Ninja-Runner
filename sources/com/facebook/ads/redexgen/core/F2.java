package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class F2 implements Runnable {
    public final /* synthetic */ F3 A00;
    public final /* synthetic */ F4 A01;

    public F2(F3 f3, F4 f4) {
        this.A00 = f3;
        this.A01 = f4;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A01.ACH();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
