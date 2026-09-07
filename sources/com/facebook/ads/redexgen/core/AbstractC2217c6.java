package com.facebook.ads.redexgen.core;

import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.c6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2217c6 extends RelativeLayout implements IQ {
    public C2232cL A00;

    public AbstractC2217c6(C2699k1 c2699k1) {
        super(c2699k1);
    }

    public AbstractC2217c6(C2699k1 c2699k1, AttributeSet attributeSet, int i) {
        super(c2699k1, attributeSet, i);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(params);
    }

    public void A07() {
    }

    public void A08() {
    }

    @Override // com.facebook.ads.redexgen.core.IQ
    public final void AAk(C2232cL c2232cL) {
        this.A00 = c2232cL;
        A07();
    }

    @Override // com.facebook.ads.redexgen.core.IQ
    public final void AJa(C2232cL c2232cL) {
        A08();
        this.A00 = null;
    }

    public C2232cL getVideoView() {
        return this.A00;
    }
}
