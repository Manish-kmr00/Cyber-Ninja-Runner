package com.facebook.ads.redexgen.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class HB extends AnimatorListenerAdapter {
    public final /* synthetic */ C1722Kr A00;
    public final /* synthetic */ boolean A01;

    public HB(C1722Kr c1722Kr, boolean z) {
        this.A00 = c1722Kr;
        this.A01 = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.A00.A0H.setTranslationY(0.0f);
        this.A00.A0U();
        if (this.A01 || this.A00.A0G == null) {
            return;
        }
        this.A00.A0G.destroy();
    }
}
