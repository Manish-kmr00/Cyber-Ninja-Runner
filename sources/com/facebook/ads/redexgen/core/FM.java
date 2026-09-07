package com.facebook.ads.redexgen.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FM extends AnimatorListenerAdapter {
    public final /* synthetic */ FN A00;

    public FM(FN fn) {
        this.A00 = fn;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(250L);
        layoutTransition.setDuration(3, 0L);
        layoutTransition.addTransitionListener(new FL(this));
        this.A00.A00.A0H.setLayoutTransition(layoutTransition);
        ((FH) this.A00.A00).A09.setVisibility(8);
        this.A00.A00.A0L.setVisibility(8);
        this.A00.A00.A0K.setVisibility(8);
    }
}
