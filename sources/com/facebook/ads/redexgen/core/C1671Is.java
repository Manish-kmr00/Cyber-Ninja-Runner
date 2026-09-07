package com.facebook.ads.redexgen.core;

import android.animation.Animator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Is, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1671Is implements Animator.AnimatorListener {
    public final /* synthetic */ C2148aw A00;

    public C1671Is(C2148aw c2148aw) {
        this.A00 = c2148aw;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A00.A08(false);
        if (this.A00.A01 == null) {
            return;
        }
        this.A00.A01.removeAllListeners();
        this.A00.A01 = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.A00.A02 = EnumC1668Ip.A04;
        D3.A0F(this.A00.A05);
        if (this.A00.A01 == null) {
            return;
        }
        this.A00.A01.removeAllListeners();
        this.A00.A01 = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
