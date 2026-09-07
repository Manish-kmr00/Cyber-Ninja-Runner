package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.c7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2218c7 implements IN {
    public final View A00;
    public final C2699k1 A01;

    public C2218c7(C2699k1 c2699k1, View view) {
        this.A01 = c2699k1;
        this.A00 = view;
    }

    @Override // com.facebook.ads.redexgen.core.IN
    public final double A9L() {
        JM result = JL.A0E(this.A00, 0, this.A01);
        return result.A00();
    }
}
