package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2498gg extends BY {
    public final WeakReference<JL> A00;

    public C2498gg(JL jl) {
        this.A00 = new WeakReference<>(jl);
    }

    public C2498gg(WeakReference<JL> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        JL viewabilityChecker = this.A00.get();
        if (viewabilityChecker != null) {
            viewabilityChecker.A0U();
        }
    }
}
