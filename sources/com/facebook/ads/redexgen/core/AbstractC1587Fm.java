package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1587Fm {
    public static final int A00 = D3.A00();

    public static void A00(C2699k1 c2699k1, ViewGroup viewGroup, String str) {
        new AsyncTaskC2494gc(viewGroup, c2699k1).A07(str);
        View view = new View(c2699k1);
        view.setId(A00);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        D3.A0P(view, c2699k1);
        viewGroup.addView(view, 0);
    }
}
