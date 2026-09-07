package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EB extends View {
    public EA A00;

    public EB(C2699k1 c2699k1, EA ea) {
        super(c2699k1);
        this.A00 = ea;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        EA ea = this.A00;
    }
}
