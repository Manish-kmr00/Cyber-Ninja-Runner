package com.facebook.ads.redexgen.core;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2248cb extends C1581Fg {
    public final ImageView A00;
    public final C2699k1 A01;

    public C2248cb(C2699k1 c2699k1) {
        super(c2699k1);
        this.A01 = c2699k1;
        this.A00 = new ImageView(c2699k1);
        this.A00.setAdjustViewBounds(true);
        addView(this.A00, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final void A00(String str) {
        AsyncTaskC2494gc downloadImageTask = new AsyncTaskC2494gc(this.A00, this.A01);
        downloadImageTask.A04();
        downloadImageTask.A07(str);
    }
}
