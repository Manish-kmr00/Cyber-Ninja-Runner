package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1913Sq extends Thread {
    public final /* synthetic */ AbstractC2010Ws A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1913Sq(AbstractC2010Ws abstractC2010Ws, String str) {
        super(str);
        this.A00 = abstractC2010Ws;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A0R();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
