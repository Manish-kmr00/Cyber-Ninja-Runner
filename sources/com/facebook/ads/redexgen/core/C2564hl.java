package com.facebook.ads.redexgen.core;

import android.R;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2564hl extends BY {
    public final /* synthetic */ AnimationAnimationListenerC1527De A00;

    public C2564hl(AnimationAnimationListenerC1527De animationAnimationListenerC1527De) {
        this.A00 = animationAnimationListenerC1527De;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        this.A00.A00.finish(3);
        this.A00.A00.A05().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
