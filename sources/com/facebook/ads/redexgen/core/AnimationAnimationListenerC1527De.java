package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.view.animation.Animation;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.De, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnimationAnimationListenerC1527De implements Animation.AnimationListener {
    public final /* synthetic */ C13656e A00;
    public final /* synthetic */ AbstractC2561hh A01;
    public final /* synthetic */ AbstractC2561hh A02;

    public AnimationAnimationListenerC1527De(AbstractC2561hh abstractC2561hh, AbstractC2561hh abstractC2561hh2, C13656e c13656e) {
        this.A01 = abstractC2561hh;
        this.A02 = abstractC2561hh2;
        this.A00 = c13656e;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.A01.A04 = false;
        D3.A0F(this.A02);
        new Handler().postDelayed(new C2564hl(this), 200L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
