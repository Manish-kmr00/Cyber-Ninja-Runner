package com.facebook.ads.redexgen.core;

import android.view.animation.Animation;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ds, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2326ds extends D2 {
    public final /* synthetic */ C2320dl A00;

    public C2326ds(C2320dl c2320dl) {
        this.A00 = c2320dl;
    }

    @Override // com.facebook.ads.redexgen.core.D2, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        D3.A0F(this.A00.A01);
        this.A00.A00.ADa();
    }
}
