package com.facebook.ads.redexgen.core;

import android.animation.Animator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Iw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1675Iw implements Animator.AnimatorListener {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C2145at A02;

    public C1675Iw(C2145at c2145at, int i, int i2) {
        this.A02 = c2145at;
        this.A01 = i;
        this.A00 = i2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A02.A07(this.A00, this.A01, false);
        if (this.A02.A00 == null) {
            return;
        }
        this.A02.A00.removeAllListeners();
        this.A02.A00 = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        EnumC1668Ip enumC1668Ip;
        C2145at c2145at = this.A02;
        if (this.A01 == this.A02.A04) {
            enumC1668Ip = EnumC1668Ip.A02;
        } else {
            enumC1668Ip = EnumC1668Ip.A04;
        }
        c2145at.A01 = enumC1668Ip;
        if (this.A02.A00 == null) {
            return;
        }
        this.A02.A00.removeAllListeners();
        this.A02.A00 = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
