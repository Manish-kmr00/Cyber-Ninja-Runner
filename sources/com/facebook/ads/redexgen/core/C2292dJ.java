package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2292dJ implements GX {
    public final /* synthetic */ C2291dI A00;

    public C2292dJ(C2291dI c2291dI) {
        this.A00 = c2291dI;
    }

    @Override // com.facebook.ads.redexgen.core.GX
    public final void AFe(View view) {
        if (this.A00.A09) {
            this.A00.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.GX
    public final void AFg(View view) {
        AbstractC2445fo abstractC2445fo = (AbstractC2445fo) view;
        abstractC2445fo.A1D();
        if (this.A00.A09) {
            this.A00.A07 = true;
        }
        if (this.A00.A04.A0Z() && ((Integer) abstractC2445fo.getTag(-1593835536)).intValue() == 0) {
            this.A00.A04.A0U();
        }
    }
}
