package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class GJ implements Runnable {
    public final /* synthetic */ C2451fu A00;

    public GJ(C2451fu c2451fu) {
        this.A00 = c2451fu;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A0P) {
                return;
            }
            this.A00.A0N();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
