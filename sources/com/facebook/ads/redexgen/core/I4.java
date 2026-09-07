package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class I4 implements Runnable {
    public final /* synthetic */ C2250cd A00;

    public I4(C2250cd c2250cd) {
        this.A00 = c2250cd;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0C() == 0) {
                return;
            }
            this.A00.A05.scrollBy(this.A00.A01, 0);
            this.A00.A04.postDelayed(this, 16L);
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
