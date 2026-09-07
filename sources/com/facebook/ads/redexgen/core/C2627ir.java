package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ir, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2627ir implements AP {
    public WeakReference<C2615ie> A00;

    public C2627ir(C2615ie c2615ie) {
        this.A00 = new WeakReference<>(c2615ie);
    }

    @Override // com.facebook.ads.redexgen.core.AP
    public final void AEQ(boolean z) {
        if (this.A00.get() != null) {
            this.A00.get().A1f(z, false);
        }
    }
}
