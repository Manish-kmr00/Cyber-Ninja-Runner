package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1761Mh extends AbstractC2580i2<C2828mB> {
    public C1761Mh(C2828mB c2828mB) {
        super(c2828mB);
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        C2828mB c2828mBA06 = A06();
        if (c2828mBA06 == null) {
            return;
        }
        if (DK.A02(c2828mBA06.A08)) {
            c2828mBA06.A07();
        } else {
            c2828mBA06.A05.postDelayed(c2828mBA06.A0C, 5000L);
        }
    }
}
