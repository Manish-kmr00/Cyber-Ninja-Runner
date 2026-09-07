package com.facebook.ads.redexgen.core;

import android.view.animation.Animation;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class DW implements Animation.AnimationListener {
    public final /* synthetic */ ViewOnClickListenerC1755Lz A00;

    public DW(ViewOnClickListenerC1755Lz viewOnClickListenerC1755Lz) {
        this.A00 = viewOnClickListenerC1755Lz;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        ((C2572hu) this.A00).A07.finish(16);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
