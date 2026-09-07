package com.facebook.ads.redexgen.core;

import android.text.TextUtils;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.d4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2277d4 extends JK {
    public final /* synthetic */ C1713Ki A00;

    public C2277d4(C1713Ki c1713Ki) {
        this.A00 = c1713Ki;
    }

    @Override // com.facebook.ads.redexgen.core.JK
    public final void A03() {
        if (!this.A00.A0E.A07()) {
            this.A00.setImpressionRecordingFlag(this.A00.A0E);
            if (!TextUtils.isEmpty(this.A00.A0A)) {
                ((AbstractC2561hh) ((AbstractC2561hh) this.A00)).A0C.AB0(this.A00.A0A, new FB().A03(this.A00.A09).A02(this.A00.A0E).A04(((AbstractC2561hh) ((AbstractC2561hh) this.A00)).A0A.A0h()).A05());
                C12672h.A07(((AbstractC2561hh) ((AbstractC2561hh) this.A00)).A0A.A1c(), this.A00.A0D);
                this.A00.A0D.A0F().A3B();
                AbstractC12863a.A02(this.A00.A03.A0g(), AbstractC1501Ce.A00(((AbstractC2561hh) ((AbstractC2561hh) this.A00)).A0A.A0i()));
            }
        }
    }
}
