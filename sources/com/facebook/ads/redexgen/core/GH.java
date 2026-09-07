package com.facebook.ads.redexgen.core;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class GH implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C2451fu A00;

    public GH(C2451fu c2451fu) {
        this.A00 = c2451fu;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        this.A00.A0A.getLayoutParams().height = num.intValue();
        this.A00.A0A.requestLayout();
    }
}
