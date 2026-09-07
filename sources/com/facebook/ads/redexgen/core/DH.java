package com.facebook.ads.redexgen.core;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DH {
    public static DH A02;
    public final C2577hz A00;
    public final DJ A01;

    public DH(C2699k1 c2699k1, Executor executor, C14318t c14318t) {
        this.A01 = new DJ(c2699k1);
        this.A00 = new C2577hz(executor, c14318t, c2699k1);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(C2699k1 c2699k1, Executor executor, C14318t c14318t) {
        if (!C14499m.A1V(c2699k1)) {
            return;
        }
        if (A02 == null) {
            A02 = new DH(c2699k1, executor, c14318t);
            A02.A00();
        } else {
            A02.A02(c14318t);
        }
    }

    private void A02(C14318t c14318t) {
        this.A00.A07(c14318t);
    }
}
