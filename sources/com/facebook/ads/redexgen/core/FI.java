package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FI implements Runnable {
    public final /* synthetic */ AbstractC2493gb A00;

    public FI(AbstractC2493gb abstractC2493gb) {
        this.A00 = abstractC2493gb;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0F.getVisibility() == 0) {
                this.A00.A0R(8);
            }
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
